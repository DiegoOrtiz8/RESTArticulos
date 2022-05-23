package com.ibm.academia.restapi.articulos.controladores;

import com.ibm.academia.restapi.articulos.modelo.entidades.Articulo;
import com.ibm.academia.restapi.articulos.modelo.servicios.IArticuloService;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    private final static Logger logger = LoggerFactory.getLogger(ArticuloController.class);

    @Autowired
    @Qualifier("serviceFeign")
    private IArticuloService articuloService;

    @GetMapping("/listar")
    public ResponseEntity<?> consultarTodosArticulos() {
        List<Articulo> articulos = articuloService.buscarTodosArticulos();

        return new ResponseEntity<List<Articulo>>(articulos,HttpStatus.OK);
    }

    @GetMapping("/ver-detalle/productoId/{productoId}/cantidad/{cantidad}")
    public ResponseEntity<?> consultarDetalleArticulo(@PathVariable Long productoId, @PathVariable Integer cantidad) {

        Map<String, Object> respuesta = new HashMap<String, Object>();
        Articulo articulo = null;

        try {
            articulo = articuloService.buscarArticulosPorId(productoId, cantidad);
        }
        catch (FeignException fe) {
            logger.info("Error:" + fe.getMessage() + "causa: " + fe.getCause());
            respuesta.put("mensaje", fe.getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            logger.info("Error:" + e.getMessage() + "causa: " + e.getCause());
            respuesta.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
    }
}
