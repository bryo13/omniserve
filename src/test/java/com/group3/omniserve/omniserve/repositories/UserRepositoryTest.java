package com.group3.omniserve.omniserve.repositories;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.group3.omniserve.omniserve.models.User;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_SaveUser_SavesAUser() {
        // Arrange
        User user = User.builder()
            .firstName("brian")
            .lastName("Tum")
            .email("brian@t.com")
            .isAdmin(false)
            .build();

        // Act
        User saveUser = userRepository.save(user);

        // Assert
        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getEmail()).isNotEmpty();
    }

    @Test
    public void UserRepository_FindUser_ReturnsAllUsers() {
        // Arrange
        User user = User.builder()
            .firstName("brian")
            .lastName("Tum")
            .email("brian@t.com")
            .isAdmin(false)
        .build();

        // Act
       userRepository.save(user);

        List<User> userList = userRepository.findAll();

        // Assert
        Assertions.assertThat(userList).isNotEmpty();
        Assertions.assertThat(userList.size()).isEqualTo(1);
    
    }

    @Test
    public void UserRepository_FindUserById_ReturnsUserWithID() {
        // Arrange
        User user = User.builder()
            .firstName("brian")
            .lastName("Tum")
            .email("brian@t.com")
            .isAdmin(false)
        .build();

        // Act
       userRepository.save(user);

        User userList = userRepository.findById(user.getID()).get();

        // Assert
        Assertions.assertThat(userList).isNotNull();
        
    }
}
