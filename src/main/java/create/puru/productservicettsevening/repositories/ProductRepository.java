package create.puru.productservicettsevening.repositories;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatusCode;

public interface ProductRepository extends JpaRepository<Product,Long> {


  //  String deleteProductById(Long id);
   // Product save(Product product);

   // Product save(ProductDTO productDto);
//    Product findProductByIdIs(Long id);
//    Product findProductByIdEquals(Long id);
//
//    Product findByPriceBetweenAndTitleLessThanEqual(double greaterThanEqualPrice ,double lessThanEqualPrice ,String titleLessThan);

}
