package zy3;

import java.util.HashSet;
import java.util.Set;

public class cjy01 {
	public static void main(String[] args) {
		int a=0;
	    String s = "abcdefabcda";
	    Set<String> set = new HashSet<String>();
		String []cjy = s.split("");
		
		//ШЅжи
		for(int i=0;i<cjy.length;i++) {
			set.add(cjy[i]);
		}
		
		Object[]arr =  set.toArray();		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}		
		
		
	}
}
