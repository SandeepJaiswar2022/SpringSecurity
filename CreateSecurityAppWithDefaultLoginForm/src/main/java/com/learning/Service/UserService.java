package com.learning.Service;

import com.learning.Model.User;
import com.learning.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;
    private BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder(12);

    public User save(User user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
