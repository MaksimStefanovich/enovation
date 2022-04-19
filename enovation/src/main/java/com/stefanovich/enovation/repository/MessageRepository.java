package com.stefanovich.enovation.repository;

import com.stefanovich.enovation.model.Message;
import com.stefanovich.enovation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserSender(User userSender);

    List<Message> findByUserAddressee(User Addressee);

}
