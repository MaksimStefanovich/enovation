package com.stefanovich.enovation.service;

import com.stefanovich.enovation.exception.UserNotFoundException;
import com.stefanovich.enovation.model.Message;
import com.stefanovich.enovation.model.User;
import com.stefanovich.enovation.repository.MessageRepository;
import com.stefanovich.enovation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new UserNotFoundException("Not found user with id - " + userId));

        List<Message> byUserSender = messageRepository.findByUserSender(user);
        for (Message message : byUserSender) {
            message.setUserSender(null);
        }

        List<Message> byUserAddressee = messageRepository.findByUserAddressee(user);
        for (Message message : byUserAddressee) {
            message.setUserAddressee(null);
        }
        userRepository.deleteById(userId);
    }
}
