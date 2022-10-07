package com.customerservice.service;

import com.customerservice.dto.CredentialDto;
import com.customerservice.entities.Credential;

import java.util.List;

public interface CredentialService {
    List<CredentialDto> findAll();
    CredentialDto findById(final Integer credentialId);
    CredentialDto save(final CredentialDto credentialDto);
    CredentialDto update(final CredentialDto credentialDto);
    CredentialDto update(final Integer credentialId,final CredentialDto credentialDto);
    void deleteById(final Integer credentialId);
    CredentialDto findByUsername(final String username);


}