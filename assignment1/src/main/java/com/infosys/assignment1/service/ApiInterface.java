package com.infosys.assignment1.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public interface ApiInterface{
	Integer fibonacci(Integer n);

	String reverseWords(String s);

	String triangleType(Integer a, Integer b, Integer c);

	List<Integer> makeOneArray(LinkedHashMap<String, ArrayList<Integer>> a);

}
