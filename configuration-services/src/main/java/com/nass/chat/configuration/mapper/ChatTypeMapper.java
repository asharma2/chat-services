package com.nass.chat.configuration.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nass.chat.commons.dto.ChatTypeDTO;
import com.nass.chat.configuration.model.ChatType;

@Mapper(componentModel = "spring")
public interface ChatTypeMapper {

	@Mapping(target = "modifiedAt", source = "updatedAt")
	ChatTypeDTO mapDomainToDTO(ChatType chatType);

	default List<ChatTypeDTO> mapDomainToDTO(Collection<ChatType> chatTypes) {
		return chatTypes.stream().map(ct -> mapDomainToDTO(ct)).collect(Collectors.toList());
	}
}
