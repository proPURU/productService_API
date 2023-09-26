package create.puru.productservicettsevening.controller;

import create.puru.productservicettsevening.dtos.GetSingleProductResponseDTO;
import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Product;
import create.puru.productservicettsevening.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController  {
    private ProductsService productsService;
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }
    @GetMapping()
    public List<Product> GetAllProducts()
    {
        return productsService.GetAllProducts();
      //  return "Hey ";
    }

    @GetMapping("{productId}")
    public GetSingleProductResponseDTO getSingleProduct(@PathVariable ("productId") Long productId)
    {
        GetSingleProductResponseDTO responseDTO=new GetSingleProductResponseDTO();
        responseDTO.setProduct(
                productsService.getSingleProduct(productId)
        );
        return responseDTO;
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody ProductDTO productDto)
    {
        Product productObj=productsService.addNewProduct(
                productDto
        );
        //ResponseEntity<Product> response=new ResponseEntity<>(productObj, HttpStatus.OK);
        return productObj;
    }



    @PutMapping("{productId}")
    public Product updateProducts(@PathVariable ("productId") Long productId ,@RequestBody ProductDTO productDTO)
    {
        Product productObj=productsService.updateProducts(
                productId,
                productDTO
        );
        return productObj;
    }


    @DeleteMapping("{productId}")
    public String deleteProducts(@PathVariable ("productId") Long productId) {

            HttpStatusCode statusCode = productsService.deleteProducts(productId);
            return "Deleted product with status code: " + statusCode;
    }

}




