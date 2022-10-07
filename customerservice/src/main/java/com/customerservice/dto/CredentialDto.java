package com.customerservice.dto;

import com.customerservice.entities.RoleBasedAuthority;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CredentialDto {
    private static final long serialVersionUID=1L;

    private Integer credentialId;
    private String username;
    private String password;
    private RoleBasedAuthority roleBasedAuthority;
    private Boolean isEnabled;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private UserDto userDto;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Set<VerificaionTokenDto> verificaionTokenDtos;
}
