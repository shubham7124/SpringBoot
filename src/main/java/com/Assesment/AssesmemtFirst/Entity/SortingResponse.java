package com.Assesment.AssesmemtFirst.Entity;

public class SortingResponse {
	
	private int[][] sortedArrays;
    private long timeNs;
	public int[][] getSortedArrays() {
		return sortedArrays;
	}
	public void setSortedArrays(int[][] sortedArrays) {
		this.sortedArrays = sortedArrays;
	}
	public long getTimeNs() {
		return timeNs;
	}
	public void setTimeNs(long timeNs) {
		this.timeNs = timeNs;
	}
	public SortingResponse(int[][] sortedArrays, long timeNs) {
		super();
		this.sortedArrays = sortedArrays;
		this.timeNs = timeNs;
	}
	
	
	

}
