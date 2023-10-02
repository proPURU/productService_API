package create.puru.productservicettsevening.clients;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import io.micrometer.common.lang.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakestoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    //Respective Object what needs getting initialized
    public FakestoreClient(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder=restTemplateBuilder;
    }



    //////////////////  Calling method for Get All Products
    public List<FakeStoreProductDTO> getAllProducts()
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );
        return Arrays.asList(l.getBody());
    }



    ///////   Calling method for Get Single Products
    public FakeStoreProductDTO getSingleProduct(Long productId){

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                productId);

        FakeStoreProductDTO fakeStoreProductDTO=response.getBody();

        return fakeStoreProductDTO;
    }




    //Calling method for Add New  Products
    public FakeStoreProductDTO addNewProduct(FakeStoreProductDTO fakeStoreProductObj)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response= restTemplate.postForEntity("https://fakestoreapi.com/products",
                fakeStoreProductObj,
                FakeStoreProductDTO.class
        );
        FakeStoreProductDTO fakeStoreProductDTO=response.getBody();
        return fakeStoreProductDTO;
    }



    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();


        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    ////////////// U P D A T E /////////

    public  FakeStoreProductDTO updateProducts(Long Id,Product product ){

        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());

                 ResponseEntity<FakeStoreProductDTO> fakeStoreProductDtoResponse=  requestForEntity(
                            HttpMethod.PATCH,
                            "https://fakestoreapi.com/products/{id}" ,
                            fakeStoreProductDTO,
                            FakeStoreProductDTO.class,
                            Id
                    );
        FakeStoreProductDTO obj=fakeStoreProductDtoResponse.getBody();
        return obj;
    }



    ///////////////// Calling method for Delete Products
    public HttpStatusCode deleteProducts(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Void> response =  restTemplate.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.DELETE, null,
                Void.class, productId);
       return response.getStatusCode();
    }


    //////////////////  Calling method for Get Products by respective categories
    public  List<FakeStoreProductDTO>  getProductsInCategories(String categoryName) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{name}",
                FakeStoreProductDTO[].class,
                categoryName
        );

        return Arrays.asList(l.getBody());
    }




    //////////////////  Calling method for Get All  categories List
    public List<String> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        return Arrays.asList(l.getBody());
    }

}
