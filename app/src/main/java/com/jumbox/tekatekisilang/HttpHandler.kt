package com.jumbox.tekatekisilang

import android.util.Log
import java.io.*
import android.os.AsyncTask
import java.net.*


/**
 *Created by Jumadi Janjaya
 *31, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

 class HttpHandler(var requestMethod: String, var reqUrl: String, var params: HashMap<String, String>?, private var listener: ResponseListener){

    private var asycData: AsycData

    init {
        if (params != null && requestMethod == HttpHandler.REQUEST_METHOD_GET) {
            reqUrl = "$reqUrl?${query(params!!)}"
        }
        asycData = AsycData(this)
    }

    private fun success(string: String?) {
        listener.onSuccessResponse(string)
    }

    private fun error(string: String?) {

        listener.onErrorResponse(string)
    }

    fun start() {
        asycData.execute()
    }

    fun cencel() {
        asycData.cancel(true)
    }

    fun isCencel() : Boolean {
        return asycData.isCancelled
    }

    private fun query(params: HashMap<String, String>): String {
        var myData = ""
        var count = 0
        params.forEach {
            count++
            myData +="${URLEncoder.encode(it.key, "UTF-8")}=${URLEncoder.encode(it.value, "UTF-8")}"

            if (count < params.size) {
                myData +="&"
            }
        }
        Log.d(TAG, myData)
        return myData;
    }

    class AsycData(var httpHandler: HttpHandler) : AsyncTask<Void, Void, Pair<String, String?>>() {

        private lateinit var conn: HttpURLConnection

        override fun doInBackground(vararg p0: Void?): Pair<String, String?> {
            try {
                val url = URL(httpHandler.reqUrl)
                conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = httpHandler.requestMethod
                conn.connectTimeout = 10000
                conn.readTimeout = 10000
                //conn.setRequestProperty("User-Agent", "my-rest-app-v0.1")
                if (httpHandler.params !=null) {
                    if (httpHandler.requestMethod == HttpHandler.REQUEST_METHOD_POST) {
                        conn.doOutput = true
                        val writer = BufferedWriter( OutputStreamWriter(conn.outputStream, "UTF-8"))
                        writer.write(httpHandler.query(httpHandler.params!!))
                        writer.flush()
                        writer.close()
                        conn.outputStream.close()
                    }

                }

                conn.connect()

                val bufferedInputStream = BufferedInputStream(conn.inputStream)
                val dataString = HttpHandler.convertStreamToString(bufferedInputStream)
                return Pair("success", dataString)
            } catch (e: MalformedURLException) {
                Log.e(TAG, "MalformedURLException: " + e.message)
                return Pair("error", e.message)
            } catch (e: ProtocolException) {
                Log.e(TAG, "ProtocolException: " + e.message)
                return Pair("error", e.message)
            } catch (e: IOException) {
                Log.e(TAG, "IOException: " + e.message)
                return Pair("error", e.message)
            } catch (e: Exception) {
                Log.e(TAG, "Exception: " + e.message)
                return Pair("error", e.message)
            }finally {
                conn.disconnect()
            }
        }

        override fun onPostExecute(result: Pair<String, String?>?) {
            if (result!!.first == "success") httpHandler.success(result.second)
            else httpHandler.error(result.second)
        }
    }

    companion object {

        private val TAG = HttpHandler::class.java.simpleName
        const val REQUEST_METHOD_GET = "GET"
        const val REQUEST_METHOD_POST = "POST"

        fun convertStreamToString(inputStream: InputStream): String {
            val reader = BufferedReader(InputStreamReader(inputStream))
            val sb = StringBuilder()
            try {
                while (true) {
                    val line = reader.readLine() ?: break
                    sb.append(line).append("\n")
                }
                inputStream.close()
            } catch (e: IOException) {
                Log.e(TAG, "Convert IOException: " + e.message)
                e.printStackTrace()
            }
            return sb.toString()
        }
    }

    interface ResponseListener {
        fun onSuccessResponse(string: String?)
        fun onErrorResponse(string: String?)
    }
}