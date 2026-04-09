package com.quickorder.quickorder.repository;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.quickorder.quickorder.model.Pedido;


@Repository
public class PedidoRepository {
    private List<Pedido> listaPedidos = new ArrayList<>();

    public List<Pedido> obtenerPedidos() {
        return listaPedidos;
    }

    public Pedido buscarPorId(long id) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido registrarPedido(Pedido pedReg) {
        Pedido ped = new Pedido();
        ped.setId(pedReg.getId());
        ped.setNombreCliente(pedReg.getNombreCliente());
        ped.setDescripcion(pedReg.getDescripcion());
        ped.setEstado(pedReg.getEstado());
        ped.setTipoPedido(pedReg.getTipoPedido());
        ped.setMontoTotal(pedReg.getMontoTotal());
        ped.setFechaPedido(pedReg.getFechaPedido());
        listaPedidos.add(ped);
        return ped;
    }

    public Pedido actualizarPedido(Pedido ped) {
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getId() == ped.getId()) {
                id = ped.getId();
                idPosicion = i;
            }
        }

        Pedido pedAct = new Pedido();
        pedAct.setId(id);
        pedAct.setNombreCliente(ped.getNombreCliente());
        pedAct.setDescripcion(ped.getDescripcion());
        pedAct.setEstado(ped.getEstado());
        pedAct.setTipoPedido(ped.getTipoPedido());
        pedAct.setMontoTotal(ped.getMontoTotal());
        pedAct.setFechaPedido(ped.getFechaPedido());
        listaPedidos.set(idPosicion, pedAct);
        return pedAct;
    }

    public void eliminarPedido(long id) {
        Pedido pedido = buscarPorId(id);
        if (pedido != null) {
            listaPedidos.remove(pedido);
        }
    }

    public List<Pedido> obtenerPedidoPorEstado(String estado) {
        List<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstado().equals(estado)) {
                pedidosFiltrados.add(pedido);
            }
        }
        return pedidosFiltrados;
    }

}
