package com.example.chapapp.messagecontent;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.messageroom.MessageRoomRepository;
import com.example.chapapp.user.User;
import com.example.chapapp.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageContentMapper {
    @Autowired
    private MessageRoomRepository messageRoomRepository;
    @Autowired
    private UserRepository userRepository;

    public MessageContentDTO toDTO(final MessageContent messageContent, final  MessageContentDTO messageContentDTO){

        messageContentDTO.setId(messageContent.getId());
        messageContentDTO.setContent(messageContent.getContent());
        messageContentDTO.setDateSent(messageContent.getDateSent());
        messageContentDTO.setMessageType(messageContent.getMessageType());
        messageContentDTO.setMessageRooms(messageContent.getMessageRooms().getId());
        messageContentDTO.setSender(messageContent.getUser().getUsername());

        return messageContentDTO;
    }

    public MessageContent toEntity(final MessageContentDTO messageContentDTO, final MessageContent messageContent){

        messageContent.setId(messageContentDTO.getId());
        messageContent.setContent(messageContentDTO.getContent());
        messageContent.setDateSent(messageContentDTO.getDateSent());
        messageContent.setMessageType(messageContentDTO.getMessageType());
        final MessageRoom messageRoom = messageContentDTO.getMessageRooms() == null ? null : messageRoomRepository.findById(messageContentDTO.getMessageRooms()).orElseThrow(()->new EntityNotFoundException("Message Room not found"));

        messageContent.setMessageRooms(messageRoom);

        final User user = messageContentDTO.getSender() == null ? null : userRepository.findById(messageContentDTO.getSender())
                .orElseThrow(()-> new EntityNotFoundException("User Not Found"));

        return messageContent;
    }

}
