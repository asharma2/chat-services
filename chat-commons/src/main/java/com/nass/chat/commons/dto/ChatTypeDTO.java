package com.nass.chat.commons.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChatTypeDTO implements DTO {

	Long id;
	String type;
	Boolean active;
	LocalDate createdAt;
	LocalDate modifiedAt;
}
