package com.example.chapapp.messagecontent;


import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class MessageContent {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id ;

    private String content;

    @CreatedDate
    private LocalDateTime dateSent ;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @ManyToOne
    private MessageRoom messageRooms;

    @ManyToOne
    private User user;

}
