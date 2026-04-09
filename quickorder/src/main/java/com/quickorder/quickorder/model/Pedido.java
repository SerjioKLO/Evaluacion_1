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

    @NotNull(message = "El ID no puede quedar vacío")
    private int id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String nombreCliente;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El estado no puede quedar vacío")
    private Estado estado;

    @NotNull(message = "El tipo de pedido no puede quedar vacío")
    private TipoPedido tipoPedido;

    @NotNull(message = "El monto total no puede quedar vacío")
    private Double  montoTotal;

    @NotNull(message = "La fecha del pedido no puede quedar vacía")
    private LocalDate fechaPedido;

}

