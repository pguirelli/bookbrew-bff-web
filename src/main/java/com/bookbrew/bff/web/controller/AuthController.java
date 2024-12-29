package com.bookbrew.bff.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookbrew.bff.web.client.AuthServiceClient;
import com.bookbrew.bff.web.dto.ForgotPasswordRequestDTO;
import com.bookbrew.bff.web.dto.LoginRequestDTO;
import com.bookbrew.bff.web.dto.RecoverEmailRequestDTO;
import com.bookbrew.bff.web.dto.ResetPasswordRequestDTO;

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

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO request) {
        return authServiceClient.resetPassword(request);
    }

    @PostMapping("/recover-email")
    public ResponseEntity<?> recoverEmail(@RequestBody RecoverEmailRequestDTO request) {
        return authServiceClient.recoverEmail(request);
    }
}
