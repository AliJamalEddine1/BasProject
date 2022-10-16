package com.auth.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.model.Client;
import com.auth.util.ClientService;
import com.auth.util.JwtUtil;

@RequestMapping("/auth")
@RestController
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	ClientService ser;
	
		@PostMapping("/login/{userName}/{password}")
		public ResponseEntity<Object> login(@PathVariable String userName, @PathVariable String password) {
			Client c=ser.login(userName,password).get(0);
			Map<String ,Object> map=new HashMap<String,Object>();
			//ResponseEntity<Object> res=new ResponseEntity<Object>(l, null);
			if(c!=null) {
			String token = jwtUtil.generateToken(userName);
			map.put("client", c);
			map.put("token", token );
			return new ResponseEntity<Object>(map, HttpStatus.OK);
			}
			return null;
		}
		@PostMapping("/refresh")
		public ResponseEntity<String> refreshToken(@RequestBody String userName){
		
			String token=jwtUtil.generateToken(userName);
			return new ResponseEntity<String>(token, HttpStatus.OK);
			
		}

	@GetMapping("/api")
	public String getMsg() {
		return "hello";
	}
	
		@PostMapping("/register")
		public boolean register(@RequestBody Client c) {
			// Persist user to some persistent storage
			
			System.out.println("Info saved...");
			return ser.addClient(c);
			
		}
		
	
	}
