package com.motos.contado.contado_backend.service;


import org.springframework.stereotype.Service;

@Service
public class MockAuthService {

    // Credenciales de ejemplo: usuario="user", contraseña="pass"
    public boolean authenticate(String username, String password) {
        return "user".equals(username) && "pass".equals(password);
    }
}
