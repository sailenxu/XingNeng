package com.test.perforentity;

/**
 * 保存内存的瞬间值和时间
 */
public class MemInfo {
	private String time;
	private int memValue;
	
	public MemInfo(String time,int memValue) {
		// TODO Auto-generated constructor stub
		this.time=time;
		this.memValue=memValue;
	}
	
	public String time(){
		return time;
	}
	public int memValue(){
		return memValue;
	}
}
