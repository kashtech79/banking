package com.userfront.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User Implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String phone;

    private boolean enabled=true;

    private PrimaryAccount primaryAccount;

    private SavingsAccount savingsAccount;

    @JsonIgnore
    private List<Appointment> appointmentList;

    private List<Recipient> recipientList;

    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();
}
