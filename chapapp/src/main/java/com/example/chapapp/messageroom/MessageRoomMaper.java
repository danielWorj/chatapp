package com.example.chapapp.messageroom;

import com.example.chapapp.messagecontent.MessageContent;
import com.example.chapapp.messagecontent.MessageContentDTO;
import com.example.chapapp.user.User;
import com.example.chapapp.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageRoomMaper {


    private final UserRepository userRepository;

    public MessageRoomDTO toDTO(final MessageRoom messageRoom, final  MessageRoomDTO messageRoomDTO){

        messageRoomDTO.setId(messageRoom.getId());
        messageRoomDTO.setName(messageRoom.getName());
        messageRoomDTO.setIsGroup(messageRoom.getIsGroup());
        messageRoomDTO.setCreatedDate(messageRoom.getCreatedDate());
        messageRoomDTO.setCreatedBy(messageRoom.getCreatedBy().getUsername());

        return messageRoomDTO;
    }

    public MessageRoom toEntity(final MessageRoom messageRoom, final MessageRoomDTO messageRoomDTO){

       messageRoom.setId(messageRoomDTO.getId());
       messageRoom.setName(messageRoomDTO.getName());
       messageRoom.setIsGroup(messageRoomDTO.getIsGroup());
       messageRoom.setCreatedDate(messageRoomDTO.getCreatedDate());

        final User user = messageRoomDTO.getCreatedBy() == null ? null : userRepository.findById(messageRoom.getCreatedBy().getUsername())
                .orElseThrow(()-> new EntityNotFoundException("User Not Found"));

        return messageRoom;
    }

}
