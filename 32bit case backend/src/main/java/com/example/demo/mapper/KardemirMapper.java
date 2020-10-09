package com.example.demo.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.KardemirDto;
import com.example.demo.model.Kardemir;

@Mapper(componentModel = "spring")
public interface KardemirMapper {
	
	
	@Mapping(target = "active" ,ignore = false)
	KardemirDto mapKardemirToDto(Kardemir kardemir);
	
	@InheritInverseConfiguration
	@Mapping(target = "createdDate" , ignore = true )
	@Mapping(target = "createdUser" ,ignore = true)
	@Mapping(target = "updatedDate" ,ignore = true)
	@Mapping(target = "updatedUser" ,ignore = true)
	Kardemir mapDtoToKardemir(KardemirDto kardemirDto);
	
}
