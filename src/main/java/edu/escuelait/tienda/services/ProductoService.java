package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Producto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public Optional<Producto> getProductoPorId(Long id);

    public List<Producto> getAllProductos(Pageable pageable);

    public List<Producto> getAllProductosByIdLess(Long id);

}
