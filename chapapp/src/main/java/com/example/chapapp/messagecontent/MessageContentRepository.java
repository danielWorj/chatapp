package com.example.chapapp.messagecontent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageContentRepository extends JpaRepository<MessageContent, UUID> {
}
