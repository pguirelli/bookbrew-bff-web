package com.bookbrew.bff.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookbrew.bff.web.dto.ForgotPasswordRequestDTO;
import com.bookbrew.bff.web.dto.LoginRequestDTO;
import com.bookbrew.bff.web.dto.RecoverEmailRequestDTO;
import com.bookbrew.bff.web.dto.ResetPasswordRequestDTO;
import com.bookbrew.bff.web.dto.TokenResponseDTO;
import com.bookbrew.bff.web.dto.UserResponseDTO;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthServiceClient {

    @PostMapping("/api/auth/login")
    ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO request);

    @PostMapping("/api/auth/forgot-password")
    ResponseEntity<TokenResponseDTO> forgotPassword(@RequestBody ForgotPasswordRequestDTO request);

    @PostMapping("/api/auth/reset-password")
    ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordRequestDTO request);

    @PostMapping("/api/auth/recover-email")
    ResponseEntity<UserResponseDTO> recoverEmail(@RequestBody RecoverEmailRequestDTO request);
}
