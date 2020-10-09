package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RefreshTokenRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;
import com.example.demo.service.RefreshTokenService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
	
	private final AuthService authService;
	private final RefreshTokenService refreshTokeService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		log.info("User with username " + registerRequest.getUsername() + " registered successfully.");
		return new ResponseEntity<>("User Registration Successful",HttpStatus.OK);
	}
	 
	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		authService.verifyAccount(token);
		log.info("Account activated successfully");
		return new ResponseEntity<>("Account activated successfully" , HttpStatus.OK);
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		log.info("User with username " + loginRequest.getUsername() + " logged in successfully.");
		return authService.login(loginRequest);
	}
	
	@PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
		log.info("User with username " + refreshTokenRequest.getUsername() + " refreshed token.");
        return authService.refreshToken(refreshTokenRequest);
    }
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
		refreshTokeService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
		log.info("User with username " + refreshTokenRequest.getUsername() + " logged out.");
		return ResponseEntity.status(HttpStatus.OK).body("Refresh token deleted successfully");
	}
	
	
}
