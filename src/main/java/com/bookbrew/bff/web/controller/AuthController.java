package com.bookbrew.bff.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookbrew.bff.web.client.AuthServiceClient;
import com.bookbrew.bff.web.dto.auth.ForgotPasswordRequestDTO;
import com.bookbrew.bff.web.dto.auth.LoginRequestDTO;
import com.bookbrew.bff.web.dto.auth.PasswordChangeRequestDTO;
import com.bookbrew.bff.web.dto.auth.RecoverEmailRequestDTO;
import com.bookbrew.bff.web.dto.auth.ResetPasswordRequestDTO;
import com.bookbrew.bff.web.dto.auth.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bff/auth")
@CrossOrigin
public class AuthController {

    private final AuthServiceClient authServiceClient;

    public AuthController(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        return authServiceClient.login(request);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequestDTO request) {
        return authServiceClient.forgotPassword(request);
    }

    @PutMapping("/users/{userId}/password")
    public ResponseEntity<UserDTO> changePassword(
            @PathVariable Long userId,
            @Valid @RequestBody PasswordChangeRequestDTO request) {
        return ResponseEntity.ok(authServiceClient.changePassword(userId, request));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO request) {
        return authServiceClient.resetPassword(request);
    }

    @PostMapping("/recover-email")
    public ResponseEntity<?> recoverEmail(@RequestBody RecoverEmailRequestDTO request) {
        return authServiceClient.recoverEmail(request);
    }
}
