package com.bookbrew.bff.web.controller;

import java.util.Map;

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
import com.bookbrew.bff.web.dto.auth.UserRequestDTO;

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
    public ResponseEntity<UserRequestDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authServiceClient.login(request));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Map<String, String>> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDTO request) {
        return ResponseEntity.ok(authServiceClient.forgotPassword(request));
    }

    @PutMapping("/users/{userId}/password")
    public ResponseEntity<UserRequestDTO> changePassword(
            @PathVariable Long userId,
            @Valid @RequestBody PasswordChangeRequestDTO request) {
        return ResponseEntity.ok(authServiceClient.changePassword(userId, request));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@Valid @RequestBody ResetPasswordRequestDTO request) {
        authServiceClient.resetPassword(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/recover-email")
    public ResponseEntity<Map<String, String>> recoverEmail(@Valid @RequestBody RecoverEmailRequestDTO request) {
        return ResponseEntity.ok(authServiceClient.recoverEmail(request));
    }
}
