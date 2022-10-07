package com.customerservice.controller;

import com.customerservice.dto.UserDto;
import com.customerservice.dto.response.collection.DtoCollectionResponse;
import com.customerservice.entities.User;
import com.customerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<DtoCollectionResponse<UserDto>> findAll() {
        log.info("UserDto List,controller; fetch all users*");
        return ResponseEntity.ok(new DtoCollectionResponse<>(userService.findAll()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(
            @PathVariable("userId") @NotBlank(message = "Input must not blank") @Valid final String userId) {
        log.info("UsetDto,controller;fetch user by id*");
        return ResponseEntity.ok(this.userService.findById(Integer.parseInt(userId.strip())));

    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody @NotNull(message = "Input must not null") @Valid UserDto userDto) {
        log.info("UserDto,controller; save user*");
        UserDto userDto1 = this.userService.save(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(
            @RequestBody @NotNull(message = "Input must not NULL") @Valid final UserDto userDto) {

        log.info("UserDto, controller; update user*");
        return ResponseEntity.ok(this.userService.update(userDto));
    }

    //update mapping with userId
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(
            @PathVariable("userId")
            @NotBlank(message = "Input must not blank") final String userId,
            @RequestBody
            @NotNull(message = "Input must not Null")
            @Valid final UserDto userDto
    ){
        log.info("UserDto,controller; update user with userId");
        return ResponseEntity.ok(this.userService.update(Integer.parseInt(userId.strip()),userDto));
    }

    //Delete mapping
    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteById
   ( @PathVariable("userId")
     @NotBlank(message = "Input must not blank")
     @Valid final String userId){
        log.info("Boolean,controller;delete user byid");
        this.userService.deleteById(Integer.parseInt(userId));
        return ResponseEntity.ok(true);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(
            @PathVariable("username")
            @NotBlank(message = "Input must not blank")
            @Valid final String username){
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }
}






