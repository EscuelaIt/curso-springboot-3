package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.exceptions.ProductoNotFoundException;
import edu.escuelait.tienda.services.ProductoService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductosRestController {

    private ProductoService productoService;

    public ProductosRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoPorId(@PathVariable Long id) {

        return this.productoService.getProductoPorId(id)
                .map(producto -> {
                    return ResponseEntity.ok(producto);
                })
                .orElseThrow(ProductoNotFoundException::new);
    }



    @GetMapping
    public ResponseEntity<?> getAllProductos(
            @PageableDefault(size = 2,sort = {"name"},direction = Sort.Direction.ASC)
            Pageable pageable){

        return ResponseEntity.ok(this.productoService.getAllProductos(pageable));

    }

    @GetMapping("/menos/{id}")
    public ResponseEntity<?> getAllProductosByIdLess(@PathVariable Long id){

        return ResponseEntity.ok(this.productoService.getAllProductosByIdLess(id));

    }



}
