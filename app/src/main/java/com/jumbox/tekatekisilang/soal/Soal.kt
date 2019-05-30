package com.jumbox.tekatekisilang.soal

import com.jumbox.tekatekisilang.TSilang

/**
 *Created by Jumadi Janjaya
 *14, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
class Soal {

    companion object {
        var pepatah = arrayOf("Tolak tangan berayun kaki, peluk tubuh mengajar diri.", "Tong penuh tidak bergunjang, tong setengah yang berguncang.", "Ada air ada ikan.", "Adat muda menanggung rindu, adat tua menahan ragam.", "Air yang tenang jangan disangka tiada buaya.", "Air tenang menghanyutkan.", "Alah bisa karena biasa.", "Anak dipangku dilepaskan, beruk di rimba disusui.", "Angan-angan mengikat tubuh.", "Anjing menggonggong, khafilah berlalu.", "Asam di darat, ikan di laut bertemu di belanga.", "Bagai anak ayam kehilangan induknya.", "Bak ilmu padi, kian berisi kian runduk.", "Berat sama dipikul, ringan sama dijunjung.", "Berguru kepalang ajar bagai bunga kembang tak jadi.", "Biar lambat asal selamat, tak akan lari gunung dikejar")
        var artinya = arrayOf("Belajar untuk mengendalikan diri dan meninggalkan kebiasaan bersenang-senang.", "Orang berilmu tidak akan berbicara, tetapi orang bodoh biasanya banyak bicara seoloh-olah baynak hal.", "Dimanapun kita tinggal, rezeki akan selalu ada.", "Orang muda harus bersabar, meraih cita-cita.", "Orang pendiam jangan sangka tidak berani.", "Orang yang kelihatan pendiam, namun ternyata banyak ilmu pengetahuan dalam berpikir.", "Segala kesukaran tak akan terasa lagi bila biasa.", "Selalu membereskan urusan orang lain tanpa peduli urusan sendiri.", "Memikirkan yang tidak-tidak akhirnya menderita sendiri.", "Biarpun banyak rintangan dalam usaha kita, kita tidak boleh putus asa.", "Laki-laki dan perempuan kalau sudah jodoh pasti akan bertemu juga.", "Bercerai berai karena kehilangan tumpuan.", "Makin berilmu tidak sombong.", "Bersama-sama dalam suka dan duka, baik buruk samam-sama ditanggung.", "Belajarlah sungguh-sungguh jangan tanggung-tanggung (ragu-ragu).", "Dalam mengerjakan sesuatu pekerjaan haruslah berhati-hati supaya selamat.")

        var soal10x10 = arrayOf(
                arrayOf(
                        arrayOf("Maluku", "Provinsi", 1, 1, TSilang.MENDATAR),
                        arrayOf("aneka", "Beragam jenis", 4, 1, TSilang.MENDATAR),
                        arrayOf("par", "Istilah dalam olehraga golf", 1, 8, TSilang.MENDATAR),
                        arrayOf("rebana", "Jenis alat musik", 3, 5, TSilang.MENDATAR),
                        arrayOf("pungli", "Pungutan liar", 6, 2, TSilang.MENDATAR),
                        arrayOf("alasan", "Pembenaran", 8, 1, TSilang.MENDATAR),
                        arrayOf("sua", "jumpa", 7, 8, TSilang.MENDATAR),
                        arrayOf("garut", "Terkenal dengan dodolnya", 9, 6, TSilang.MENDATAR),
                        arrayOf("makan", "kebutuha primer semua makhluk hidup", 1, 1, TSilang.MENURUN),
                        arrayOf("lele", "jenis ikan air tawar", 1, 3, TSilang.MENURUN),
                        arrayOf("karang", "jenis tumbuhan yang hidup di laut", 1, 5, TSilang.MENURUN),
                        arrayOf("prabu", "sebutan raja di jawa", 1, 8, TSilang.MENURUN),
                        arrayOf("riang", "senang", 1, 10, TSilang.MENURUN),
                        arrayOf("pulas", "nyenyak", 6, 2, TSilang.MENURUN),
                        arrayOf("nisan", "batu kuburan", 6, 4, TSilang.MENURUN),
                        arrayOf("long", "panjang (Inggris)", 6, 6, TSilang.MENURUN),
                        arrayOf("art", "seni (Inggris)", 7, 10, TSilang.MENURUN),
                        arrayOf("sar", "tim penyelamat", 7, 8, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("motor", "kendaraan roda dua", 2, 1, TSilang.MENDATAR),
                        arrayOf("sule", "Ayah Rizky Febian(pelawak)", 1, 6, TSilang.MENDATAR),
                        arrayOf("ulama", "orang yang ahli dalam hal pengetahuan agama", 3, 5, TSilang.MENDATAR),
                        arrayOf("atlas", "buku yang berisi peta bumi", 4, 1, TSilang.MENDATAR),
                        arrayOf("ulasan", "review (Indonesia)", 5, 5, TSilang.MENDATAR),
                        arrayOf("rush", "buru-buru (Inggris)", 6, 2, TSilang.MENDATAR),
                        arrayOf("runtuh", "ambruk", 8, 2, TSilang.MENDATAR),
                        arrayOf("massal", "melibatkan orang banyak", 10, 4, TSilang.MENDATAR),

                        arrayOf("montir", "tukang mesin", 1, 2, TSilang.MENURUN),
                        arrayOf("rusuh", "bising, gaduh", 2, 5, TSilang.MENURUN),
                        arrayOf("utama", "terbaik", 1, 7, TSilang.MENURUN),
                        arrayOf("esa", "tunggal", 1, 9, TSilang.MENURUN),
                        arrayOf("umum", "biasa", 6, 3, TSilang.MENURUN),
                        arrayOf("luas", "tidak sempit", 7, 6, TSilang.MENURUN),
                        arrayOf("nafsu", "gairah", 5, 10, TSilang.MENURUN),
                        arrayOf("SGM", "merek susu", 5, 8, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("singa", "si raja hutan", 2, 1, TSilang.MENDATAR),
                        arrayOf("nafkah", "menghidup anak dan istri", 1, 5, TSilang.MENDATAR),
                        arrayOf("uang", "alat tukar yang sah", 6, 1, TSilang.MENDATAR),
                        arrayOf("gula", "bahan pemanis berbentuk kristal", 8, 1, TSilang.MENDATAR),
                        arrayOf("arti", "maksud yang terkandung", 4, 5, TSilang.MENDATAR),
                        arrayOf("moon", "bulan (Inggris)", 7, 7, TSilang.MENDATAR),
                        arrayOf("magang", "calon pegawai yang masih dalam taraf belajar", 9, 4, TSilang.MENDATAR),
                        arrayOf("enam", "six (Indonesia)", 1, 3, TSilang.MENURUN),
                        arrayOf("samsung", "merek handphone", 2, 1, TSilang.MENURUN),
                        arrayOf("naga", "buah", 1, 5, TSilang.MENURUN),
                        arrayOf("fakta", "sesuatu yang benar - benar ada atau terjadi", 1, 7, TSilang.MENURUN),
                        arrayOf("halaman", "lembaran buku", 1, 10, TSilang.MENURUN),
                        arrayOf("gram", "ukuran berat", 6, 4, TSilang.MENURUN),
                        arrayOf("own", "memiliki (Inggris)", 7, 8, TSilang.MENURUN),
                        arrayOf("uap", "gas yang terjadi dari cairan yang dipanaskan", 8, 2, TSilang.MENURUN),
                        arrayOf("ago", "yang lalu (inggris)", 8, 6, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("rotasi", "perputaran", 1, 5, TSilang.MENDATAR),
                        arrayOf("makam", "kuburan", 3, 1, TSilang.MENDATAR),
                        arrayOf("namun", "tapi", 5, 1, TSilang.MENDATAR),
                        arrayOf("mur", "pelat logam untuk menguatkan baut", 7, 1, TSilang.MENDATAR),
                        arrayOf("adab", "akhlak", 8, 3, TSilang.MENDATAR),
                        arrayOf("load", "beban (Inggris)", 3, 7, TSilang.MENDATAR),
                        arrayOf("ion", "sekumpulan atom bermuatan listrik", 5, 8, TSilang.MENDATAR),
                        arrayOf("jus", "sari buah", 7, 8, TSilang.MENDATAR),
                        arrayOf("takdir", "ketetapan tuhan", 10, 4, TSilang.MENDATAR),

                        arrayOf("mma", "Mixed Martial Arts", 1, 2, TSilang.MENURUN),
                        arrayOf("monumen", "banguna/tempat yang mempunyai nilai sejarah yang penting", 3, 1, TSilang.MENURUN),
                        arrayOf("ram", "Random Access Memorry", 1, 5, TSilang.MENURUN),
                        arrayOf("kamera", "alat potret", 3, 3, TSilang.MENURUN),
                        arrayOf("masa", "ketika", 7, 5, TSilang.MENURUN),
                        arrayOf("tali", "barang yang berutas-utas panjang", 1, 7, TSilang.MENURUN),
                        arrayOf("juli", "bulan", 7, 8, TSilang.MENURUN),
                        arrayOf("indonesia", "negara tercinta", 1, 10, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("tetangga", "orang yang rumahnya berdekatan", 1, 1, TSilang.MENDATAR),
                        arrayOf("gundul", "botak", 3, 3, TSilang.MENDATAR),
                        arrayOf("ras", "kategori manusia dalam populasi / kelompok ", 5, 1, TSilang.MENDATAR),
                        arrayOf("ganda", "dobel", 6, 6, TSilang.MENDATAR),
                        arrayOf("nasa", "national aeronautics and space administration", 9, 1, TSilang.MENDATAR),
                        arrayOf("sold", "terjual (Inggris)", 10, 4, TSilang.MENDATAR),
                        arrayOf("aman", "bebas dari bahaya", 9, 7, TSilang.MENDATAR),
                        arrayOf("sun", "matahari (Inggris)", 2, 8, TSilang.MENDATAR),
                        arrayOf("iba", "kasihan", 4, 8, TSilang.MENDATAR),
                        arrayOf("dawet", "minuman es khas jawa", 7, 1, TSilang.MENDATAR),

                        arrayOf("tawar", "tidak ada rasanya", 1, 1, TSilang.MENURUN),
                        arrayOf("tugas", "wajib dikerjakan", 1, 3, TSilang.MENURUN),
                        arrayOf("gudang", "tempat penyimpanan barang-barang", 1, 6, TSilang.MENURUN),
                        arrayOf("asli", "murni", 1, 8, TSilang.MENURUN),
                        arrayOf("unta", "hewan bepunuk", 1, 10, TSilang.MENURUN),
                        arrayOf("amanah", "sesuatu yang dipercaya kepada orang lain", 5, 2, TSilang.MENURUN),
                        arrayOf("emas", "logam mulia", 7, 4, TSilang.MENURUN),
                        arrayOf("abjad", "kumpulan huruf", 6, 7, TSilang.MENURUN),
                        arrayOf("debat", "diskusi / pembahasan", 6, 9, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("iblis", "setan", 1, 1, TSilang.MENDATAR),
                        arrayOf("umpama", "andai / ibarat", 2, 5, TSilang.MENDATAR),
                        arrayOf("dasar", "bagian terbawah", 3, 1, TSilang.MENDATAR),
                        arrayOf("out", "keluar (Inggris)", 4, 8, TSilang.MENDATAR),
                        arrayOf("buas", "liar", 5, 3, TSilang.MENDATAR),
                        arrayOf("earth", "bumi (Inggris)", 7, 1, TSilang.MENDATAR),
                        arrayOf("sir", "tuan (Inggris)", 7, 7, TSilang.MENDATAR),
                        arrayOf("lama", "panjang antaranya (Tentang waktu)", 10, 2, TSilang.MENDATAR),
                        arrayOf("monas", "Monumen yang dibangun pada 17 Agustus 1961 yang ada di Jakarta", 9, 5, TSilang.MENDATAR),
                        arrayOf("os", "operating system", 8, 9, TSilang.MENDATAR),

                        arrayOf("indomie", "merek mie instan", 1, 1, TSilang.MENURUN),
                        arrayOf("surya", "matahari", 1, 5, TSilang.MENURUN),
                        arrayOf("mantan", "bekas pacar", 1, 10, TSilang.MENURUN),
                        arrayOf("sabar", "menahan emosi", 3, 3, TSilang.MENURUN),
                        arrayOf("aborsi", "menggugur kandungan", 2, 8, TSilang.MENURUN),
                        arrayOf("amal", "kotak", 7, 2, TSilang.MENURUN),
                        arrayOf("hama", "perusak tanaman sawah", 7, 5, TSilang.MENURUN),
                        arrayOf("sing", "bernyanyi (inggris)", 7, 7, TSilang.MENURUN),
                        arrayOf("rose", "mawar (inggris)", 7, 9, TSilang.MENURUN)),
                arrayOf(
                        arrayOf("siaga", "waspada", 1, 1, TSilang.MENDATAR),
                        arrayOf("nuansa", "variasi", 3, 1, TSilang.MENDATAR),
                        arrayOf("busur", "ibu panah", 2, 6, TSilang.MENDATAR),
                        arrayOf("radiator", "alat pendingin mesin mobil", 5, 1, TSilang.MENDATAR),
                        arrayOf("pose", "gaya ketika di foto", 9, 2, TSilang.MENDATAR),
                        arrayOf("marah", "sangat tidak senang", 8, 5, TSilang.MENDATAR),
                        arrayOf("serasi", "cocok", 10, 5, TSilang.MENDATAR),

                        arrayOf("senar", "tali gitar", 1, 1, TSilang.MENURUN),
                        arrayOf("gunting", "perkakas untuk memotong", 1, 4, TSilang.MENURUN),
                        arrayOf("suara", "bunyi", 2, 8, TSilang.MENURUN),
                        arrayOf("arloji", "jam tangan", 1, 10, TSilang.MENURUN),
                        arrayOf("arsip", "dokumen", 5, 2, TSilang.MENURUN),
                        arrayOf("mes", "pondokan para pekerja", 8, 5, TSilang.MENURUN),
                        arrayOf("khas", "sepesial", 7, 9, TSilang.MENURUN),
                        arrayOf("bantara", "sebelum penegak laksana (Pramuka)", 2, 6, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("rendang", "masakan padang", 1, 1, TSilang.MENDATAR),
                        arrayOf("dalang", "orang yang memainkan wayang", 3, 1, TSilang.MENDATAR),
                        arrayOf("agung", "besar", 4, 6, TSilang.MENDATAR),
                        arrayOf("basi", "tidak baru lagi", 6, 3, TSilang.MENDATAR),
                        arrayOf("sulit", "susah", 7, 6, TSilang.MENDATAR),
                        arrayOf("botol", "tempat minuman", 8, 1, TSilang.MENDATAR),
                        arrayOf("hancur", "Binasa, musnah", 10, 1, TSilang.MENDATAR),
                        arrayOf("abad", "masa seratus tahun", 9, 7, TSilang.MENDATAR),

                        arrayOf("elang", "si raja burung ", 1, 2, TSilang.MENURUN),
                        arrayOf("dua", "two (indonesia)", 1, 4, TSilang.MENURUN),
                        arrayOf("gadis", "perempuan yang masih perawan", 3, 6, TSilang.MENURUN),
                        arrayOf("laut", "air asin", 2, 8, TSilang.MENURUN),
                        arrayOf("bangkit", "bangun", 1, 10, TSilang.MENURUN),
                        arrayOf("wabah", "penyakit menular", 6, 1, TSilang.MENURUN),
                        arrayOf("beton", "bangunan", 6, 3, TSilang.MENURUN),
                        arrayOf("ikan", "binatang / hewan hidup dalam air", 7, 9, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("DPR", "dewan perwakilan rakyat", 1, 1, TSilang.MENDATAR),
                        arrayOf("beda", "tidak sama", 1, 7, TSilang.MENDATAR),
                        arrayOf("mafia", "kelompok yang melakukan kejahatan", 4, 1, TSilang.MENDATAR),
                        arrayOf("abadi", "kekal", 2, 3, TSilang.MENDATAR),
                        arrayOf("meja", "table (Indonesia)", 3, 7, TSilang.MENDATAR),
                        arrayOf("nias", "pulau di Sumatra", 5, 5, TSilang.MENDATAR),
                        arrayOf("also", "juga (Inggris)", 7, 1, TSilang.MENDATAR),
                        arrayOf("gali", "keruk", 7, 7, TSilang.MENDATAR),
                        arrayOf("utama", "nomor satu", 9, 6, TSilang.MENDATAR),
                        arrayOf("ant", "semut (Inggris)", 10, 4, TSilang.MENDATAR),

                        arrayOf("dermaga", "pangkalan kapal", 1, 1, TSilang.MENURUN),
                        arrayOf("rafflesia", "bunga terbesar", 1, 3, TSilang.MENURUN),
                        arrayOf("malang", "kota yang dijulukan kota apel", 1, 5, TSilang.MENURUN),
                        arrayOf("bimbang", "ragu-ragu", 1, 7, TSilang.MENURUN),
                        arrayOf("adam", "manusia pertama", 1, 10, TSilang.MENURUN),
                        arrayOf("silat", "bela diri asli indonesia", 6, 10, TSilang.MENURUN),
                        arrayOf("acak", "random (Indonesia)", 7, 8, TSilang.MENURUN),
                        arrayOf("cut", "potong (Inggris)", 8, 6, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("roket", "peluru", 1, 1, TSilang.MENDATAR),
                        arrayOf("tamu", "orang yang datang berkunjung kerumah", 1, 7, TSilang.MENDATAR),
                        arrayOf("fakir", "orang yang terlalu miskin", 3, 1, TSilang.MENDATAR),
                        arrayOf("dapur", "ruang tempat memasak", 4, 6, TSilang.MENDATAR),
                        arrayOf("generasi", "angkatan", 6, 3, TSilang.MENDATAR),
                        arrayOf("obeng", "alat untuk memutar skrup", 8, 1, TSilang.MENDATAR),
                        arrayOf("bisu", "tidak bisa berbicara", 8, 7, TSilang.MENDATAR),
                        arrayOf("kanan", "kiri", 10, 1, TSilang.MENDATAR),
                        arrayOf("sapi", "Hewan ternak", 10, 7, TSilang.MENDATAR),

                        arrayOf("facebook", "media sosial", 3, 1, TSilang.MENURUN),
                        arrayOf("kuku", "cakar", 1, 3, TSilang.MENURUN),
                        arrayOf("adaptasi", "penyesuaian diri terhadap lingkungan", 1, 8, TSilang.MENURUN),
                        arrayOf("umur", "usia", 1, 10, TSilang.MENURUN),
                        arrayOf("anggun", "apik dan berwibawah", 5, 5, TSilang.MENURUN),
                        arrayOf("ibu", "sebutan wanita yang telah bersuami", 6, 10, TSilang.MENURUN),
                        arrayOf("bus", "angkutan umum", 8, 7, TSilang.MENURUN),
                        arrayOf("sup", "masakan berkuah kaldu", 8, 9, TSilang.MENURUN)
                ),
                arrayOf(
                        arrayOf("jeruk", "buah bervitamin C", 1, 1, TSilang.MENDATAR),
                        arrayOf("usil", "jahil", 2, 5, TSilang.MENDATAR),
                        arrayOf("usa", "united states of america", 3, 8, TSilang.MENDATAR),
                        arrayOf("usaha", "kegiatan dengan mengarahkan tenaga, pikiran, atau badan untuk mencapai suata maksud", 4, 1, TSilang.MENDATAR),
                        arrayOf("cuma", "tidak ada yang lain", 5, 7, TSilang.MENDATAR),
                        arrayOf("awam", "orang biasa", 7, 1, TSilang.MENDATAR),
                        arrayOf("embun", "titik-titik air yang jatuh dari udara", 8, 4, TSilang.MENDATAR),
                        arrayOf("untung", "laba yang diperoleh dalam berdagang", 10, 2, TSilang.MENDATAR),

                        arrayOf("rujak", "semacam salad dengan dicampur saus manis pedas", 1, 3, TSilang.MENURUN),
                        arrayOf("kuda", "penarik delman", 1, 5, TSilang.MENURUN),
                        arrayOf("lucu", "jenaka", 2, 8, TSilang.MENURUN),
                        arrayOf("lapangan", "tempat olahraga", 2, 10, TSilang.MENURUN),
                        arrayOf("ustad", "guru agama", 4, 1, TSilang.MENURUN),
                        arrayOf("meat", "daging (Inggris)", 7, 4, TSilang.MENURUN),
                        arrayOf("cekung", "berlekuk", 5, 7, TSilang.MENURUN)),

                arrayOf(arrayOf("patuh", "taat", 1, 1, TSilang.MENDATAR),
                        arrayOf("baca", "melafalkan", 1, 7, TSilang.MENDATAR),
                        arrayOf("yes", "ya (Inggris)", 3, 1, TSilang.MENDATAR),
                        arrayOf("rata", "tidak bergelombang", 3, 5, TSilang.MENDATAR),
                        arrayOf("anggur", "tanaman buah yang merambat", 5, 5, TSilang.MENDATAR),
                        arrayOf("arak", "minuman keras", 7, 2, TSilang.MENDATAR),
                        arrayOf("roh", "arwah", 7, 7, TSilang.MENDATAR),
                        arrayOf("cadel", "kurang sempurna mengucapkan kata-kata", 9, 5, TSilang.MENDATAR),
                        arrayOf("tawa", "gelak", 10, 2, TSilang.MENDATAR),

                        arrayOf("payung", "Sedia ...sebelum hujan", 1, 1, TSilang.MENURUN),
                        arrayOf("harta", "barang yang menjadi kekayaan", 1, 5, TSilang.MENURUN),
                        arrayOf("batagor", "jajanan khas bandung", 1, 7, TSilang.MENURUN),
                        arrayOf("absurd", "tidak masuk akal", 1, 10, TSilang.MENURUN),
                        arrayOf("sadar", "siuman", 3, 3, TSilang.MENURUN),
                        arrayOf("adat", "aturan yang lazim dilakukan sejak dahulu kala", 7, 2, TSilang.MENURUN),
                        arrayOf("kaca", "cermin", 7, 5, TSilang.MENURUN),
                        arrayOf("helm", "alat keselamatan berkendara", 7, 9, TSilang.MENURUN)),

                arrayOf(arrayOf("naruto", "ninja konoha", 1, 1, TSilang.MENDATAR),
                        arrayOf("bab", "bagian isi buku", 2, 6, TSilang.MENDATAR),
                        arrayOf("abc", "merek kecap", 1, 8, TSilang.MENDATAR),
                        arrayOf("ide", "gagasan", 3, 1, TSilang.MENDATAR),
                        arrayOf("ten", "sepuluh (Inggris)", 4, 6, TSilang.MENDATAR),
                        arrayOf("gas", "tabung...", 5, 8, TSilang.MENDATAR),
                        arrayOf("wiro", "...Sableng", 5, 2, TSilang.MENDATAR),
                        arrayOf("kua", "kantor urusan agama", 6, 5, TSilang.MENDATAR),
                        arrayOf("mui", "majelis ulama indonesia", 7, 1, TSilang.MENDATAR),
                        arrayOf("kail", "mata pancing", 7, 7, TSilang.MENDATAR),
                        arrayOf("olahraga", "gerak badan utuk menyehatkan tubuh", 10, 1, TSilang.MENDATAR),

                        arrayOf("naik", "bergerak ke atas", 1, 1, TSilang.MENURUN),
                        arrayOf("obat", "diminum saat sakit", 1, 6, TSilang.MENURUN),
                        arrayOf("abang", "saudara laki-laki", 1, 8, TSilang.MENURUN),
                        arrayOf("cemas", "khawatir", 1, 10, TSilang.MENURUN),
                        arrayOf("edisi", "bentuk buku yang diterbitkan", 3, 3, TSilang.MENURUN),
                        arrayOf("okuler", "lensa", 5, 5, TSilang.MENURUN),
                        arrayOf("adil", "tidak memihak", 5, 9, TSilang.MENURUN),
                        arrayOf("akang", "abang", 6, 7, TSilang.MENURUN),
                        arrayOf("moto", "semboyan", 7, 1, TSilang.MENURUN)),

                arrayOf(arrayOf("dahi", "kening", 1, 1, TSilang.MENDATAR),
                        arrayOf("macam", "ragam", 2, 4, TSilang.MENDATAR),
                        arrayOf("aki", "kakek, datuk", 1, 8, TSilang.MENDATAR),
                        arrayOf("alat", "benda yang dipakai untuk mengerjakan sesuatu", 4, 1, TSilang.MENDATAR),
                        arrayOf("bulat", "bundar", 4, 6, TSilang.MENDATAR),
                        arrayOf("anang", "...Hermansyah (Penyanyi)", 6, 3, TSilang.MENDATAR),
                        arrayOf("tiang", "...Listrik", 8, 1, TSilang.MENDATAR),
                        arrayOf("makelar", "perantara", 10, 1, TSilang.MENDATAR),
                        arrayOf("busa", "buih", 8, 7, TSilang.MENDATAR),

                        arrayOf("dahaga", "haus", 1, 1, TSilang.MENURUN),
                        arrayOf("imut", "manis, menggemaskan", 1, 4, TSilang.MENURUN),
                        arrayOf("cabang", "memiliki toko lebih dari satu", 2, 6, TSilang.MENURUN),
                        arrayOf("ampli", "pengeras suara", 1, 8, TSilang.MENURUN),
                        arrayOf("instagram", "jejaring sosial berbagi foto dan video", 1, 10, TSilang.MENURUN),
                        arrayOf("acara", "program(Televisi, Radio)", 4, 3, TSilang.MENURUN),
                        arrayOf("tim", "grup", 8, 1, TSilang.MENURUN),
                        arrayOf("gol", "memasukan bola kegawang", 8, 5, TSilang.MENURUN),
                        arrayOf("bor", "alat membuat lubang", 8, 7, TSilang.MENURUN)),

                arrayOf(arrayOf("tabot", "festival di Bengkulu", 1, 1, TSilang.MENDATAR),
                        arrayOf("lava", "magma", 1, 7, TSilang.MENDATAR),
                        arrayOf("windows", "sistem operasi yang dikembangkan oleh microsoft", 3, 1, TSilang.MENDATAR),
                        arrayOf("anies", "gubernur DKI Jakarta", 5, 6, TSilang.MENDATAR),
                        arrayOf("gemar", "hobi", 6, 2, TSilang.MENDATAR), arrayOf("awas", "hati-hati", 7, 6, TSilang.MENDATAR),
                        arrayOf("dakwah", "menyerukan  utuk mempelajari dan mengamalkan ajaran agama", 8, 1, TSilang.MENDATAR),
                        arrayOf("siang", "sesudah pagi", 10, 1, TSilang.MENDATAR),
                        arrayOf("ahli", "orang yang mahir", 10, 7, TSilang.MENDATAR),

                        arrayOf("tewas", "mati", 1, 1, TSilang.MENURUN),
                        arrayOf("ban", "roda", 1, 3, TSilang.MENURUN),
                        arrayOf("lisan", "kata-kata yang diucapkan", 1, 7, TSilang.MENURUN),
                        arrayOf("adopsi", "mengangkat anak", 1, 10, TSilang.MENURUN),
                        arrayOf("dermawan", "pemurah hati", 3, 4, TSilang.MENURUN),
                        arrayOf("arah", "ia naik bus ... utara", 5, 6, TSilang.MENURUN),
                        arrayOf("ibadah", "menegrjakan perintah-Nya", 5, 8, TSilang.MENURUN),
                        arrayOf("gua", "lubang besar pada kaki gunung", 6, 2, TSilang.MENURUN),
                        arrayOf("dos", "operating system berbasis tulisan ", 8, 1, TSilang.MENURUN)),

                arrayOf(arrayOf("kaki", "anggota badan", 1, 1, TSilang.MENDATAR),
                        arrayOf("miras", "minuman keras", 1, 6, TSilang.MENDATAR),
                        arrayOf("ramuan", "materials (Indonesia)", 3, 1, TSilang.MENDATAR),
                        arrayOf("sol", "...Sepatu", 3, 8, TSilang.MENDATAR),
                        arrayOf("tandus", "gersang", 5, 1, TSilang.MENDATAR),
                        arrayOf("kit", "merek sampo motor", 5, 8, TSilang.MENDATAR),
                        arrayOf("muat", "karung itu ... seratus liter", 8, 2, TSilang.MENDATAR),
                        arrayOf("unduh", "download (Indonesia)", 7, 5, TSilang.MENDATAR),
                        arrayOf("mules", " sakit perut", 10, 4, TSilang.MENDATAR),
                        arrayOf("lem", "perekat", 9, 7, TSilang.MENDATAR),

                        arrayOf("karet", "...Gelang", 1, 1, TSilang.MENURUN),
                        arrayOf("kuman", "bakteri", 1, 3, TSilang.MENURUN),
                        arrayOf("minus", "kurang (Inggris)", 1, 6, TSilang.MENURUN),
                        arrayOf("rusak", "hancur", 1, 8, TSilang.MENURUN),
                        arrayOf("salut", "sampul", 1, 10, TSilang.MENURUN),
                        arrayOf("agama", "anutan", 5, 2, TSilang.MENURUN),
                        arrayOf("urut", "pijat", 5, 5, TSilang.MENURUN),
                        arrayOf("adele", "... Laurrie blue adkins (Penyanyi)", 6, 7, TSilang.MENURUN),
                        arrayOf("ilham", "petunjuk tuhan", 5, 9, TSilang.MENURUN),
                        arrayOf("atm", "anjunagan tunai mandiri", 8, 4, TSilang.MENURUN),
                        arrayOf("es", "air yang membeku", 9, 8, TSilang.MENURUN)),
                arrayOf(arrayOf("rejang", "suku di Bengkulu", 1, 1, TSilang.MENDATAR), arrayOf("bos", "atasan", 1, 8, TSilang.MENDATAR), arrayOf("wah", "kata seru untuk menyatakan kagum, terkejut", 3, 1, TSilang.MENDATAR), arrayOf("susun", "tumpuk", 3, 6, TSilang.MENDATAR), arrayOf("hutan", "rimba", 5, 1, TSilang.MENDATAR), arrayOf("aneh", "abnormal", 5, 7, TSilang.MENDATAR), arrayOf("under", "dibawah (inggris)", 7, 6, TSilang.MENDATAR), arrayOf("uranus", "pelanet", 8, 1, TSilang.MENDATAR), arrayOf("afgan", "... Syahreza(Penyanyi)", 9, 6, TSilang.MENDATAR), arrayOf("laknat", "terkutuk", 10, 1, TSilang.MENDATAR),

                        arrayOf("rawa", "tanah yang rendah dan digenangi air", 1, 1, TSilang.MENURUN), arrayOf("jahat", "tidak baik", 1, 3, TSilang.MENURUN), arrayOf("gusi", "daging tempat gigi tumbuh", 1, 6, TSilang.MENURUN), arrayOf("besan", "orang tua dari menantu", 1, 8, TSilang.MENURUN), arrayOf("sunah", "dianjurkan mengerjaka-Nya, tetapi tidak diwajibkan", 1, 10, TSilang.MENURUN), arrayOf("uber", "taksi online", 5, 2, TSilang.MENURUN), arrayOf("alan", "...Walker (DJ)", 5, 4, TSilang.MENURUN), arrayOf("pusat", "tempat yang letaknya di bagian tengah", 6, 6, TSilang.MENURUN), arrayOf("elegan", "luwes, lemah gemulai", 5, 9, TSilang.MENURUN), arrayOf("url", "alamat website", 8, 1, TSilang.MENURUN)),

                arrayOf(arrayOf("bahu", "pundak", 1, 1, TSilang.MENDATAR), arrayOf("takwa", "terpeliharanya diri untuk tetap taat melaksanakan perintah Allah", 1, 6, TSilang.MENDATAR), arrayOf("bau", "sudah tercium ...nya", 2, 4, TSilang.MENDATAR), arrayOf("edan", "gila", 4, 1, TSilang.MENDATAR), arrayOf("age", "umur(Inggris)", 4, 6, TSilang.MENDATAR), arrayOf("jala", "alat penangkap ikan", 6, 7, TSilang.MENDATAR), arrayOf("arus", "gerakan air yang mengalir", 6, 1, TSilang.MENDATAR), arrayOf("anime", "sebutan animasi dari jepang", 8, 1, TSilang.MENDATAR), arrayOf("liga", "...Sepak bola", 10, 2, TSilang.MENDATAR), arrayOf("mualaf", "orang yang masuk islam", 9, 5, TSilang.MENDATAR),

                        arrayOf("boneka", "mainan anak perempuan", 1, 1, TSilang.MENURUN), arrayOf("uban", "rambut berwarnah putih", 1, 4, TSilang.MENURUN), arrayOf("tuna", "ikan", 1, 6, TSilang.MENURUN), arrayOf("kode", "sandi", 1, 8, TSilang.MENURUN), arrayOf("agenda", "jadwal", 1, 10, TSilang.MENURUN), arrayOf("amunisi", "bahan pengisi senjata api", 4, 3, TSilang.MENURUN), arrayOf("gaji", "upah", 4, 7, TSilang.MENURUN), arrayOf("lada", "merica", 6, 9, TSilang.MENURUN), arrayOf("gema", "dengung", 7, 5, TSilang.MENURUN)),

                arrayOf(arrayOf("gasing", "mainan tradisional", 1, 1, TSilang.MENDATAR), arrayOf("rel", "jalan kereta api", 1, 8, TSilang.MENDATAR), arrayOf("rem", "...Blong", 3, 1, TSilang.MENDATAR), arrayOf("rotan", "tumbuhan menjalar yang batangnya digunakan sebagai kerajinan", 3, 6, TSilang.MENDATAR), arrayOf("beras", "padi yang terkelupas dari kulitnya", 5, 1, TSilang.MENDATAR), arrayOf("anda", "kamu", 5, 7, TSilang.MENDATAR), arrayOf("keran", "pancuran air ", 7, 1, TSilang.MENDATAR), arrayOf("bemo", "becak mermotor", 7, 7, TSilang.MENDATAR), arrayOf("alami", "natural", 9, 5, TSilang.MENDATAR), arrayOf("dot", "titik (Inggris)", 9, 1, TSilang.MENDATAR),

                        arrayOf("gerobak", "yang didoring", 1, 1, TSilang.MENURUN), arrayOf("sumur", "sumber air buatan, dengan cara menggali tanah", 1, 3, TSilang.MENURUN), arrayOf("gir", "tempat rantai berpaut untuk memutar roda", 1, 6, TSilang.MENURUN), arrayOf("rutan", "rumah tahanan", 1, 8, TSilang.MENURUN), arrayOf("lensa", "kaca kamera", 1, 10, TSilang.MENURUN), arrayOf("sandal", "selop", 5, 5, TSilang.MENURUN), arrayOf("amblas", "hilang, lenyap", 5, 7, TSilang.MENURUN), arrayOf("damai", "tentram", 5, 9, TSilang.MENURUN), arrayOf("ekor", "tail (Indonesi)", 7, 2, TSilang.MENURUN)),

                arrayOf(arrayOf("pagar", "untuk membatasi rumah", 1, 1, TSilang.MENDATAR), arrayOf("apes", "usahanya selalu tidak berhasil", 1, 7, TSilang.MENDATAR), arrayOf("api", "bara", 2, 5, TSilang.MENDATAR), arrayOf("tekad", "kemauan", 3, 1, TSilang.MENDATAR), arrayOf("band", "grup musik", 3, 7, TSilang.MENDATAR), arrayOf("hadir", "datang", 5, 1, TSilang.MENDATAR), arrayOf("bass", "trible", 5, 7, TSilang.MENDATAR), arrayOf("halal", "lawan kata haram", 7, 1, TSilang.MENDATAR), arrayOf("isis", "Islamic State of Iraq and Syria", 8, 5, TSilang.MENDATAR), arrayOf("Bantu", "tolong", 9, 1, TSilang.MENDATAR), arrayOf("rakyat", "penduduk suatu negara", 10, 5, TSilang.MENDATAR),

                        arrayOf("patah", "terbelah menjadi dua", 1, 1, TSilang.MENURUN), arrayOf("radar", "alat mendeteksi di pesawat / kapal", 1, 5, TSilang.MENURUN), arrayOf("aib", "Hal yang memalukan", 1, 7, TSilang.MENURUN), arrayOf("sadis", "tidak ada belas kasihan", 1, 10, TSilang.MENURUN), arrayOf("kidal", "tangan kiri", 3, 3, TSilang.MENURUN), arrayOf("babi", "hewan yang diharamkan oleh umat muslim", 5, 7, TSilang.MENURUN), arrayOf("asap", "rokok", 7, 2, TSilang.MENURUN), arrayOf("liur", "iler", 7, 5, TSilang.MENURUN), arrayOf("slot", "cela, lobang (Inggris)", 7, 10, TSilang.MENURUN), arrayOf("say", "berkata (Inggris)", 8, 8, TSilang.MENURUN)), arrayOf(arrayOf("abu", "terbakar habis", 1, 1, TSilang.MENDATAR), arrayOf("kilo", "satuan berat", 1, 7, TSilang.MENDATAR), arrayOf("kera", "permata", 2, 4, TSilang.MENDATAR), arrayOf("lala", "Personel teletubbies", 3, 7, TSilang.MENDATAR), arrayOf("bangkai", "Hewan mati", 4, 1, TSilang.MENDATAR), arrayOf("nama", "Salah satu yang ada di KTP", 6, 1, TSilang.MENDATAR), arrayOf("bagus", "Lawan dari jelek", 6, 6, TSilang.MENDATAR), arrayOf("siput", "keong", 8, 3, TSilang.MENDATAR), arrayOf("tinggi", "Lawan dari pendek", 10, 5, TSilang.MENDATAR),

                arrayOf("bola", "sepak..", 1, 2, TSilang.MENURUN), arrayOf("weak", "Lemah (Bahasa inggris)", 1, 5, TSilang.MENURUN), arrayOf("kalimantan", "Pulau di indonesia", 1, 7, TSilang.MENURUN), arrayOf("otak", "Berfikir menggunakan ...", 1, 10, TSilang.MENURUN), arrayOf("bangku", "Yang ada di ruang kelas sekolah", 4, 1, TSilang.MENURUN), arrayOf("gua", "Saya (Bahasa betawi)", 4, 4, TSilang.MENURUN), arrayOf("musang", "Mirip binatang luwak", 5, 9, TSilang.MENURUN), arrayOf("musik", "irama", 6, 3, TSilang.MENURUN), arrayOf("apit", "Terdapat di antara dua benda", 7, 5, TSilang.MENURUN)),
                arrayOf(arrayOf("jeruk", "buanh vitamin c", 1, 1, TSilang.MENDATAR), arrayOf("usil", "jahil", 1, 7, TSilang.MENDATAR), arrayOf("uya", ". ... kuya(artis)", 2, 5, TSilang.MENDATAR), arrayOf("plangi", "Muncul setelah hujan (warna-warni)", 4, 2, TSilang.MENDATAR), arrayOf("payung", "Sedia ... sebelum hujan ", 6, 5, TSilang.MENDATAR), arrayOf("ilk", "Indonesia lawak klub", 7, 1, TSilang.MENDATAR), arrayOf("pasar", "Tempat terjadinya proses jual beli ", 8, 6, TSilang.MENDATAR), arrayOf("ampela", "Daging empedal", 9, 1, TSilang.MENDATAR), arrayOf("sesak", "Penuh, tidak longgar", 10, 6, TSilang.MENDATAR),

                        arrayOf("bedak", "ditabur di ketek", 3, 3, TSilang.MENURUN), arrayOf("kuda", "hewan penarik delman", 1, 5, TSilang.MENURUN), arrayOf("uang", "alat pembayaran", 1, 7, TSilang.MENURUN), arrayOf("lucu", "jenaka", 1, 10, TSilang.MENURUN), arrayOf("ibu", "wanita yang memiliki anak", 4, 8, TSilang.MENURUN), arrayOf("gitar", "alat musik", 6, 1, TSilang.MENURUN), arrayOf("per", "benda yang memiliki gaya pegas", 8, 4, TSilang.MENURUN), arrayOf("ampas", "sisa", 6, 6, TSilang.MENURUN), arrayOf("sms", "pesan singkat lewat hp", 8, 8, TSilang.MENURUN), arrayOf("garuk", "reaksi jika sedang gatal", 6, 10, TSilang.MENURUN)), arrayOf(arrayOf("BAKSO", "meatball (bahasa indonesia)", 1, 1, TSilang.MENDATAR), arrayOf("ASAP", "...rokok", 1, 7, TSilang.MENDATAR), arrayOf("TAIL", "ekor (bahasa inggris)", 3, 1, TSilang.MENDATAR), arrayOf("HANTU", "mahluk halus", 3, 6, TSilang.MENDATAR), arrayOf("LUMPUR", "tanah yang becek", 5, 1, TSilang.MENDATAR), arrayOf("ULET", "rajin", 7, 1, TSilang.MENDATAR), arrayOf("APUNG", "berada di atas permukaan air", 7, 6, TSilang.MENDATAR), arrayOf("KAMBING", "hewan ternak", 9, 1, TSilang.MENDATAR), arrayOf("IJUK", "sapu ...", 10, 7, TSilang.MENDATAR),

                arrayOf("BOTOL", "tempat minum", 1, 1, TSilang.MENURUN), arrayOf("SULAP", "seperti sihir", 1, 4, TSilang.MENURUN), arrayOf("APA", "kata tanya", 1, 7, TSilang.MENURUN), arrayOf("PAUD", "pendidikam anak usia dini", 1, 10, TSilang.MENURUN), arrayOf("harpa", "alat musik petik ", 3, 6, TSilang.MENURUN), arrayOf("nafsu", "keinginan yang kuat", 3, 8, TSilang.MENURUN), arrayOf("mse", "mean square error ", 5, 3, TSilang.MENURUN), arrayOf("luas", "tidak sempit", 7, 2, TSilang.MENURUN), arrayOf("tabu", "tidak boleh di ucapkan", 7, 4, TSilang.MENURUN), arrayOf("pagi", "sebelum siang ", 7, 7, TSilang.MENURUN), arrayOf("giok", "jenis batu-batuan", 7, 10, TSilang.MENURUN)),
                arrayOf(arrayOf("jangkrik", "Serangga yang berbunyi krik-krik-krik", 1, 1, TSilang.MENDATAR), arrayOf("salep", "Hewan yang ada di dalam tanah", 3, 3, TSilang.MENDATAR), arrayOf("cacing", "Merk jam tangan ", 5, 5, TSilang.MENDATAR), arrayOf("casio", "Merk jam tangan", 6, 1, TSilang.MENDATAR), arrayOf("vanila", "Rasa susu bubuk", 7, 5, TSilang.MENDATAR), arrayOf("bibir", "Bagian dari wajah", 9, 1, TSilang.MENDATAR), arrayOf("mata", "Untuk melihat ", 10, 7, TSilang.MENDATAR),

                        arrayOf("cera", "Kapok", 1, 1, TSilang.MENURUN), arrayOf("nasi", "Makanan pokok bangsa Indonesia", 1, 3, TSilang.MENURUN), arrayOf("kol", "Sayur-sayuran", 1, 5, TSilang.MENURUN), arrayOf("pocong", "Jenis hantu di Indonesia", 3, 7, TSilang.MENURUN), arrayOf("knalpot", "Ada di motor, mengeluarkan asap", 4, 9, TSilang.MENURUN), arrayOf("cabai", "Rasanya pedas", 5, 2, TSilang.MENURUN), arrayOf("cover", "Sampul", 5, 5, TSilang.MENURUN)),
                arrayOf(arrayOf("gws", "Semoga cepat sembuh", 1, 1, TSilang.MENDATAR), arrayOf("sepatu", "Alas kaki ", 1, 5, TSilang.MENDATAR), arrayOf("gendang", "Alat musik pukul ", 3, 2, TSilang.MENDATAR), arrayOf("azab", "Hukuman dari allah", 5, 1, TSilang.MENDATAR), arrayOf("libur", "Tanggal merah", 5, 6, TSilang.MENDATAR), arrayOf("tilang", "Sanksi melanggar lalu lintas ", 7, 1, TSilang.MENDATAR), arrayOf("lan", "Local area network", 8, 8, TSilang.MENDATAR), arrayOf("wisata", "Rekreasi ", 9, 3, TSilang.MENDATAR),

                        arrayOf("wig", "Rambut palsu", 1, 2, TSilang.MENURUN), arrayOf("sido", "... Muncul (jamu)", 1, 5, TSilang.MENURUN), arrayOf("panci", "Alat masak", 1, 7, TSilang.MENURUN), arrayOf("email", "Surat elektronik", 3, 3, TSilang.MENURUN), arrayOf("jerman", "Negara yang pernah dipimpin oleh hitler ", 5, 1, TSilang.MENURUN), arrayOf("anting", "Aksesoris wanita", 5, 8, TSilang.MENURUN), arrayOf("biola", "Alat musik", 5, 8, TSilang.MENURUN), arrayOf("asi", "Air susu ibu", 7, 4, TSilang.MENURUN), arrayOf("glad", "Senang (bahasa inggris)", 7, 6, TSilang.MENURUN)),
                arrayOf(arrayOf("akuarium", "sedih (bahasa inggris)", 2, 1, TSilang.MENDATAR), arrayOf("egp", "Emang gue pikirin ", 3, 8, TSilang.MENDATAR), arrayOf("impian", "cita-cita", 4, 3, TSilang.MENDATAR), arrayOf("two", "bahasa inggrisnya dua", 5, 8, TSilang.MENDATAR), arrayOf("jne", "jasa antar barang", 6, 6, TSilang.MENDATAR), arrayOf("mobil", "kendaraan beroda 4", 7, 1, TSilang.MENDATAR), arrayOf("bri", "nama bank yang ada di indonesia", 10, 1, TSilang.MENDATAR), arrayOf("sidang", "ada hakim", 10, 5, TSilang.MENDATAR), arrayOf("sate", "daging yang dibakar", 8, 7, TSilang.MENDATAR),

                        arrayOf("gajah", "belalai", 1, 1, TSilang.MENURUN), arrayOf("musi", "sungai di palembang", 1, 3, TSilang.MENURUN), arrayOf("iri", "sirik", 2, 6, TSilang.MENURUN), arrayOf("mentega", "margarin", 2, 8, TSilang.MENURUN), arrayOf("sepion", "kaca untuk melihat ke belakang", 2, 10, TSilang.MENURUN), arrayOf("misil", "rudal", 4, 4, TSilang.MENURUN), arrayOf("bogor", "kota hujan ", 6, 2, TSilang.MENURUN), arrayOf("sad", "sedih (bahasa inggris)", 8, 7, TSilang.MENURUN), arrayOf("ten", "sepuluh (bahasa inggris)", 8, 9, TSilang.MENURUN)),
                arrayOf(arrayOf("ALSO", "Juga (Bahasa inggris)", 1, 1, TSilang.MENDATAR), arrayOf("BUBUK", "Serbuk", 1, 6, TSilang.MENDATAR), arrayOf("BELALANG", "Serangga yang lompat-lompat ", 3, 1, TSilang.MENDATAR), arrayOf("DNA", "Materi genetik", 5, 5, TSilang.MENDATAR), arrayOf("TKO", "Istilah menang saat lawan tak dapat mengimbangi perlawanan", 6, 3, TSilang.MENDATAR), arrayOf("muka", "wajah", 6, 7, TSilang.MENDATAR), arrayOf("OLI", "Pelumas", 7, 1, TSilang.MENDATAR), arrayOf("katak", "Hewan amfibi", 8, 3, TSilang.MENDATAR), arrayOf("bar", "Tempat yang menjual minuman beralkohol ", 10, 1, TSilang.MENDATAR), arrayOf("roda", "ban", 10, 5, TSilang.MENDATAR),

                        arrayOf("lte", "Jaringan 4G", 1, 2, TSilang.MENURUN), arrayOf("obat", "Diminum saat sakit", 1, 4, TSilang.MENURUN), arrayOf("bca", "Nama bank yang ada di indonesia", 1, 6, TSilang.MENURUN), arrayOf("bag", "Tas (bahasa inggris)", 1, 8, TSilang.MENURUN), arrayOf("kecamatan", "Bagian daerah yang membawahi kelurahan ", 1, 10, TSilang.MENURUN), arrayOf("baygon", "Merek obat nyamuk", 3, 1, TSilang.MENURUN), arrayOf("nyamuk", "Si penghisap darah", 3, 7, TSilang.MENURUN), arrayOf("tikar", "Gulung ... (bangkrut)", 6, 3, TSilang.MENURUN), arrayOf("dokter", "Suka membawa stetoskop", 5, 5, TSilang.MENURUN)),
                arrayOf(arrayOf("GEROBAK", "Didorong dorong", 1, 2, TSilang.MENDATAR), arrayOf("EJA", "Menyebutkan huruf satu per satu ", 3, 1, TSilang.MENDATAR), arrayOf("BADAI", "Cuaca buruk", 3, 6, TSilang.MENDATAR), arrayOf("LEM", "Perekat", 5, 3, TSilang.MENDATAR), arrayOf("DUA", "Angka genap", 6, 8, TSilang.MENDATAR), arrayOf("PEPAYA", "Buah yang didalamya banyak bijinya", 7, 1, TSilang.MENDATAR), arrayOf("PINTU", "Bisa di buka dan di tutup", 8, 6, TSilang.MENDATAR), arrayOf("NEXT", "Selanjutnya (Bahasa inggris)", 10, 1, TSilang.MENDATAR),

                arrayOf("GAJI", "Uang yang didapat setelah bekerja", 1, 2, TSilang.MENURUN), arrayOf("BABI", "Hewan yang di haramkan umat muslim", 1, 6, TSilang.MENURUN), arrayOf("KEDONDONG", "Buah yang bijinya kasar", 1, 8, TSilang.MENURUN), arrayOf("ISI", "Sesuatu yang ada didalam suatu benda atau sebagainya", 1, 10, TSilang.MENURUN), arrayOf("SELAMAT", "Terhindar dari bahaya", 4, 4, TSilang.MENURUN), arrayOf("SARUNG", "Kain untuk sholat", 5, 10, TSilang.MENURUN), arrayOf("SPAIN", "Spanyol (bahasa inggris) ", 6, 1, TSilang.MENURUN), arrayOf("SAPI", "Hewan ternak", 6, 6, TSilang.MENURUN)),
                arrayOf(arrayOf("dusun", "bawahnya desa", 1, 1, "MENdatar"), arrayOf("delete", "hapus (inggris)", 1, 1, "MENurun"), arrayOf("tata", "…..janeta (penyanyi)", 1, 7, "MENdatar"), arrayOf("ups", "universitas panca sakti", 1, 4, "MENurun"), arrayOf("pt", "perseroan terbatas", 2, 4, "MENdatar"), arrayOf("nt", "jenis windows", 1, 5, "MENurun"), arrayOf("luas", "lebar", 3, 1, "MENdatar"), arrayOf("tirai", "jendela", 1, 7, "MENurun"), arrayOf("rusa", "nama hewan seperti kambing", 3, 7, "MENdatar"), arrayOf("tts", "teka-teki silang", 1, 9, "MENurun"), arrayOf("tiru", "plagiat", 5, 1, "MENdatar"), arrayOf("rel", "lintasan kereta", 5, 3, "MENurun"), arrayOf("bisu", "tidak bisa berbicara", 5, 6, "MENdatar"), arrayOf("bca", "jenis bank di indonesia", 5, 6, "MENurun"), arrayOf("lalai", "teledor", 7, 3, "MENdatar"), arrayOf("untuk", "ke atau buat", 5, 9, "MENurun"), arrayOf("akad", "janji suci", 9, 2, "MENdatar"), arrayOf("led", "flash", 7, 5, "MENurun"), arrayOf("aka", "kakak (malaysa)", 9, 8, "MENdatar"), arrayOf("pay", "bayar (inggris)", 8, 2, "MENurun")),
                arrayOf(arrayOf("racun", "zat mematikan", 1, 1, "MENdatar"), arrayOf("rumah", "hunian", 1, 1, "MENurun"), arrayOf("rude", "penyanyi lagu magic", 1, 7, "MENdatar"), arrayOf("uus", "komika receh", 1, 4, "MENurun"), arrayOf("un", "ujian nasional", 2, 4, "MENdatar"), arrayOf("nn", "tulis nn", 1, 5, "MENurun"), arrayOf("miss", "kangen (inggris)", 3, 1, "MENdatar"), arrayOf("ranap", "rawat inap", 1, 7, "MENurun"), arrayOf("nail", "kuku (iggris)", 3, 7, "MENdatar"), arrayOf("dwi", "dua", 1, 9, "MENurun"), arrayOf("hura", "foya foya (diullang)", 5, 1, "MENdatar"), arrayOf("rrc", "republik rakyat cina", 5, 3, "MENurun"), arrayOf("ipar", "saudara dari pasangan", 5, 6, "MENdatar"), arrayOf("ide", "gagasan", 5, 6, "MENurun"), arrayOf("cobek", "ulekan", 7, 3, "MENdatar"), arrayOf("raisa", "penyanyi cantik indonesia", 5, 9, "MENurun"), arrayOf("ribut", "bertengkar", 9, 1, "MENdatar"), arrayOf("but", "tapi (inggris)", 7, 5, "MENurun"), arrayOf("rai", "muka (jawa)", 9, 8, "MENdatar"), arrayOf("dis", "diskualifikasi", 8, 2, "MENurun")),
                arrayOf(arrayOf("tiris", "disaring", 1, 1, "MENdatar"), arrayOf("tampak", "terlihat", 1, 1, "MENurun"), arrayOf("kids", "anak-anak (inggris)", 1, 7, "MENdatar"), arrayOf("milo", "merk susu", 3, 1, "MENdatar"), arrayOf("kurap", "panu", 1, 7, "MENurun"), arrayOf("ruko", "toko sebangunan dengan rumah", 3, 7, "MENdatar"), arrayOf("dkk", "dan kawan-kawan", 1, 9, "MENurun"), arrayOf("apes", "naas", 5, 1, "MENdatar"), arrayOf("end", "lawan kata first", 5, 3, "MENurun"), arrayOf("upah", "gaji", 5, 6, "MENdatar"), arrayOf("uga", "lehh… (boleh juga)", 5, 6, "MENurun"), arrayOf("dubai", "nama kota umi emirat arab", 7, 3, "MENdatar"), arrayOf("hamil", "mengandung janin", 5, 9, "MENurun"), arrayOf("kemal", "nama komedian dan komika", 9, 1, "MENdatar"), arrayOf("bal", "bola", 7, 5, "MENurun"), arrayOf("elo", "nama penyanyi lagu masih ada", 9, 8, "MENdatar"), arrayOf("sea", "laut (inggris)", 8, 2, "MENurun"))
        )

        var soal12x12 = arrayOf(arrayOf(arrayOf("putus", "terpotong menjadi dua", 1, 1, TSilang.MENDATAR), arrayOf("obor", "penerangan yang menggunakan bambu dan minyak tanah", 2, 5, TSilang.MENDATAR), arrayOf("bold", "tebal (Inggris)", 1, 9, TSilang.MENDATAR), arrayOf("sunat", "khitan", 3, 1, TSilang.MENDATAR), arrayOf("impas", "Sama besarnya", 3, 8, TSilang.MENDATAR), arrayOf("rugi", "lawan kata untung", 5, 1, TSilang.MENDATAR), arrayOf("musang", "hewan yang mirip berang-berang", 5, 6, TSilang.MENDATAR), arrayOf("pulih", "kembali sebagai semula", 7, 1, TSilang.MENDATAR), arrayOf("obral", "menjual barang dengan harga murah", 7, 7, TSilang.MENDATAR), arrayOf("semir", "untuk menggilapkan sepatu", 9, 1, TSilang.MENDATAR), arrayOf("inner", "dalam (Inggris)", 9, 7, TSilang.MENDATAR), arrayOf("isa", "salah satu personil bajai", 10, 5, TSilang.MENDATAR), arrayOf("gelas", "tempat untuk minum", 12, 1, TSilang.MENDATAR), arrayOf("mahal", "tinggi harganya", 12, 7, TSilang.MENDATAR),

                arrayOf("pasir", "butir-butir batu yang halus", 1, 1, TSilang.MENURUN), arrayOf("tanggal", "kalender", 1, 3, TSilang.MENURUN), arrayOf("soto", "masakan berkuah", 1, 5, TSilang.MENURUN), arrayOf("ri", "Republik Indonesia", 2, 8, TSilang.MENURUN), arrayOf("dosa", "perbuatan buruk akan mendapat", 1, 12, TSilang.MENURUN), arrayOf("panda", "hewan berasal dari cina", 3, 10, TSilang.MENURUN), arrayOf("utopia", "nama band yang beraliran Rock", 5, 7, TSilang.MENURUN), arrayOf("iri", "sirik", 7, 4, TSilang.MENURUN), arrayOf("rendah", "tidak tinggi", 7, 9, TSilang.MENURUN), arrayOf("mall", "Tempat shopping", 9, 3, TSilang.MENURUN), arrayOf("rias", "dandan", 9, 5, TSilang.MENURUN), arrayOf("real", "riil", 9, 11, TSilang.MENURUN)),

                arrayOf(arrayOf("asuransi", "bisnis pelindung finansial", 1, 1, TSilang.MENDATAR), arrayOf("ampun", "meminta maaf", 3, 6, TSilang.MENDATAR), arrayOf("jurang", "lambah yang curam", 5, 1, TSilang.MENDATAR), arrayOf("amatir", "bukan sesuatu yang sesungguhnya, tidak murni", 6, 7, TSilang.MENDATAR), arrayOf("hantu", "mahkluk yang membuat manusia takut", 8, 1, TSilang.MENDATAR), arrayOf("unggul", "melebihi yang lain", 9, 7, TSilang.MENDATAR), arrayOf("palu", "alat perkakas untuk memukul paku", 11, 7, TSilang.MENDATAR),

                        arrayOf("sempurna", "utuh dan lengkap segalanya / tidak cacat", 1, 2, TSilang.MENURUN), arrayOf("rupiah", "mata uang indonesia", 1, 4, TSilang.MENURUN), arrayOf("impian", "mengharapkan dengan sangat yang di inginkan", 1, 8, TSilang.MENURUN), arrayOf("putar", "berkeliling-keliling", 2, 12, TSilang.MENURUN), arrayOf("homo", "sesuka sesama jenis", 8, 1, TSilang.MENURUN), arrayOf("nama", "yang ada di ktp", 8, 3, TSilang.MENURUN), arrayOf("rusak", "benda yang sudah hancur", 7, 5, TSilang.MENURUN), arrayOf("ultra", "amat sangat(inggris)", 8, 12, TSilang.MENURUN), arrayOf("tungku", "tempat pembakaran yang menggunakan kayu", 6, 10, TSilang.MENURUN)))
    }
}