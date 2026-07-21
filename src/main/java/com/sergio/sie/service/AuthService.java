package com.sergio.sie.service;

import com.sergio.sie.dto.request.LoginRequest;
import com.sergio.sie.dto.request.RegisterRequest;
import com.sergio.sie.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
