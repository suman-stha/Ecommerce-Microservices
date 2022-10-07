package com.customerservice.service;

import com.customerservice.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface  UserService {

    List<UserDto> findAll();
    UserDto findById(final Integer userId);
    UserDto save(final UserDto userDto);
    UserDto update(final UserDto userDto);
    UserDto update(final Integer userId,final UserDto userDto);
    void deleteById(final Integer userId);
    UserDto findByUsername(final String username);
}
