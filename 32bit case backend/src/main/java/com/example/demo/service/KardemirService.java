package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.KardemirDto;
import com.example.demo.exception.GenericException;
import com.example.demo.mapper.KardemirMapper;
import com.example.demo.model.Kardemir;
import com.example.demo.repository.KardemirRepository;

import lombok.AllArgsConstructor;

import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class KardemirService {

	
	private final KardemirRepository kardemirRepository;
	private final KardemirMapper kardemirMapper;
	private final AuthService authService;
	
	
	@Transactional
	public KardemirDto save(KardemirDto kardemirDto) {
		Kardemir save = kardemirRepository.save(kardemirMapper.mapDtoToKardemir(kardemirDto));
		save.setCreatedDate(java.time.Instant.now());
		save.setCreatedUser(authService.getCurrentLoggedInUsername());
		kardemirDto.setId(save.getId());
		return kardemirDto;
	}
	
	@Transactional(readOnly = true)
	public List<KardemirDto> getAll() {
		
		return kardemirRepository.findAll().stream().map(kardemirMapper::mapKardemirToDto).collect(toList());
	}

	@Transactional(readOnly = true)
	public KardemirDto getKardemir(Long id) {
		Kardemir kardemir = kardemirRepository.findById(id)
				.orElseThrow(() -> new GenericException("No kardemir found with id : " + id));
		return kardemirMapper.mapKardemirToDto(kardemir);
	}

	@Transactional
	public KardemirDto updateKardemir(KardemirDto kardemirDto, Long id) {
		Kardemir kardemirChecked = kardemirRepository.findById(id).orElseThrow(()-> new GenericException("No kardemir found with id : " + id));
		String createdUser= kardemirChecked.getCreatedUser();
		Instant createdDate = kardemirChecked.getCreatedDate();
		Kardemir kardemir = kardemirMapper.mapDtoToKardemir(kardemirDto);
		kardemir.setId(id);
		kardemir.setUpdatedDate(java.time.Instant.now());
		kardemir.setUpdatedUser(authService.getCurrentLoggedInUsername());
		kardemir.setCreatedDate(createdDate);
		kardemir.setCreatedUser(createdUser);
		kardemirRepository.save(kardemir);
		return kardemirMapper.mapKardemirToDto(kardemir);
	}

	@Transactional
	public Map<String, Boolean> deleteKardemir(Long id) {
		Kardemir kardemir = kardemirRepository.findById(id)
				.orElseThrow(() -> new GenericException("No kardemir found with id : " + id));
		kardemirRepository.delete(kardemir);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
}
