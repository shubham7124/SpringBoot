package com.Assesment.AssesmemtFirst.Entity;

import java.util.Arrays;

public class SortTask implements Runnable {
	private final int[] array;

    public SortTask(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Arrays.sort(array);
    }

}
