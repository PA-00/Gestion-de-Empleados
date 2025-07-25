package com.utp.gestion_empleados.controllers;

import com.utp.gestion_empleados.models.Empleado;
import com.utp.gestion_empleados.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado empleadoActualizado) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setNombres(empleadoActualizado.getNombres());
                    empleado.setApellidos(empleadoActualizado.getApellidos());
                    empleado.setCargo(empleadoActualizado.getCargo());
                    empleado.setCorreo(empleadoActualizado.getCorreo());
                    empleado.setCelular(empleadoActualizado.getCelular());
                    empleado.setFechaIngreso(empleadoActualizado.getFechaIngreso());
                    empleado.setSalario(empleadoActualizado.getSalario());
                    return ResponseEntity.ok(empleadoRepository.save(empleado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}