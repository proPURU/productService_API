package create.puru.productservicettsevening.services;


import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();
    List<Product> getProductsInCategories(String categoryName);
    Category addNewCategory(Category category);
}
