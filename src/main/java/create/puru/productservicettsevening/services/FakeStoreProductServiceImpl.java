package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements  ProductsService {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl( RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public List<Product> GetAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductDTO[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDTO[].class
        );

        List<Product> answer = new ArrayList<>();

        for (ProductDTO productDto: l.getBody()) {
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setImageUrl(productDto.getImage());
            answer.add(product);
        }

        return answer;

    }
    public Product getSingleProduct(Long productId){

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                ProductDTO.class ,productId);
        //(url/ReturnType(dataType)/Params)
            ProductDTO productDto=response.getBody();
            Product product=new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            Category category = new Category();
            product.setCategory(category);
            category.setName(productDto.getCategory());
           // product.setDescription(category.getDescription());
            product.setImageUrl(productDto.getImage());

            return product;

    }


    @Override
    public Product addNewProduct(ProductDTO productDTOobj)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response= restTemplate.postForEntity("https://fakestoreapi.com/products",
               productDTOobj,
                ProductDTO.class
                );
        ProductDTO productDto=response.getBody();
        Product product1=new Product();
        product1.setId(productDto.getId());
        product1.setTitle(productDto.getTitle());
        product1.setPrice(productDto.getPrice());
       // product1.setDescription(productDto.getDescription());
        Category category = new Category();
        product1.setCategory(category);
        category.setName(productDto.getCategory());
        // product.setDescription(category.getDescription());
        product1.setImageUrl(productDto.getImage());
        return  product1;
    }

    @Override
    public Product updateProducts( Long productId,ProductDTO productDTO)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response =  restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.PUT,
                new HttpEntity<ProductDTO>(productDTO),
                ProductDTO.class,
                productId);

        ProductDTO productDto=response.getBody();
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        Category category = new Category();
        product.setCategory(category);
        category.setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        return product;
    }
    @Override
    public HttpStatusCode deleteProducts(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Void> response =  restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.DELETE, null,
                Void.class, productId);
        return response.getStatusCode();
    }


}
