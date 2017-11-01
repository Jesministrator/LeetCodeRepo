package com.wxueyuan.topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums).toString());
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		//先将整个数组排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<nums.length-2; i++) {
			//如果nums[i]与前一个元素相同，则跳过
			if(i==0 || (i>0&&nums[i]!=nums[i-1])) {
				//li为左向遍历的索引，ri为右向遍历的索引，sum为num[i]的相反数
				int li=i+1, ri=nums.length-1, sum = 0-nums[i];
				//只要两个索引没有相交
				while(li<ri) {
					//两数相加等于sum
					if(nums[li]+nums[ri] == sum) {
						//在result中增加这三个数的组合
						result.add(Arrays.asList(nums[i],nums[li],nums[ri]));
						//继续遍历，跳过重复元素
						while(li<ri && nums[li]==nums[li+1]) li++;
						while(li<ri && nums[ri]==nums[ri-1]) ri--;
						li++;
						ri--;
					}
					//如果两数相加小于sum，左索引+1，去找更大的数
					else if(nums[li] +nums[ri] <sum) {
						//继续遍历，跳过重复元素
						while(li<ri && nums[li]==nums[li+1]) li++;
						li++;
					}
					//如果两数相加大于sum，又索引-1，去找更小的数
					else {
						//继续遍历，跳过重复元素
						while(li<ri && nums[ri]==nums[ri-1]) ri--;
						ri--;
					}
				}
			}
		}
		return result;
    }

}
