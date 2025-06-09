package com.example.chapapp.messageroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRoomRepository extends JpaRepository<MessageRoom, UUID> {
}
