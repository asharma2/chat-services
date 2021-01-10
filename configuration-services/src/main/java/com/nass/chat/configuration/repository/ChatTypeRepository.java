package com.nass.chat.configuration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nass.chat.configuration.model.ChatType;

public interface ChatTypeRepository extends JpaRepository<ChatType, Long> {

}
