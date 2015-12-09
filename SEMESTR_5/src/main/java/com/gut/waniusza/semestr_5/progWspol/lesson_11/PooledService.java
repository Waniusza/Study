package com.gut.waniusza.semestr_5.progWspol.lesson_11;

import java.util.concurrent.Callable;

public class PooledService implements Callable<Integer> {
	private Integer[] array;
	private int start;
	private int end;
	
	public PooledService(Integer[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		Integer sum = 0;
		for (int i=start; i<=end; i++) {
			sum += array[i];
		}
		return sum;
	}
}
