package com.peter.adts.ArrayList;

public class ArrayList {
	
	private long size;
	
	public ArrayList() {
		this(32);
	}
	
	public ArrayList(long initSize) {
		size = initSize;
		System.out.println(size);
	}
	
}
