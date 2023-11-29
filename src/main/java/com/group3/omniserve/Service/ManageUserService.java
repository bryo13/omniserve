package com.group3.omniserve.Service;
import com.group3.omniserve.model.User;
import com.group3.omniserve.dto.UsersUpdateRequest;
import com.group3.omniserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManageUserService {

    private final UserRepository userRepository;

    @Autowired
    public ManageUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public List<User> getAllUsersByRole(String roleName) {
        return userRepository.findByRolesContaining(roleName);
    }

    public Optional<User> viewUserByIdAndRole(Long userId, String roleName) {
        return userRepository.findByIdAndRolesContaining(userId, roleName);
    }

    public List<User> getAllAdmins() {
        return getAllUsersByRole("ADMIN");
    }

    public List<User> getAllClients() {
        return getAllUsersByRole("CLIENT");
    }

    public List<User> getAllProviders() {
        return getAllUsersByRole("PROVIDER");
    }


   public Optional<User> updateUser(Long userId, UsersUpdateRequest updatedUserData) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFirst_name(updatedUserData.getFirst_name());
            existingUser.setSurname(updatedUserData.getSurname());
            existingUser.setOther_name(updatedUserData.getOther_name());
            existingUser.setCountryID(updatedUserData.getCountryID());
            existingUser.setCountyID(updatedUserData.getCountyID());
            existingUser.setCityID(updatedUserData.getCityID());
            existingUser.setLocation(updatedUserData.getLocation());
            existingUser.setAddress(updatedUserData.getAddress());
            existingUser.setZipCode(updatedUserData.getZipCode());
            existingUser.setStatus(updatedUserData.getStatus());
            existingUser.setNationalID(updatedUserData.getNationalID());
            existingUser.setNational_ID_Doc_Upload(updatedUserData.getNational_ID_Doc_Upload());
            existingUser.setEmailVerified(updatedUserData.isEmailVerified());

           

            return Optional.of(userRepository.save(existingUser));
        }

        return Optional.empty(); // User with the given ID not found
    }
}
