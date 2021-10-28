package com.infosys.assignment1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class ApiService implements ApiInterface{
		public Integer fibonacci(Integer n) {
			int a = 0;
			int b = 1;
			if(n==1) return 0;
			if(n==2) return 1;
			
			while(n > 2) {
				int temp = a;
				a = b;
				b = b+temp;
				n--;
			}
			return b;
		}
		
		public String reverseWords(String s) {
			
			String[] words = s.split(" ");
			StringBuilder reversedString = new StringBuilder();
			for(String i:words) {
				reversedString.append(new StringBuffer(i).reverse()+" ");
			}
			return reversedString.toString().strip();
		}

		@Override
		public String triangleType(Integer a, Integer b, Integer c) {
			if(a.equals(b) && b.equals(c))
				return "Equilateral";
			else if(a.equals(b) || b.equals(c) || a.equals(c))
				return "Isosceles";
			return "Scalene";
		}

		@Override
		public List<Integer> makeOneArray(LinkedHashMap<String, ArrayList<Integer>> a) {
			
//			TreeSet<Integer> set = new TreeSet<>();
//			for(ArrayList<Integer> array:a.values()) {
//				for(Integer i:array) {
//					set.add(i);
//				}
//			}
//			return set.stream().collect(Collectors.toList());
			return a.values().stream().flatMap(Collection::stream).distinct().sorted().collect(Collectors.toList());
			 
			
		}

		
}
