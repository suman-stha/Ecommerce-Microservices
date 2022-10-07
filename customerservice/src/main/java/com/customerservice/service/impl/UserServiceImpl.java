package com.customerservice.service.impl;

import com.customerservice.dto.UserDto;
import com.customerservice.entities.User;
import com.customerservice.exception.wrapper.UserObjectNotFoundException;
import com.customerservice.helper.UserMappingHelper;
import com.customerservice.repository.UserRepository;
import com.customerservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl  implements UserService {


    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        log.info("*** UserDto List,service; fetch all users***");
      return  userRepository.findAll().stream().map(UserMappingHelper::map).distinct().collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer userId) {
        log.info("UserDto,Service:fetch user by id");
        return  userRepository.findById(userId).map(UserMappingHelper::map).orElseThrow(()->new UserObjectNotFoundException(String.format("User with id: %d not found",userId)));
    }

    @Override
    public UserDto save(UserDto userDto) {
        log.info("UserDto,Service:save user");
        User saveUser = userRepository.save(UserMappingHelper.map(userDto));
        return UserMappingHelper.map(saveUser);

    }

    @Override
    public UserDto update(UserDto userDto)

    {
       log.info("UserDto,service; update user");
        User updatedUser = userRepository.save(UserMappingHelper.map(userDto));
        return UserMappingHelper.map(updatedUser);
    }

    @Override
    public UserDto update(Integer userId, UserDto userDto) {
      log.info("UserDto,service:update user with userId");
        User updatedUser1 = userRepository.save(UserMappingHelper.map(findById(userId)));
        return UserMappingHelper.map(updatedUser1);
    }

    @Override
    public void deleteById(Integer userId) {
log.info("Void,service; delete user by id *");
this.userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByUsername(String username) {
       log.info("USerDto,service;fetch user with username");
       return UserMappingHelper.map(this.userRepository.findByCredentialUsername(username)
               .orElseThrow(()->new UserObjectNotFoundException(String.format("User with username: %s not found"))));
    }
}
