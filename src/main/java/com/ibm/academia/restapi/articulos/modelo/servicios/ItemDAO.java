package com.ibm.academia.restapi.articulos.modelo.servicios;

import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;

import java.util.List;

public interface ItemDAO {

    public List<Articulo> buscarTodos();
    public Articulo buscarPorId(Long id, Integer cantidad);
}
