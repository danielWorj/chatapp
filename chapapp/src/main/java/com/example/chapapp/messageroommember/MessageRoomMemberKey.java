package com.example.chapapp.messageroommember;

import com.example.chapapp.messageroom.MessageRoom;
import com.example.chapapp.user.User;

import java.io.Serializable;

public class MessageRoomMemberKey implements Serializable {
    private User user;
    private MessageRoom messageRoom;
}
