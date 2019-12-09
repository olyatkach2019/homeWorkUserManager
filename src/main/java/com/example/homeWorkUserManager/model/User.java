package com.example.homeWorkUserManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_USER")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ElementCollection(targetClass = Privileges.class)
    @CollectionTable(name = "user_privilege", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "PRIVILEGE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Privileges> privileges;

    public User() {
    }

    public User(String username, String password) {
        this(username, password, Role.ROLE_USER);
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public Set<Privileges> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privileges> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", privileges=" + privileges +
                '}';
    }
}
