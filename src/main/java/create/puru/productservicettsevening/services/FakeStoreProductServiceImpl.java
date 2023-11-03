//package create.puru.productservicettsevening.services;
//
//import create.puru.productservicettsevening.clients.FakestoreClient;
//import create.puru.productservicettsevening.clients.FakeStoreProductDTO;
//import create.puru.productservicettsevening.dtos.ProductDTO;
//import create.puru.productservicettsevening.models.Category;
//import create.puru.productservicettsevening.models.Product;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
////@Service
//public class FakeStoreProductServiceImpl implements  ProductsService {
//
//    private RestTemplateBuilder restTemplateBuilder;
//    private FakestoreClient fakestoreClient;
//
//    public FakeStoreProductServiceImpl( RestTemplateBuilder restTemplateBuilder,FakestoreClient fakestoreClient)
//    {
//        this.fakestoreClient=fakestoreClient;
//        this.restTemplateBuilder=restTemplateBuilder;
//    }
//
//
//
//
//    ///   FakeStoreProductDTO --->>> Products (Client DTO to MODEL)
//
////    private  Product convertFakeStoreProductDTOtoProducts(FakeStoreProductDTO fakeStoreProductDTO)
////    {
////        Product product = new Product();
////        product.setId(fakeStoreProductDTO.getId());
////        product.setTitle(fakeStoreProductDTO.getTitle());
////        product.setPrice( fakeStoreProductDTO.getPrice());
////        Category category = new Category();
////        category.setName( fakeStoreProductDTO.getCategory());
////        product.setCategory(category);
////        product.setImageUrl( fakeStoreProductDTO.getImage());
////        return  product;
////    }
//
//
//    //////  ProductDTO to --->>>   FakeStoreProductDTO (DTO to MODEL)
//    public  FakeStoreProductDTO convertProductDTO_to_fakeStoreProductsDTO(ProductDTO productDTOobj)
//    {
//        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
//        fakeStoreProductDTO.setId(productDTOobj.getId());
//        fakeStoreProductDTO.setDescription(productDTOobj.getDescription());
//        fakeStoreProductDTO.setTitle(productDTOobj.getTitle());
//        fakeStoreProductDTO.setPrice(productDTOobj.getPrice());
//
//        return fakeStoreProductDTO;
//
//    }
//
//    public  Product convertProductDTOtoProduct(ProductDTO productDTO)
//    {
//        Product product=new Product();
//        product.setDescription(productDTO.getDescription());
//        product.setId(productDTO.getId());
//        product.setTitle(productDTO.getTitle());
//        product.setPrice(productDTO.getPrice());
//
//        return product;
//    }
//
//
//
//
//    ////////////////// GET  ALL   PRODUCTS ////////////////
//    @Override
//    public List<Product> GetAllProducts(){
//
//        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakestoreClient.getAllProducts();
//        List<Product> answer=new ArrayList<>();
//        for (FakeStoreProductDTO fakeStoreProductDTO: fakestoreClient.getAllProducts()) {
//            answer.add(convertFakeStoreProductDTOtoProducts(fakeStoreProductDTO));
//        }
//        return answer;
//    }
//
//
//
//    ////////////////// GET  SINGLE PRODUCTS ////////////////
//    @Override
//    public Optional<Product> getSingleProduct(Long productId)
//    {
//         FakeStoreProductDTO fakeStoreProductDTO = fakestoreClient.getSingleProduct(productId);
//         return Optional.of(convertFakeStoreProductDTOtoProducts(fakeStoreProductDTO));
//    }
//
//
//
//
//    ////////////// ADD NEW PRODUCTS /////////
//    @Override
//    public Product addNewProduct(ProductDTO productDTOobj)
//    {
//        return  convertFakeStoreProductDTOtoProducts(convertProductDTO_to_fakeStoreProductsDTO(productDTOobj));
//    }
//
//
//
//
//    /////////////////     UPDATE //////////
//    @Override
//    public Product updateProducts( Long productId,Product product)
//    {
//        FakeStoreProductDTO fakeStoreProductDTO=fakestoreClient.updateProducts(productId,product);
//        return convertFakeStoreProductDTOtoProducts(fakeStoreProductDTO);
//    }
//
//
//
//   ////////////////// REPLACE  PRODUCTS ////////////////
//
//    Product replaceProduct(Long productId,Product product)
//    {
//        return null;
//    }
//    @Override
//    public String deleteProducts(Long productId) {
//
//        HttpStatusCode httpStatusCode=fakestoreClient.deleteProducts(productId);
//        return  "Okay bro";
//    }
//
//}
