package com.example.MoM;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.dto.formDto.MemberFormDto;
import com.example.MoM.entity.OrganizationMemberEntity;

@SpringBootApplication
public class MinutesOfMeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinutesOfMeetingApplication.class, args);
	}	
	
	@Bean
	public ModelMapper createModelMapper() {
		ModelMapper mapper = new ModelMapper();

		mapper.addMappings(new PropertyMap<OrganizationMemberEntity, OrganizationMemberCrudDto>() {

			@Override
			protected void configure() {
				map().setOrganizationName(source.getOrganizationEntity().getOrganizationName());
			}
		});
		
		mapper.addMappings(new PropertyMap<MemberFormDto, OrganizationMemberEntity>() {

			@Override
			protected void configure() {
				map().setOrganizationRole(source.getRole());
			}
		});

		return mapper;
	}

}
