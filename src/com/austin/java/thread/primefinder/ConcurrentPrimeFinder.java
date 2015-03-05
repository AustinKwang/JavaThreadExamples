package com.austin.java.thread.primefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SequentialPrimeFinder.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SequentialPrimeFinder.java 72642 2009-01-01 20:01:57Z ACHIEVO\austin.wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Mar 4, 2015		austin.wang		Initial.
 *  
 * </pre>
 */
public class ConcurrentPrimeFinder extends AbstractPrimeFinder
{
	private final int poolSize;
	
	private final int numberOfParts;
	
	public ConcurrentPrimeFinder(final int thePoolSize, final int theNuberOfPart)
	{
		poolSize = thePoolSize;
		numberOfParts = theNuberOfPart; 
	}
	
	@Override
	public int countPrimes(int number) throws Exception
	{
		int count = 0;
		final List<Callable<Integer>> partitions = new ArrayList<Callable<Integer>>();
		final int chunkPerPartition = number/ numberOfParts;
		
		for(int i = 0; i < numberOfParts; i ++)
		{
			final int lower = (i * chunkPerPartition) + 1;
			final int upper = (i == numberOfParts - 1) ? number : lower + chunkPerPartition -1;
			partitions.add(new Callable<Integer>(){

				@Override
				public Integer call() throws Exception
				{
					return countPrimesInRange(lower, upper);
				}});
		}
		
		final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
		
		final List<Future<Integer>> resultFromParts = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
		executorPool.shutdown();
		
		for (Future<Integer> future : resultFromParts)
		{
			count += future.get();
		}
		return count;
	}

	public static void main(String[] args) throws Exception
	{
		new ConcurrentPrimeFinder(4, 100).timeAndCompute(10000000);
	}
}

/*
*$Log: av-env.bat,v $
*/