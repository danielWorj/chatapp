package com.example.chapapp.messageroom;

import com.example.chapapp.messagecontent.MessageContent;
import com.example.chapapp.messageroommember.MessageRoomMember;
import com.example.chapapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MessageRoom {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id ;

    private String name ;

    private Boolean isGroup ;

    @CreatedDate
    private LocalDateTime createdDate ;

    @ManyToOne
    private User createdBy;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MessageRoomMember> members;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MessageContent> messageContents;

}
