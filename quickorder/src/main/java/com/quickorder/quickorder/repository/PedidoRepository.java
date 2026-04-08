package com.quickorder.quickorder.repository;
import com.quickorder.quickorder.model.Pedido;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

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
            pedReg.setId(getId());
            pedReg.setNombreCLiente(getNombreCLiente());
            pedReg.setDescripcion(getDescripcion());
            pedReg.setEstado(getEstado());
            pedReg.setTipoPedido(getTipoPedido());
            pedReg.setMontoTotal(getMontoTotal());
            pedReg.setFechaPedido(getFechaPedido());
            listaPedidos.add(pedReg);
            return pedReg;
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
        pedAct.setNombreCLiente(getNombreCLiente());
        pedAct.setDescripcion(getDescripcion());
        pedAct.setEstado(getEstado());
        pedAct.setTipoPedido(getTipoPedido());
        pedAct.setMontoTotal(getMontoTotal());
        pedAct.setFechaPedido(getFechaPedido());
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
