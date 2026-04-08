package com.quickorder.quickorder.model;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @NotNull(message = "El ID no puede ser nulo")
    private long id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String nombreCliente;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    private Estado estado;
    private TipoPedido tipoPedido;
    private Double  montoTotal;
    private LocalDate fechaPedido;

}

