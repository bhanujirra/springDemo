package com.infosys.assignment1.service;

import java.util.List;

import com.infosys.assignment1.dto.ArrayDTO;

public interface ApiInterface {
	Integer fibonacci(Integer n);

	String reverseWords(String s);

	String triangleType(Integer a, Integer b, Integer c);

	Integer[] makeOneArray(ArrayDTO arrayDTO); 
}
