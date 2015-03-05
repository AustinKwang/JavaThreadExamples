package com.austin.java.thread.primefinder;
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
public class SequentialPrimeFinder extends AbstractPrimeFinder
{

	@Override
	public int countPrimes(int number)
	{
		return super.countPrimesInRange(1, number);
	}

	public static void main(String[] args) throws Exception
	{
		new SequentialPrimeFinder().timeAndCompute(10000000);
	}
}

/*
*$Log: av-env.bat,v $
*/