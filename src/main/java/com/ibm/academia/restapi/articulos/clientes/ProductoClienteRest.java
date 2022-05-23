package com.ibm.academia.restapi.articulos.clientes;

import com.ibm.academia.restapi.articulos.modelo.entidades.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-productos", url = "localhost:8001")
public interface ProductoClienteRest {

    @GetMapping("/api/v1/rest-productos/producto/listar")
    public List<Producto> consultarTodosProductos();

    @GetMapping("/api/v1/rest-productos/producto/ver-detalle/productoId/{productoId}")
    public Producto consultarDetalleProducto(@PathVariable Long productoId);
}
