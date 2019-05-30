package com.jumbox.tekatekisilang;

/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

public class TTS {

    public static final String TAG = "TTS";

	private String tts;
	private String kode;
	private String clue;
	private int id;
	private String up;
	private Boolean oriental;

	public void setTts(String mTts) {
		// TODO Auto-generated method stub
		tts=mTts;
	}

	public void setKode(String wKode) {
		// TODO Auto-generated method stub
		kode=wKode;
	}

	public String getTts() {
		// TODO Auto-generated method stub
		return tts;
	}

	public String getKode() {
		// TODO Auto-generated method stub
		return kode;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		id=i;
	}

	public void setClue(String mClue) {
		// TODO Auto-generated method stub
		clue=mClue;
	}
	public String getClue() {
		// TODO Auto-generated method stub
		return clue;
	}

	public void setUpdate(String text) {
		// TODO Auto-generated method stub
		up=text;
	}
	
	public String getUpdate() {
		// TODO Auto-generated method stub
		return up;
	}

	public void setOrie(boolean orie) {
		// TODO Auto-generated method stub
		oriental=orie;
	}
	
	public Boolean getOrie() {
		// TODO Auto-generated method stub
		return oriental;
	}

}
