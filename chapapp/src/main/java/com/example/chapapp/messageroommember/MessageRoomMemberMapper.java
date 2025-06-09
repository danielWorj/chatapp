package com.example.chapapp.messageroommember;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.messageroom.MessageRoomDTO;
import com.example.chapapp.messageroom.MessageRoomRepository;
import com.example.chapapp.user.User;
import com.example.chapapp.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MessageRoomMemberMapper {


    private final UserRepository userRepository;
    private final MessageRoomRepository messageRoomRepository;

    public MessageRoomMemberDTO toDTO(final MessageRoomMember messageRoomMember, final  MessageRoomMemberDTO messageRoomMemberDTO){
        messageRoomMemberDTO.setMessageRoom(messageRoomMember.getMessageRoom().getId());
        messageRoomMemberDTO.setUsername(messageRoomMember.getUser().getUsername());
        messageRoomMemberDTO.setIsAdmin(messageRoomMember.getIsAdmin());
        messageRoomMemberDTO.setLastSeen(messageRoomMember.getLastSeen());
        messageRoomMemberDTO.setLastLogin(messageRoomMember.getLastLogin());

        return messageRoomMemberDTO;
    }

    public MessageRoomMember toEntity(final MessageRoomMember messageRoomMember, final MessageRoomMemberDTO messageRoomMemberDTO){
        final MessageRoom messageRoom =  messageRoomMemberDTO.getMessageRoom() == null ? null : messageRoomRepository.findById(messageRoomMemberDTO.getMessageRoom())
                .orElseThrow(()->new EntityNotFoundException("MessageRoom not found"));

        messageRoomMember.setMessageRoom(messageRoom);

        final  User createdBy = messageRoomMemberDTO.getUsername() == null ? null : userRepository.findById(messageRoomMemberDTO.getUsername())
                .orElseThrow(()-> new EntityNotFoundException("User not found"));

        messageRoomMember.setUser(createdBy);

        messageRoomMember.setIsAdmin(messageRoomMemberDTO.getIsAdmin());
        messageRoomMember.setLastSeen(messageRoomMemberDTO.getLastSeen());

        return messageRoomMember;
    }
}
