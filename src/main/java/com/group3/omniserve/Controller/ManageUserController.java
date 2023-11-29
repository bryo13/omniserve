package com.group3.omniserve.Controller;

import com.group3.omniserve.Service.ManageUserService;
import com.group3.omniserve.model.User;
import com.group3.omniserve.dto.UsersUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class ManageUserController {

   private final ManageUserService manageUserService;

    @Autowired
    public ManageUserController(ManageUserService manageUserService) {
        this.manageUserService = manageUserService;
    }

    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = manageUserService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<User>> getAllClients() {
        List<User> clients = manageUserService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/providers")
    public ResponseEntity<List<User>> getAllProviders() {
        List<User> providers = manageUserService.getAllProviders();
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/{userId}/{role}")
    public ResponseEntity<User> viewUserByIdAndRole(@PathVariable Long userId, @PathVariable String role) {
        Optional<User> user = manageUserService.viewUserByIdAndRole(userId, role);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UsersUpdateRequest updatedUserData) {
        Optional<User> updatedUser = manageUserService.updateUser(userId, updatedUserData);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
