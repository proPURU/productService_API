package create.puru.productservicettsevening.services;


import create.puru.productservicettsevening.models.Product;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();
    List<Product> getProductsInCategories(String categoryName);
}
