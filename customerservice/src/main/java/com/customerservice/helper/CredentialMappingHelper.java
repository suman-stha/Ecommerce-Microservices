package com.customerservice.helper;

import com.customerservice.dto.CredentialDto;
import com.customerservice.dto.UserDto;
import com.customerservice.entities.Credential;
import com.customerservice.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CredentialMappingHelper {
    @Autowired
    private static ModelMapper modelMapper;
    //convert credential to credentialDto
    public static CredentialDto map(final Credential credential) {

        return modelMapper.map(credential, CredentialDto.class);
    }

    //convert crdentialDto to credential
    public static Credential map(final CredentialDto credentialDto) {

        return modelMapper.map(credentialDto, Credential.class);
    }

}
