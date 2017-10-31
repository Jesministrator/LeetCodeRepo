package com.wxueyuan.topic.array;

import java.util.Arrays;
import java.util.HashMap;

import com.wxueyuan.util.ExecutionTimeAnalyzer;

public class TwoSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[10000];
		for(int i=1; i<=10000; i++) {
			input[i-1] = i;
		}
		new Thread(()->{
			long time =ExecutionTimeAnalyzer.getExecutionTime(() -> {
				System.out.println(Arrays.toString(twoSum(input, 19999)));
			});
			System.out.println(time+"ms");
		}).start(); 
		new Thread(()->{
			long time =ExecutionTimeAnalyzer.getExecutionTime(() -> {
				System.out.println(Arrays.toString(twoSum2(input, 19999)));
			});
			System.out.println(time+"ms");
		}).start();  
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
        		for(int j=i+1; j<nums.length; j++) {
        			if(nums[i] + nums[j] == target) {
        				return new int[]{i,j};
        			}
        		}
        }
        throw new IllegalArgumentException("给定数组中没有满足条件的两个数");
    }
	
	public static int[] twoSum2(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
			
		}
		throw new IllegalArgumentException("给定数组中没有满足条件的两个数");
	}

}
