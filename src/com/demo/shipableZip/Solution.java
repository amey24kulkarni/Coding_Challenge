package com.demo.shipableZip;
import java.util.*;

public class Solution {
	public static List<int[]> mergeZipCodes(int[][] invalidZipcodes){
		List<int[]> res = new ArrayList<>();
		Arrays.sort(invalidZipcodes,(n1,n2) -> n1[0] - n2[0]); //Sorting according to first zipcode in the array so that zipcodes can be compared
		int[] cur_zipcode = invalidZipcodes[0];
		res.add(cur_zipcode); //Adding first as nothing prev to compare
		for(int[] invalidZipcode : invalidZipcodes) {
			int prev_end = cur_zipcode[1]; 
			int cur_start = invalidZipcode[0]; 
			int cur_end = invalidZipcode[1];
			if(prev_end >= cur_start) { //If prev_end val is greater than current start then calculate max between them as next interval might be small than current interval 
				cur_zipcode[1] = Math.max(prev_end,cur_end);
			}
			else {
				cur_zipcode = invalidZipcode;
				res.add(cur_zipcode); //Ignore if condition is true else add current_Zipcode
			}		
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] invalidZipcodes = {{94133,94133},{94200,94299},{94226,94399}};
		List<int[]> output = mergeZipCodes(invalidZipcodes);
		List<List<Integer>> res = new ArrayList<>();
		output.forEach(arr->res.add(Arrays.asList(arr[0],arr[1])));
		System.out.println(res);
	}
}
