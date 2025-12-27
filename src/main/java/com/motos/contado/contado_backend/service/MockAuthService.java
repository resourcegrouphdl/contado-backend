package com.motos.contado.contado_backend.service;


import org.springframework.stereotype.Service;

@Service
public class MockAuthService {

    /**
     * Maqueta de autenticación: no hay credenciales en código.
     * Devuelve true si usuario y contraseña no están vacíos.
     */
    public boolean authenticate(String username, String password) {
        return username != null && password != null && !username.isBlank() && !password.isBlank();
    }
}
