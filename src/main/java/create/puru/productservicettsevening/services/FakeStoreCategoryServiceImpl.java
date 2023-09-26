package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.CategoryDTO;
import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {


    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public List<Product> getProductsInCategories(String categoryName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{name}",
                ProductDTO[].class,
                categoryName
        );
        List<Product> answer = new ArrayList<>();

        for (ProductDTO productDto : l.getBody()) {
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

    @Override
    public List<String> getAllCategories() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        List<String> answer1 = new ArrayList<>();
        for (String str : l.getBody()) {
                answer1.add(str);
            }

            return answer1;
    }
}
