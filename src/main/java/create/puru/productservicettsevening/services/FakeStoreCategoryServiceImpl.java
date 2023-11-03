package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.clients.FakeStoreProductDTO;
import create.puru.productservicettsevening.clients.FakestoreClient;
import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class FakeStoreCategoryServiceImpl implements CategoryService {
    private  Product convertFakeStoreProductDTOtoProducts(FakeStoreProductDTO fakeStoreProductDTO)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice( fakeStoreProductDTO.getPrice());
        Category category = new Category();
        category.setName( fakeStoreProductDTO.getCategory());
    //    product.setCategory(category);
        product.setImageUrl( fakeStoreProductDTO.getImage());
        return  product;
    }

    private RestTemplateBuilder restTemplateBuilder;
    FakestoreClient fakestoreClient;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder,FakestoreClient fakestoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakestoreClient=fakestoreClient;
    }


    @Override
    public List<Product> getProductsInCategories(String categoryName) {

        List<FakeStoreProductDTO> fakeStoreProductDTOS1 = fakestoreClient.getProductsInCategories(categoryName);
        List<Product> answer=new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS1) {
            answer.add(convertFakeStoreProductDTOtoProducts(fakeStoreProductDTO));
        }
        return answer;
    }

    @Override
    public Category addNewCategory(Category category) {
        return null;
    }


    @Override
    public List<String> getAllCategories() {

       List<String> str=fakestoreClient.getAllCategories();
        return str;
    }
}
