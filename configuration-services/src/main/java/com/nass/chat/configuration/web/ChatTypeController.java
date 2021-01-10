package com.nass.chat.configuration.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nass.chat.commons.dto.ChatTypeDTO;
import com.nass.chat.configuration.mapper.ChatTypeMapper;
import com.nass.chat.configuration.service.ChatTypeService;

@RestController
@RequestMapping("/api/v1/chat-type")
public class ChatTypeController {

	@Autowired
	ChatTypeService chatTypeService;

	@Autowired
	ChatTypeMapper chatTypeMapper;

	@GetMapping
	public List<ChatTypeDTO> getChatTypes() {
		return chatTypeMapper.mapDomainToDTO(chatTypeService.getChatTypes());
	}
}
