package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KardemirDto;
import com.example.demo.service.AuthService;
import com.example.demo.service.KardemirService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/kardemirs")
@AllArgsConstructor
@Slf4j
public class KardemirController {
	
	private final KardemirService kardemirService;
	private final AuthService authService;
	
	@PostMapping
	public ResponseEntity<KardemirDto> createKardemir(@RequestBody KardemirDto kardemirDto) {
		log.info("New kardemir created by " + authService.getCurrentLoggedInUsername());
		return ResponseEntity.status(HttpStatus.CREATED).body(kardemirService.save(kardemirDto));
	}
	
	@GetMapping
	public ResponseEntity<List<KardemirDto>> getAllKardemirs() {
		log.info("Kardemir list viewed");
		return ResponseEntity.status(HttpStatus.OK).body(kardemirService.getAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<KardemirDto> getKardemir(@PathVariable Long id){
		log.info("Kardemir with id:"+ id +" viewed");
		return ResponseEntity.status(HttpStatus.OK).body(kardemirService.getKardemir(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<KardemirDto> updateKardemir(@RequestBody KardemirDto kardemirDto, @PathVariable Long id){
		log.info("Kardemir with id:"+ id +" updated by " + authService.getCurrentLoggedInUsername());
		return ResponseEntity.status(HttpStatus.OK).body(kardemirService.updateKardemir(kardemirDto,id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteKardemir(@PathVariable Long id){
		log.info("Kardemir with id:"+ id +" updated by " + authService.getCurrentLoggedInUsername());
		return ResponseEntity.status(HttpStatus.OK).body(kardemirService.deleteKardemir(id));
	}
	
}
