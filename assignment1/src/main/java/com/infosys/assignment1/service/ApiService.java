package com.infosys.assignment1.service;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;

import org.springframework.stereotype.Service;

import com.infosys.assignment1.dto.ArrayDTO;

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
			String reversedString = "";
			for(String i:words) {
				reversedString =reversedString + " "+ new StringBuffer(i).reverse();
			}
			return reversedString;
		}

		@Override
		public String triangleType(Integer a, Integer b, Integer c) {
			if(a==b && b==c && a == c)
				return "Equilateral";
			else if((a==b && a!=c) || (a==c && a!=b) || (b == c && a!=b))
				return "Scalene";
			return "Isosceles";
		}

		@Override
		public Integer[] makeOneArray(ArrayDTO arrayDTO) {
			// TODO Auto-generated method stub
			TreeSet<Integer> set = new TreeSet<>();
			for (Integer integer : arrayDTO.getArray1()) {
				set.add(integer);
			}
			for (Integer integer : arrayDTO.getArray2()) {
				set.add(integer);
			}
			for (Integer integer : arrayDTO.getArray3()) {
				set.add(integer);
			}
			return set.stream().toArray(Integer[] ::new);
		}
		
}
