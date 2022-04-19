package com.stefanovich.enovation.service;

import com.stefanovich.enovation.dto.MessageDto;
import com.stefanovich.enovation.model.Message;
import com.stefanovich.enovation.model.User;
import com.stefanovich.enovation.repository.MessageRepository;
import com.stefanovich.enovation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public void saveMessage(MessageDto messageDto) {
        LocalDate localDate = LocalDate.now();
        User userSender = userRepository.findById(messageDto.getUserSenderId()).orElseThrow(()
                -> new EntityNotFoundException("Not found message with id - " + messageDto.getUserSenderId()));
        User userAddressee = userRepository.findById(messageDto.getUserAddresseeId()).orElseThrow(()
                -> new EntityNotFoundException("Not found message with id - " + messageDto.getUserAddresseeId()));

        Message message = new Message();
        message.setCreatedOn(localDate);
        message.setContent(messageDto.getContent());
        message.setUserSender(userSender);
        message.setUserAddressee(userAddressee);
        messageRepository.save(message);
    }
}
