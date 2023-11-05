package create.puru.productservicettsevening.controller;

import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import create.puru.productservicettsevening.services.CategoryService;

import org.springframework.web.bind.annotation.*;

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
    //check


    @PostMapping()
    public Category addCategory(@RequestBody Category category)
    {
        Category category1=categoryService.addNewCategory(category);
        return category1;
    }
//check 2


}
