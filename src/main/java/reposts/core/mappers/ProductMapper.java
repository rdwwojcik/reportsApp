package reposts.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reposts.core.dto.ProductDTO;
import reposts.core.entities.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product fromDTO(ProductDTO productDTO);

    ProductDTO toDTO(Product product);

    List<Product> fromDTO(List<ProductDTO> productsDTO);

    List<ProductDTO> toDTO(List<Product> products);
}
