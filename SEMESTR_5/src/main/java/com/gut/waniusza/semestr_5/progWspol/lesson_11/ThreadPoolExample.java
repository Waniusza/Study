package com.gut.waniusza.semestr_5.progWspol.lesson_11;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
	
	public static void main(String[] args) {
		int numberOfIntegers = 100;
		int numberOfThreads = 10;
		
		Integer[] array = new Integer[numberOfIntegers];
		for (int i=0; i<numberOfIntegers; i++) {
			array[i] = i+1;
		}
		
		LinkedList<Callable<Integer>> serviceList = new LinkedList<>();
		
		int start = 0;
		int end;
		int howMany = numberOfIntegers / numberOfThreads + 1;
		
		for (int k=0; k<numberOfThreads; k++) {
			end = start + howMany - 1;
			if (end > numberOfIntegers) {
				end = numberOfIntegers - 1;
			}
			System.out.println("Task " + k + " start: " + start + " end: " + end);
			serviceList.add(new PooledService(array,start,end));
			start = end + 1;
		}
                
		
		ThreadPoolExecutor pool = 
				new ThreadPoolExecutor(
						numberOfThreads,
						numberOfThreads,
						1L,TimeUnit.SECONDS,
						new LinkedBlockingQueue<Runnable>()
						);
		
		try {
			List<Future<Integer>> futureList;
			futureList =  pool.invokeAll(serviceList);
			
			int sum = 0;
			for (Future<Integer> future: futureList) {
				sum += future.get();
			}
			
			System.out.println("result: " + sum);
			pool.shutdown();
		} catch(Exception e) {}
	}

}
