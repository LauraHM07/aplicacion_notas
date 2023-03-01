package com.laura.notas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.notas.models.Permiso;
import com.laura.notas.repositories.PermisoRepository;

@Service
public class PermisosService {

    @Autowired
    private PermisoRepository permisoRepository;

    public Permiso createPermiso(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public Permiso updatePermiso(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public void deletePermiso(int permisoId) {
        permisoRepository.deleteById(permisoId);
    }

    public Permiso getPermiso(int permisoId) {
        return permisoRepository.findById(permisoId).orElse(null);
    }

    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll();
    }
}
