package com.infosys.assignment1.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;



@Service
public class ApiService implements ApiInterface{
		public BigInteger fibonacci(Integer n) {
			if(n<=0) {
				return BigInteger.valueOf(0);
			}
			
			if(n == 1 || n == 2) return BigInteger.valueOf(1);
			
			BigInteger a = BigInteger.valueOf(1);
			BigInteger b = BigInteger.valueOf(1);
			
			while(n > 2) {
				BigInteger temp = a;
				a = b;
				b = b.add(temp);
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
			reversedString.deleteCharAt(reversedString.length()-1);
			return reversedString.toString();
		}

		@Override
		public String triangleType(Double a, Double b, Double c){
			if((a<=0 || b<=0 || c<=0) || ((a+b)<c || (a+c)<b ||(b+c)<a)) {
				return "";
			}
			
			if(a.equals(b) && b.equals(c))
				return "Equilateral";
			else if(a.equals(b) || b.equals(c) || a.equals(c))
				return "Isosceles";
			return "Scalene";
		}

		@Override
		public LinkedHashMap<String, List<Integer>> makeOneArray(LinkedHashMap<String, List<Integer>> a) {
			
			LinkedHashMap<String, List<Integer>> result = new LinkedHashMap<>();
			
			List<Integer> resList =a.values().stream().flatMap(Collection::stream).distinct().sorted().collect(Collectors.toList());
			 
			result.put("Array", resList);
			return result;
		}

		
}
