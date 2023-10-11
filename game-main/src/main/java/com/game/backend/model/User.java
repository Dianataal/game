package com.game.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data  // Lombok annotation for getters, setters, toString, etc.
@NoArgsConstructor  // Lombok annotation for no-arg constructor
@AllArgsConstructor  // Lombok annotation for all-args constructor
public class User {

    @Id
    private Long id;

    private String username;
    private String password;

}
