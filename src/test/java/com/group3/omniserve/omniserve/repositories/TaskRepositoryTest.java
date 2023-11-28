package com.group3.omniserve.omniserve.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.group3.omniserve.omniserve.models.Tasks;
import com.group3.omniserve.omniserve.models.User;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TaskRepositoryTest {
    
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void TaskRepository_GetTask_SavesAUserWithTasks() {

        // Create a user first to whom the tasks belong to
        User user = User.builder()
            .firstName("brian")
            .lastName("Tum")
            .email("brian@t.com")
            .isAdmin(false)
        .build();

        Tasks task = Tasks.builder()
            .title("Spring boot application")
            .description("Class group project")
            .additionalFiles("link to cloud blob storage")
            .amount(30)
            .user(user)
            .durationInDays(8)
        .build();

        userRepository.save(user);
        tasksRepository.save(task);

        User savedUser = userRepository.findById(user.getID()).orElseThrow();

        assertEquals("brian@t.com", savedUser.getEmail());
        assertEquals(user, task.getUser());
    }
   
}
