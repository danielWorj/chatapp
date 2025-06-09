package com.example.chapapp.messageroom;

import com.example.chapapp.messagecontent.MessageContent;
import com.example.chapapp.messageroommember.MessageRoomMember;
import com.example.chapapp.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class MessageRoomDTO {
    private UUID id ;

    private String name ;

    private Boolean isGroup ;

    private LocalDateTime createdDate ;

    private String createdBy;


}
