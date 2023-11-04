package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import create.puru.productservicettsevening.repositories.CategoryRepository;
import create.puru.productservicettsevening.repositories.ProductRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductsService implements  ProductsService{
    private ProductRepository productRepository;
    private  CategoryRepository categoryRepository;
    public SelfProductsService(ProductRepository productRepository , CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
        this.productRepository=productRepository;
    }
    public Product covertProductDTOtoProduct(ProductDTO productDTO)
    {
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImage());

        Category category = new Category();
        category.setName( productDTO.getDescription());
        category.setDescription(productDTO.getDescription());
        product.setCategory(category);

        return product;
    }

    Product convertProductDTO_to_Product(ProductDTO productDTO)
    {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImage());
        product.setDescription(productDTO.getDescription());

       Category category = new Category();
       category.setName(productDTO.getCategory());
       category.setDescription(productDTO.getDescription());
       product.setCategory(category);

        return  product;
    }


    @Override
    public List<Product> GetAllProducts() {
        List<Product> list=productRepository.findAll();

        return list;
    }

    // Add new Product
    @Override
    public Product addNewProduct(ProductDTO productDto) {
        Product obj=convertProductDTO_to_Product(productDto);
        productRepository.save(obj);
        return obj;
    }

    // GetSingleProduct
    @Override
    public Optional<Product> getSingleProduct(Long productId) {
       Optional<Product> product;
        product = productRepository.findById(productId);
        return product;
    }


    //Update Products
    @Override
    public Product updateProducts(Long productId, Product product) {
        Product product1= productRepository.findById(productId).orElse(null);

        if(product==null)
        {
            return null;
        }
        if(product.getPrice()!=0)
        {
            product1.setPrice(product.getPrice());
        }
        if(product.getTitle()!=null)
        {
            product1.setTitle(product.getTitle());
        }
        if(product.getImageUrl()!=null)
        {
            product1.setImageUrl(product.getImageUrl());
        }
       productRepository.save(product1);
        return product1;

    }

    // Delete Products
    @Override
    public  String deleteProducts(Long productId) {
         productRepository.deleteById(productId);

        return "Deleted this id productId";
    }
}
