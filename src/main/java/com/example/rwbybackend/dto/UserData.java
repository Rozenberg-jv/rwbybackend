package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {

	private long id;

	private String username;

}
