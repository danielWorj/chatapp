package com.example.chapapp.messagecontent;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.user.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageContentDTO {

    private UUID id ;

    private String content;

    private LocalDateTime dateSent ;

    private MessageType messageType;

    private MessageRoom messageRooms;

    private String sender;
}
