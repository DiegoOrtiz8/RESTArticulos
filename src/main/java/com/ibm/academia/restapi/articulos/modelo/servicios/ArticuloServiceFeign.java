package com.ibm.academia.restapi.articulos.modelo.servicios;

import com.ibm.academia.restapi.articulos.clientes.ProductoClienteRest;
import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
//@Primary
public class ArticuloServiceFeign implements IArticuloService{

    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Articulo> buscarTodosArticulos() {
        return clienteFeign.consultarTodosProductos().stream().map(p -> new Articulo(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Articulo buscarArticulosPorId(Long productoId, Integer cantidad) {
        return new Articulo(clienteFeign.consultarDetalleProducto(productoId), cantidad);
    }
}
