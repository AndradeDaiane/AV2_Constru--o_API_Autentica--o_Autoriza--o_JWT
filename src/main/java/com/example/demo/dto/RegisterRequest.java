package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "O username é obrigatório")
    private String username;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "A role é obrigatória")
    // Role padrão para novos usuários (pode ser "USER", "ADMIN", etc.)
    // Você pode deixar sem @NotBlank, pois já tem valor padrão, mas pode adicionar se desejar validação explícita.
    private String role = "USER";
}
