package com.utp.gestion_empleados.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 


import java.time.LocalDate;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "celular", nullable = false, length = 9)
    private Integer celular;
    
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "salario" ,precision = 10, scale = 2)
    private BigDecimal salario;

}
