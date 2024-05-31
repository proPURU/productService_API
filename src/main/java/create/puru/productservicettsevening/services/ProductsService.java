package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    List<Product> GetAllProducts();

    public List<Product> GetAllProductsByPagination();

    Product addNewProduct(
            ProductDTO product
    );
    Optional<Product> getSingleProduct(Long productId);
    Product updateProducts( Long productId,Product product);
    String deleteProducts(Long productId);
}
