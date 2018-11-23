package reposts.core.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reposts.core.dto.ProductDTO;
import reposts.core.entities.Product;
import reposts.core.mappers.ProductMapper;
import reposts.core.repositories.ProductRepository;
import reposts.core.services.ProductService;
import reposts.core.services.exceptions.ProductNotFoudException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> findProductsByName(String name) throws ProductNotFoudException {
        List<ProductDTO> productsDTO = mapper.toDTO(repository.findByName(name));
        if(productsDTO.isEmpty()){
            throw new ProductNotFoudException("No products for the name indicated");
        }
        return productsDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return mapper.toDTO(product.get());
    }

    @Override
    public ProductDTO save(ProductDTO obj) {
        return mapper.toDTO(repository.save(mapper.fromDTO(obj)));
    }

    @Override
    public void delete(ProductDTO obj) {
        repository.delete(mapper.fromDTO(obj));
    }
}
