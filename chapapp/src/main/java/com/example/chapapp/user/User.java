package com.example.chapapp.user;


import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.messageroommember.MessageRoomMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String username ;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status ;


    private LocalDateTime lastLogin = LocalDateTime.now();

    private String avatarUrl ;

    @OneToMany
    private List<MessageRoom> messageRooms;

    @OneToMany
    private List<MessageRoomMember> messageRoomMembers;


}
