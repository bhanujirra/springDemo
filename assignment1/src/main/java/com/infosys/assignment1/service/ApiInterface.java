package com.infosys.assignment1.service;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;


public interface ApiInterface{
	BigInteger fibonacci(Integer n);

	String reverseWords(String s);

	String triangleType(Integer a, Integer b, Integer c);

	LinkedHashMap<String, List<Integer>> makeOneArray(LinkedHashMap<String, List<Integer>> a);

}
