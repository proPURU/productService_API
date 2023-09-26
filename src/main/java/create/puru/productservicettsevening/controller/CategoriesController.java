package create.puru.productservicettsevening.controller;

import create.puru.productservicettsevening.dtos.CategoryDTO;
import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Product;
import create.puru.productservicettsevening.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products/category")
public class CategoriesController {

    private CategoryService categoryService;
    private CategoriesController(CategoryService categoryService)
    {
        this.categoryService=categoryService;
    }

    @GetMapping()
    public List<String> getAllCategories()
    {
        return categoryService.getAllCategories();
    }


    @GetMapping("{categoryId}")
    public List<Product> getProductsInCategories(@PathVariable ("categoryId") String categoryName)
    {
        return categoryService.getProductsInCategories(categoryName);
    }



}
