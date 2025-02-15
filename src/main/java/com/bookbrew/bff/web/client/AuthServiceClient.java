package com.bookbrew.bff.web.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.config.FeignConfig;
import com.bookbrew.bff.web.dto.auth.ForgotPasswordRequestDTO;
import com.bookbrew.bff.web.dto.auth.LoginRequestDTO;
import com.bookbrew.bff.web.dto.auth.PasswordChangeRequestDTO;
import com.bookbrew.bff.web.dto.auth.RecoverEmailRequestDTO;
import com.bookbrew.bff.web.dto.auth.ResetPasswordRequestDTO;
import com.bookbrew.bff.web.dto.auth.UserDTO;
import com.bookbrew.bff.web.dto.auth.UserProfileDTO;
import com.bookbrew.bff.web.dto.auth.UserRequestDTO;

import jakarta.validation.Valid;

@FeignClient(name = "auth-service", url = "${auth.service.url}/api", configuration = FeignConfig.class)
public interface AuthServiceClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable Long id);

    @PostMapping("/users")
    UserDTO createUser(@Valid @RequestBody UserRequestDTO user);

    @PutMapping("/users/{id}")
    UserDTO updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO user);

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id);

    @GetMapping("/user-profiles")
    List<UserProfileDTO> getAllUserProfiles();

    @GetMapping("/user-profiles/{id}")
    UserProfileDTO getUserProfileById(@PathVariable Long id);

    @PostMapping("/user-profiles")
    UserProfileDTO createUserProfile(@Valid @RequestBody UserProfileDTO userProfile);

    @PutMapping("/user-profiles/{id}")
    UserProfileDTO updateUserProfile(@PathVariable Long id, @Valid @RequestBody UserProfileDTO userProfile);

    @DeleteMapping("/user-profiles/{id}")
    void deleteUserProfile(@PathVariable Long id);

    @PostMapping("/auth/login")
    UserRequestDTO login(@RequestBody LoginRequestDTO request);

    @PutMapping("/auth/users/{userId}/password")
    UserRequestDTO changePassword(@PathVariable Long userId, @Valid @RequestBody PasswordChangeRequestDTO request);

    @PostMapping("/auth/forgot-password")
    Map<String, String> forgotPassword(@RequestBody ForgotPasswordRequestDTO request);

    @PostMapping("/auth/reset-password")
    ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordRequestDTO request);

    @PostMapping("/auth/recover-email")
    Map<String, String> recoverEmail(@RequestBody RecoverEmailRequestDTO request);
}
