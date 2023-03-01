package com.laura.notas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.notas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Usuario findByNombre(String username);

}
