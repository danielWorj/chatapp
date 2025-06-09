package com.example.chapapp.messageroommember;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@IdClass(MessageRoomMemberKey.class)
public class MessageRoomMember {

    @Id
    @ManyToOne
    @JoinColumn
    private MessageRoom messageRoom;

    @Id
    @ManyToOne
    private User user;

    private Boolean isAdmin ;

    private LocalDateTime lastSeen ;
    private LocalDateTime lastLogin ;

}
