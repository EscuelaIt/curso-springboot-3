package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.mappers.ProductosMapper;
import edu.escuelait.tienda.persistance.repositories.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService{

    ProductoRepository productoRepository;

    ProductosMapper productosMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository,ProductosMapper productosMapper){

        log.info("ejecutando constructor");
        this.productoRepository = productoRepository;
        this.productosMapper = productosMapper;
    }


    @Override
    public Optional<Producto> getProductoPorId(Long id) {

        return this.productoRepository.findById(id).map(productoEntity -> {
            //Mapeando un productoEntity a un Producto
            Producto producto = productosMapper.mapProducto(productoEntity);
            return producto;
        });

    }

    @Override
    public List<Producto> getAllProductos(Pageable pageable) {

        return this.productoRepository.findAll(pageable).stream().map(productoEntity -> {
            return productosMapper.mapProducto(productoEntity);
        }).collect(Collectors.toList());



    }

    @Override
    public List<Producto> getAllProductosByIdLess(Long id) {
        return this.productoRepository.findByIdLessThan(id).stream().map(productoEntity -> {
            return productosMapper.mapProducto(productoEntity);
        }).collect(Collectors.toList());

    }
}
