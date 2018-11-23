package reposts.core.services;

import reposts.core.dto.ProductDTO;
import reposts.core.entities.Product;

import java.util.List;

public interface ProductService extends ServiceInterface<ProductDTO>{

    List<ProductDTO>  findProductsByName(String name);
}
