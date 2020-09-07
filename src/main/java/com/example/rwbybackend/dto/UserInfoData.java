package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfoData {

	private final String data;
	private final String employeeNumber;
	private final String lastname;
	private final String name;
	private final String patronym;
	private final String position;


}
