package com.userfront.domain.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    private String name;

    @OneToMany(mappedBy = "role", orphanRemoval = true,
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
