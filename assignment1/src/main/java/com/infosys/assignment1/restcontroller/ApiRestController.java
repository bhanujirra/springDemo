package com.infosys.assignment1.restcontroller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
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
import com.infosys.assignment1.service.ApiInterface;
@RestController

public class ApiRestController {
//	ArrayList<Integer>
	
	@Autowired
	private ApiInterface apiService; 
	

	@GetMapping(value = "/Fibonacci", produces = "application/json")
	public ResponseEntity<Integer> fibonacci(@RequestHeader MultiValueMap<String, String> header, @RequestParam("n") Integer n) throws TypeMismatchException{
		Integer fib = apiService.fibonacci(n);
		
	
		return new ResponseEntity<>(fib, header, HttpStatus.OK);
	}
	
	@GetMapping(value = "/ReverseWords", produces = "application/json")
	public ResponseEntity<String> reverseWords(@RequestHeader MultiValueMap<String, String> header, @RequestParam("sentence") String s) throws TypeMismatchException{
		String revesedSentence = apiService.reverseWords(s);
		
		
		return new ResponseEntity<>(revesedSentence,header, HttpStatus.OK);
	}
	
	@GetMapping(value = "/TriangleType", produces = "application/json")
	public ResponseEntity<String> triangleType(@RequestHeader MultiValueMap<String, String> header, @RequestParam("a") Integer a, @RequestParam("b") Integer b, @RequestParam("c") Integer c) throws TypeMismatchException{
		String triangle = apiService.triangleType(a,b,c);
		
		return new ResponseEntity<>(triangle, header, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/makeonearray", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Integer>> makeOneArray(@RequestHeader MultiValueMap<String, String> header, @RequestBody Object ob){
	
		@SuppressWarnings("unchecked")
		List<Integer> oneArray = apiService.makeOneArray((LinkedHashMap<String, ArrayList<Integer> >) ob);
		return new ResponseEntity<>(oneArray, header, HttpStatus.OK);
	}
	
		
}
