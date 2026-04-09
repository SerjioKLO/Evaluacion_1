package com.quickorder.quickorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.quickorder.quickorder.model.Pedido;
import com.quickorder.quickorder.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.getPedidos();
    }

    @PostMapping
    public Pedido savePedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable long id) {
        return pedidoService.getPedidoById(id);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable long id, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable long id) {
        return pedidoService.deletePedido(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Pedido> obtenerPedidoPorEstado(@PathVariable String estado) {
        return pedidoService.obtenerPedidoPorEstado(estado);
    }

}
