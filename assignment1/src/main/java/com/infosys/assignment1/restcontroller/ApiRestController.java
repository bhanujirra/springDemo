package com.infosys.assignment1.restcontroller;


import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.assignment1.exception.AssignmentException;
import com.infosys.assignment1.service.ApiInterface;
@RestController

public class ApiRestController {

	@Autowired
	private ApiInterface apiService; 
	

	@GetMapping(value = "/Fibonacci", produces = "application/json")
	public ResponseEntity<BigInteger> fibonacci(@RequestParam("n") Object n) throws AssignmentException{
		BigInteger fib;
		try {
			Integer integer = Integer.parseInt(n.toString());
			fib = apiService.fibonacci(integer);
		}
		catch (Exception e) {
			throw new AssignmentException("number.decimal");
		}
		
		
		if(fib.equals(BigInteger.valueOf(0))) {
			throw new AssignmentException("number.negative");
		}
		
	
		return new ResponseEntity<>(fib, HttpStatus.OK);
	}
	
	@GetMapping(value = "/ReverseWords", produces = "application/json")
	public ResponseEntity<String> reverseWords(@RequestHeader MultiValueMap<String, String> header, @RequestParam("sentence") String s){
		String revesedSentence = apiService.reverseWords(s);
		
		return new ResponseEntity<>(revesedSentence,header, HttpStatus.OK);
	}
	
	@GetMapping(value = "/TriangleType", produces = "application/json")
	public ResponseEntity<String> triangleType(@RequestHeader MultiValueMap<String, String> header, @RequestParam("a") Object a, @RequestParam("b") Object b, @RequestParam("c") Object c) throws AssignmentException{
		Integer a1;
		Integer b1;
		Integer c1;
		try {
			a1 = Integer.parseInt(a.toString());
			b1 = Integer.parseInt(b.toString());
			c1 = Integer.parseInt(c.toString());	
		}
		catch (Exception e) {
			throw new AssignmentException("number.decimal");
		}
		
		String triangle = apiService.triangleType(a1,b1,c1);
		if(triangle.isEmpty()) {
			throw new AssignmentException("triangle.notpossible");
		}
		return new ResponseEntity<>(triangle, header, HttpStatus.OK);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/makeonearray", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LinkedHashMap<String, List<Integer>>> makeOneArray(@RequestHeader MultiValueMap<String, String> header, @RequestBody Object ob) throws AssignmentException{
	
		LinkedHashMap<String, List<Integer>> oneArray = new LinkedHashMap<>();
		try{
			 oneArray= apiService.makeOneArray((LinkedHashMap<String, List<Integer> >) ob);
		}
		catch(Exception e) {
			throw new AssignmentException("array.invalid");
		}
		return new ResponseEntity<>(oneArray, header, HttpStatus.OK);
	}
	
		
}
