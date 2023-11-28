package com.group3.omniserve.omniserve.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.group3.omniserve.omniserve.models.User;
import com.group3.omniserve.omniserve.repositories.UserRepository;
import com.group3.omniserve.omniserve.services.UsersService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
 
    @Mock
    private UserRepository uRepository;

    @InjectMocks
    private UsersService usersService;

    @Test
    public void UserService_GetUserById_ReturnsAUser(){
        Long userId = 1L;

        // Arrange
         User user = User.builder()
            .firstName("brian")
            .lastName("Tum")
            .email("brian@t.com")
            .isAdmin(false)
            .build();

            when(uRepository.findById(userId)).thenReturn(Optional.of(user));

            // Act
            ResponseEntity<User> rEntity = usersService.getUserById(userId);

            // Assert
            verify(uRepository, times(1)).findById(userId);
            assertEquals(HttpStatus.OK, rEntity.getStatusCode());
            assertNotNull(rEntity.getBody());
            assertEquals("brian@t.com", rEntity.getBody().getEmail());
        }
}
