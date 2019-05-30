package com.jumbox.tekatekisilang;

/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

public class TSilang {

    public static final String TAG = "TSilang";
	public static final boolean MENDATAR = true;
	public static final boolean MENURUN = false;
	public static final int KOTAK_12X12 = 12;
	public static final int KOTAK_10X10 = 10;

	private String[][] tts;
	private int rows =10;
	private int cols=10;
	private String DEFAULT = null;
	private String[][] wKode;
	private String[][] wClue;
	private boolean[][] wOrie;
	private int size = -1;
	
	public TSilang() {
		tts = new String[rows][cols];
		wKode = new String[rows][cols];
		wClue = new String[rows][cols];
		wOrie = new boolean[rows][cols];
		
		for(int y=0; y<tts.length;y++) {
			for(int x=0;x<tts[y].length;x++) {
				
				tts[y][x] = " ";
				wKode[y][x] = DEFAULT;
				wClue[y][x] = DEFAULT;
				wOrie[y][x] = null != null;
				
				size++;
			}
		}
	}
	
	public TSilang(int mrows,int mCols) {
		rows = mrows;
		cols = mCols;
		
		tts = new String[rows][cols];
		wKode = new String[rows][cols];
		wClue = new String[rows][cols];
		wOrie = new boolean[rows][cols];

		for(int y=0; y<tts.length;y++) {
			for(int x=0;x<tts[y].length;x++) {

				tts[y][x] = " ";
				wKode[y][x] = DEFAULT;
				wClue[y][x] = DEFAULT;
				wOrie[y][x] = null != null;

				size++;
			}
		}
	}
	
	public boolean add(String s, String cl, int row, int colm, boolean b) {
		
		int j=0;
		if(b) {
		while(j < s.length()) {
			
			if(wKode[(row-1)][(colm-1 + j)] !=null) {
				wKode[(row-1)][(colm-1 + j)] = wKode[(row-1)][(colm-1 + j)] + ":" + s;
				wClue[(row-1)][(colm-1 + j)] = wClue[(row-1)][(colm-1 + j)] + ";" + cl;
			} else {
				wKode[(row-1)][(colm-1 + j)] = s;
				wClue[(row-1)][(colm-1 + j)] = cl;
			}
			tts[(row-1)][(colm-1 + j)] = String.valueOf(s.charAt(j));
			wOrie[(row-1)][(colm-1 + j)] = true;
			j++;
		}
		} else {
			while(j < s.length()) {
				if(wKode[(row-1 + j)][(colm-1)] !=null) {
					wKode[(row-1 + j)][(colm-1)] = wKode[(row-1 + j)][(colm-1)] + ":" + s;
					wClue[(row-1 + j)][(colm-1)] = wClue[(row-1 + j)][(colm-1)] + ";" + cl;
				} else {
					wKode[(row-1 + j)][(colm-1)] = s;
					wClue[(row-1 + j)][(colm-1)] = cl;
				}
				tts[(row-1 + j)][(colm-1)] = String.valueOf(s.charAt(j));
				wOrie[(row-1 + j)][(colm-1)] = false;
				j++;
			}
		}
		return true;
	}
	
	public String hTts(int row, int cols) {
		return tts[row][cols];
	}
	
	public String hKode(int row, int cols) {
		return wKode[row][cols];
	}
	
	public String hClue(int row, int cols) {
		return wClue[row][cols];
	}
	
	public boolean hOrie(int row, int cols) {
		return wOrie[row][cols];
	}
	
	public int size() {
		return size;
	}
	
}
