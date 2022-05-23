package com.ibm.academia.restapi.articulos.modelo.servicios;

import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;

import java.util.List;

public interface IArticuloService {

    public List<Articulo> buscarTodosArticulos();
    public Articulo buscarArticulosPorId(Long productoId, Integer cantidad);
}
