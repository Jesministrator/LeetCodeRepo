package com.wxueyuan.util;

public class ExecutionTimeAnalyzer {
	public static long getExecutionTime(CodeExecutor ce) {
		long startTime = System.currentTimeMillis();
		ce.execute();
		long endTime = System.currentTimeMillis();
		return (endTime-startTime);
	}
}

