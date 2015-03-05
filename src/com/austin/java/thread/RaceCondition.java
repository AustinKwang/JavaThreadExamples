package com.austin.java.thread;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: RaceCondition.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: RaceCondition.java 72642 2009-01-01 20:01:57Z ACHIEVO\austin.wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Mar 4, 2015		austin.wang		Initial.
 *  
 * </pre>
 */
public class RaceCondition
{
//	private static volatile boolean done;
	private static boolean done;
	//volatile 告知JIT编译器不要对标记变量执行任何可能影响其访问顺序的优化， 但是过多的使用此关键字，会导致性能下降. 且无法保证操作额原子性
	
	public static void main(String[] args) throws Exception
	{
		//new another thread
		new Thread(
			new Runnable(){
				@Override
				public void run()
				{
					int i = 0;
					//while(!done)
					while(!getFlag())
					{
						i ++;
					}
					System.out.println("Done");
				}
				
			}
		).start();
		
		System.out.println("OS: " + System.getProperty("os.name"));
		Thread.sleep(2000);
		//done = true;
		setFlag(true);
		System.out.println("Flag done set as true");
		System.out.println("CPU processors: " + Runtime.getRuntime().availableProcessors());
	}
	
	public static synchronized boolean getFlag()
	{
		return done;
	}
	
	public static synchronized void setFlag(boolean flag)
	{
		done = flag;
	}
}

/*
*$Log: av-env.bat,v $
*/