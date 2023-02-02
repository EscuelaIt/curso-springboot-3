package edu.escuelait.tienda.mappers;

import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.persistance.entitities.ProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductosMapper {

    public Producto mapProducto(ProductoEntity productoEntity);

    public ProductoEntity mapProductoEntity(Producto producto);


}
