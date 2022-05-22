package com.ibm.academia.restapi.articulos.modelo.servicios;

import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;
import com.ibm.academia.restapi.articulos.modelo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Articulo> buscarTodos() {

        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/api/v1/rest-productos/producto/listar", Producto[].class));

        return productos
                .stream()
                .map(p -> new Articulo(p, 1))
                .collect(Collectors.toList());

    }

    @Override
    public Articulo buscarPorId(Long id, Integer cantidad) {
        return null;
    }
}
