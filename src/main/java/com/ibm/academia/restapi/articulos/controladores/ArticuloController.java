package com.ibm.academia.restapi.articulos.controladores;

import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;
import com.ibm.academia.restapi.articulos.modelo.servicios.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping("/listar")
    public ResponseEntity<?> consultarTodosArticulos() {
        List<Articulo> articulos = articuloService.buscarTodosArticulos();

        return new ResponseEntity<List<Articulo>>(articulos,HttpStatus.OK);
    }

    @GetMapping("/ver-detalle/productoId/{productoId}/cantidad/{cantidad}")
    public ResponseEntity<?> consultarDetalleArticulo(@PathVariable Long productoId, @PathVariable Integer cantidad) {
        Articulo articulo = articuloService.buscarArticulosPorId(productoId, cantidad);

        return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
    }
}
