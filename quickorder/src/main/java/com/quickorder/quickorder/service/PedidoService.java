package com.quickorder.quickorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickorder.quickorder.model.Pedido;
import com.quickorder.quickorder.repository.PedidoRepository;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public List<Pedido> getPedidos() { return pedidoRepository.obtenerPedidos(); }
    public Pedido savePedido(Pedido pedido) { return pedidoRepository.registrarPedido(pedido); }
    public Pedido getPedidoById(long id) { return pedidoRepository.buscarPorId(id); }
    public Pedido updatePedido(Pedido pedido) { return pedidoRepository.actualizarPedido(pedido); }
    public String deletePedido(long id) { pedidoRepository.eliminarPedido(id);
        return "Pedido eliminado exitosamente";
    }
    public List<Pedido> obtenerPedidoPorEstado(String estado) { return pedidoRepository.obtenerPedidoPorEstado(estado); }


}
