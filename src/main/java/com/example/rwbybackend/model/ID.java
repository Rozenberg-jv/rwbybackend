package com.example.rwbybackend.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class ID {

	@Id
	@GeneratedValue()
	@Column(name = "id", columnDefinition = "BIGINT")
	@Access(AccessType.PROPERTY)
	private Long id;
}
