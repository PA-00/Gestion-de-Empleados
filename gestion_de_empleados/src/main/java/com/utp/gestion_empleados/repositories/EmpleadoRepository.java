package com.utp.gestion_empleados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utp.gestion_empleados.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
