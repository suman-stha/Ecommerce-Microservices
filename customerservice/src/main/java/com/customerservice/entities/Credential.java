package com.customerservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Credentials")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true,exclude = {"user","verificationTokens"})
@Data
@Builder
public class Credential extends AbstractMappedEntity implements Serializable {
    private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="credential_id",unique = true,nullable = false,updatable = false)
    private Integer credentialId;

@Column(unique = true)
    private String username;


    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private RoleBasedAuthority roleBasedAuthority;

@Column(name="is_Enabled")
    private Boolean isEnabled;

@Column(name="is_account_non_expired")
    private Boolean isAccountNonExpired;

@Column(name="is_account_non_locked")
    private Boolean isAccountNonLocked;

@Column(name="is_credential_non_expired")
    private Boolean isCredentialsNonExpired;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_ID",nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "credential")
    private Set<VerificationToken> verificationTokens;

}
