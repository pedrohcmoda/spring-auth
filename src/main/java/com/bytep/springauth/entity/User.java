package com.bytep.springauth.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Nullable
    @Column(name = "creationDate")
    private Date creationDate;
    @Nullable
    @Column(name = "updateDate")
    private Date updateDate;

    public User(UUID id, String name, String email, String password, Date creationDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(creationDate, user.creationDate) && Objects.equals(updateDate, user.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, creationDate, updateDate);
    }
}
