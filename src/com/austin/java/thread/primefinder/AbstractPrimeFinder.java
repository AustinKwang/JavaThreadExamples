package com.austin.java.thread.primefinder;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: AbstractPrimeFinder.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AbstractPrimeFinder.java 72642 2009-01-01 20:01:57Z ACHIEVO\austin.wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Mar 4, 2015		austin.wang		Initial.
 *  
 * </pre>
 */
public abstract class AbstractPrimeFinder
{
	public boolean isPrime(final int number)
	{
		if(number < 1)
		{
			return false;
		}
		for(int i = 2; i < Math.sqrt(number); i++)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public int countPrimesInRange(final int lower, final int upper)
	{
		int total = 0;
		for(int i = lower; i < upper; i ++)
		{
			if(isPrime(i))
			{
				total ++;
			}
		}
		return total;
	}
	
	public void timeAndCompute(final int number) throws Exception
	{
		final long start = System.nanoTime();
		
		final long numberOfPrimes = countPrimes(number);
		
		final long end = System.nanoTime();
		
		System.out.printf("Number of primes %d is %d \n", number, numberOfPrimes);
		System.err.println("Time(Seconds) taken is " + (end - start)/1.0e9);
	}
	
	public abstract int countPrimes(final int number) throws Exception;
}


/*
*$Log: av-env.bat,v $
*/