package com.example.chapapp.messageroommember;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.user.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageRoomMemberDTO {
    private UUID messageRoom;
    private String username;

    private Boolean isAdmin ;

    private LocalDateTime lastSeen ;
    private LocalDateTime lastLogin  ;

}
