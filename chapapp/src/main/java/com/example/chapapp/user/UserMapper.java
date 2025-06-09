package com.example.chapapp.user;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.messageroom.MessageRoomRepository;
import com.example.chapapp.messageroommember.MessageRoomMember;
import com.example.chapapp.messageroommember.MessageRoomMemberDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {



    private final UserRepository userRepository;
    private final MessageRoomRepository messageRoomRepository;

    public UserDTO toDTO(final User user, final UserDTO userDTO ){

        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
        userDTO.setAvatarUrl(user.getAvatarUrl());

        return userDTO;
    }

    public User toEntity(final UserDTO userDTO , final User user){

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        user.setAvatarUrl(userDTO.getAvatarUrl());
        return user;
    }
}
