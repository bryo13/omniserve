package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.UserNotFoundException;
import com.group3.omniserve.model.User;
import com.group3.omniserve.dto.ChangePasswordRequest;
import com.group3.omniserve.dto.UserUpdateRequest;
import com.group3.omniserve.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
 //private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Check if a username exists
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    // Check if an email exists
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Create a new user
    public User createUser(User user) {
       
        return userRepository.save(user);
    }
    
     public void changePassword(Long userId, ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Current password is incorrect");
        }

        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
            throw new RuntimeException("New password and confirm password do not match");
        }

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);
    }
     
    
       public User updateUser(Long userId, UserUpdateRequest updateRequest) {
        // Find the user by ID
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user information
        user.setFirst_name(updateRequest.getFirst_name());
        user.setSurname(updateRequest.getSurname());
        user.setOther_name(updateRequest.getOther_name());
        user.setCountryID(updateRequest.getCountryID());
        user.setCountyID(updateRequest.getCountyID());
        user.setCityID(updateRequest.getCityID());
        user.setLocation(updateRequest.getLocation());
        user.setAddress(updateRequest.getAddress());
        user.setZipCode(updateRequest.getZipCode());
       
        user.setNationalID(updateRequest.getNationalID());

        // Save the updated user
        return userRepository.save(user);
    }

  public List<User> getAllUsers() {
        return userRepository.findAll();
    }
  
    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }
}
/*

     // Validate the uploaded file as an image
    public void validateImageFile(MultipartFile file) {
       // try {
            // Validate file type
     //       String detectedType = tika.detect(file.getInputStream());
        //    if (!detectedType.startsWith("image/")) {
        //        throw new InvalidFileException("Uploaded file is not an image.");
         //   }

            // Validate file size (e.g., limit to 10MB)
            //if (file.getSize() > 10 * 1024 * 1024) {
           //     throw new FileSizeExceededException("Image file size should not exceed 10MB.");
          //  }
       // } catch (IOException e) {
       //     throw new InvalidFileException("Failed to validate the file.");
       // }
    }

    // Validate the uploaded file as an image or PDF
    public void validateImageOrPdfFile(MultipartFile file) {
      //  try {
            // Validate file type
        //    String detectedType = tika.detect(file.getInputStream);
        //    if (!detectedType.startsWith("image/") && !detectedType.equals("application/pdf")) {
       //         throw new InvalidFileException("Uploaded file is not an image or PDF.");
       //     }
//
            // Validate file size (e.g., limit to 10MB)
        //    if (file.getSize() > 10 * 1024 * 1024) {
         //       throw new FileSizeExceededException("File size should not exceed 10MB.");
       //     }
     //   } catch (IOException e) {
     //       throw new InvalidFileException("Failed to validate the file.");
     //   }
    }
*/

