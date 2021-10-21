package com.infosys.assignment1.restcontroller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.assignment1.dto.ArrayDTO;
//import com.infosys.assignment1.dto.MyDTO;
import com.infosys.assignment1.service.ApiInterface;
//import com.infosys.dto.LoginDTO;

@RestController

public class ApiRestController {
	
	@Autowired
	private ApiInterface apiService; 
	
	
	@GetMapping(value = "/Fibonacci", produces = "application/json")
	public ResponseEntity<Integer> fibonacci(@RequestParam("n") Integer n) throws Exception{
		Integer fib = apiService.fibonacci(n);
		
		return new ResponseEntity<Integer>(fib, HttpStatus.OK);
	}
	
	@GetMapping(value = "/ReverseWords", produces = "application/json")
	public ResponseEntity<String> reverseWords(@RequestParam("sentence") String s) throws Exception{
		String revesedSentence = apiService.reverseWords(s);
		return new ResponseEntity<String>(revesedSentence, HttpStatus.OK);
	}
	
	@GetMapping(value = "/TriangleType", produces = "application/json")
	public ResponseEntity<String> triangleType(@RequestParam("a") Integer a, @RequestParam("b") Integer b, @RequestParam("c") Integer c) throws Exception{
		String triangle = apiService.triangleType(a,b,c);
		return new ResponseEntity<String>(triangle, HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value = "/makeonearray", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Integer[]> makeOneArray(@RequestBody ArrayDTO arrayDTO){
		
		System.out.println(arrayDTO.getArray2().length);
		
		Integer[] oneArray = apiService.makeOneArray(arrayDTO);;
		return new ResponseEntity<Integer[]>(oneArray, HttpStatus.OK);
	}
	
	
	
		
}
