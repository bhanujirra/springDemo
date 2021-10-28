package com.infosys.assignment1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.mockito.InjectMocks;
import org.junit.Before;
import org.junit.Test;



public class ApiServiceTest{
		
	@InjectMocks
	private ApiService apiService;
		
	@Before
	public void setup() throws Exception {
		apiService = new ApiService();
	}
	
	@Test
	public void testFibonacci() {
		Integer x =6;
		Integer res = apiService.fibonacci(x);
		assertNotNull(res);
		
		Integer y = 5;
		assertEquals(res,y);
	}
	
	@Test
	public void testFibonacci1() {
		Integer res = apiService.fibonacci(1);
		assertNotNull(res);
		assertEquals(res,Integer.valueOf(0));
	}
	
	@Test
	public void testFibonacci2() {
		Integer res = apiService.fibonacci(2);
		assertNotNull(res);
		assertEquals(res,Integer.valueOf(1));
	}
	
	@Test
	public void testReverseWords() {
		String res = apiService.reverseWords("Hi Telstra");
		assertNotNull(res);
		String x="iH artsleT";
		assertEquals(res,x);
	}
	
	@Test
	public void testTriangleType() {
		Integer a = 3, b = 3, c = 3;
		String res = apiService.triangleType(a,b,c);
		assertNotNull(res);
		String x="Equilateral";
		assertEquals(res,x);
	}
	
	@Test
	public void testTriangleType1() {
		String res = apiService.triangleType(1,2,3);
		assertNotNull(res);
		String x="Scalene";
		assertEquals(res,x);
	}
	
	@Test
	public void testTriangleType2() {
		String res = apiService.triangleType(2,2,3);
		assertNotNull(res);
		String x="Isosceles";
		assertEquals(res,x);
	}
	
	@Test
	public void testMakeOneArray() {
		LinkedHashMap<String, ArrayList<Integer>> a= new LinkedHashMap<>();
		a.put("Array1", new ArrayList<>(Arrays.asList(1,2,3)));
		a.put("Array2", new ArrayList<>(Arrays.asList(1,5,3,6)));
		List<Integer> res = apiService.makeOneArray(a);
		assertNotNull(res);
	    List<Integer> x = new ArrayList<>(Arrays.asList(1,2,3,5,6));
		assertEquals(res,x);
	}
	
	
	
	

}
