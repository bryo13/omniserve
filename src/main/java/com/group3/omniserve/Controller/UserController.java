package com.group3.omniserve.Controller;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import com.group3.omniserve.Service.UserService;
import com.group3.omniserve.dto.RegistrationRequest;
import com.group3.omniserve.model.User;
import com.group3.omniserve.dto.ChangePasswordRequest;
import com.group3.omniserve.dto.UserUpdateRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.group3.omniserve.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        // Check if the username or email is already taken
        if (userService.existsByUsername(registrationRequest.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(registrationRequest.getEmail())) {
            return new ResponseEntity<>("Email Address is already in use!", HttpStatus.BAD_REQUEST);
        }

        // Create a new user with emailVerified and phoneNumberVerified set to false initially
        User user = new User();
        user.setFirst_name(registrationRequest.getFirst_name());
        user.setSurname(registrationRequest.getSurname());
        user.setOther_name(registrationRequest.getOther_name());
        user.setCountryID(registrationRequest.getCountryID());
        user.setCountyID(registrationRequest.getCountyID());
        user.setCityID(registrationRequest.getCityID());
        user.setLocation(registrationRequest.getLocation());
        user.setAddress(registrationRequest.getAddress());
        user.setZipCode(registrationRequest.getZipCode());
        user.setStatus(registrationRequest.getStatus());
        user.setNationalID(registrationRequest.getNationalID());
        user.setNational_ID_Doc_Upload(registrationRequest.getNational_ID_Doc_Upload());
        user.setEmailVerified(false); // Set emailVerified to false initially
        user.setPhoneNumberVerified(false); // Set phoneNumberVerified to false initially
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        // Delegate registration logic to UserService (createUser method)
        userService.createUser(user);

        return ResponseEntity.ok("User registered successfully");
    }
    
  
   @PostMapping("/change-password/{userId}")
    public ResponseEntity<String> changePassword(@PathVariable Long userId, @RequestBody ChangePasswordRequest changePasswordRequest) {
        try {
            userService.changePassword(userId, changePasswordRequest);
            return ResponseEntity.ok("Password changed successfully");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
     @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody @Valid UserUpdateRequest updateRequest) {
        User updatedUser = userService.updateUser(userId, updateRequest);
        return ResponseEntity.ok(updatedUser);
    }

    
     @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
