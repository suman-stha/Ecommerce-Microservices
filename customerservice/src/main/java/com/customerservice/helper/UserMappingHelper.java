package com.customerservice.helper;

import com.customerservice.dto.CredentialDto;
import com.customerservice.dto.UserDto;
import com.customerservice.entities.Credential;
import com.customerservice.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class  UserMappingHelper {
    @Autowired
    private static ModelMapper modelMapper;
    //convert User to userDto
    public static UserDto map(final User user) {

        return modelMapper.map(user, UserDto.class);
//        return UserDto.builder()
//                .userId(user.getUserId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .imageUrl(user.getImageUrl())
//                .email(user.getEmail())
//                .phone(user.getPhone())
//                .credentialDto(
//                        CredentialDto.builder()
//                                .credentialId(user.getCredential().getCredentialId())
//                                .username(user.getCredential().getUsername())
//                                .password(user.getCredential().getPassword())
//                                .roleBasedAuthority(user.getCredential().getRoleBasedAuthority())
//                                .isEnabled(user.getCredential().getIsEnabled())
//
//                                .isAccountNonExpired(user.getCredential().getIsAccountNonExpired())
//                                .isAccountNonLocked(user.getCredential().getIsAccountNonLocked())
//                                .isCredentialsNonExpired(user.getCredential().getIsCredentialsNonExpired())
//                                .build())
//                .build();
    }

    //Convert UserDto to User
    public static User map(final UserDto userDto) {

        return modelMapper.map(userDto,User.class);
//        return User.builder()
//                .userId(userDto.getUserId())
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
//                .imageUrl(userDto.getImageUrl())
//                .email(userDto.getEmail())
//                .phone(userDto.getPhone())
//                .credential(
//                        Credential.builder()
//                                .credentialId(userDto.getCredentialDto().getCredentialId())
//                                .username(userDto.getCredentialDto().getUsername())
//                                .password(userDto.getCredentialDto().getPassword())
//                                .roleBasedAuthority(userDto.getCredentialDto().getRoleBasedAuthority())
//                                .isEnabled(userDto.getCredentialDto().getIsEnabled())
//                                .isAccountNonExpired(userDto.getCredentialDto().getIsAccountNonExpired())
//                                .isAccountNonLocked(userDto.getCredentialDto().getIsAccountNonLocked())
//                                .isCredentialsNonExpired(userDto.getCredentialDto().getIsCredentialsNonExpired())
//                                .build())
//                .build();
    }

}
