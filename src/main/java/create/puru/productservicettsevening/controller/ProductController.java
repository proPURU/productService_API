package create.puru.productservicettsevening.controller;

import create.puru.productservicettsevening.dtos.GetSingleProductResponseDTO;
import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
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


    //Input to further call
    //Product too Product DTO
    ProductDTO convertProduct_to_ProductDTO(Product  product)
    {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    Product convertProductDTO_to_Product(ProductDTO productDTO)
    {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        return  product;
    }






    ///////////////// ADD ALL PRODUCT CONTROLLER //////////////////
    @GetMapping()
    public List<Product> GetAllProducts()
    {
        return productsService.GetAllProducts();
    }



    ///////////////// GET SINGLE  PRODUCT CONTROLLER //////////////////
    @GetMapping("{productId}")
    public GetSingleProductResponseDTO getSingleProduct(@PathVariable ("productId") Long productId)
    {
        GetSingleProductResponseDTO responseDTO=new GetSingleProductResponseDTO();
        responseDTO.setProduct(
                productsService.getSingleProduct(productId)
        );
        return responseDTO;
    }



    ///////////////// ADD NEW PRODUCT CONTROLLER //////////////////
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product)
    {
        ProductDTO productDto=convertProduct_to_ProductDTO(product);
        Product productObj=productsService.addNewProduct(
                productDto
        );
        //ResponseEntity<Product> response=new ResponseEntity<>(productObj, HttpStatus.OK);
        return productObj;
    }




    ///////////////// UPDATE  NEW PRODUCT CONTROLLER //////////////////

    //@PutMapping
    @PatchMapping("{productId}")
    public Product updateProducts(@PathVariable ("productId") Long productId ,@RequestBody ProductDTO productDTO)
    {
        Product product =convertProductDTO_to_Product(productDTO);
        Product productObj=productsService.updateProducts(
                productId,
                product
        );
        return productObj;
    }




    ///////////////// DELETE  PRODUCT CONTROLLER //////////////////
    @DeleteMapping("{productId}")
    public String deleteProducts(@PathVariable ("productId") Long productId) {

            HttpStatusCode statusCode = productsService.deleteProducts(productId);
            return "Deleted product with status code: " + statusCode;
    }

}




