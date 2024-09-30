package com.barbearia_ibertioga.barbearia_api.Service;

import com.barbearia_ibertioga.barbearia_api.DTO.UserDto;
import com.barbearia_ibertioga.barbearia_api.domain.User;
import com.barbearia_ibertioga.barbearia_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto data) {
        User newUser = new User(data);
        newUser.setPassword(passwordEncoder.encode(data.password()));
        userRepository.save(newUser);
        return convertToUserDto(newUser);
    }

public  UserDto convertToUserDto (User user) {
        UserDto dto = new UserDto(user.getName(), user.getEmail(),user.getPhoneNumber(), user.getBirthDate(), user.getPassword());
        return dto;
}
}
