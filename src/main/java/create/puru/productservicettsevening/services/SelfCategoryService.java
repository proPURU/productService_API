package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import create.puru.productservicettsevening.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SelfCategoryService implements CategoryService{
    private CategoryRepository categoryRepository;
    public SelfCategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> list=categoryRepository.findAll();

        List<String> ans=new ArrayList<String>();
        for(int i=0;i<list.size();i++)
        {
            ans.add(list.get(i).getDescription());
        }

        return ans;

    }

    @Override
    public List<Product> getProductsInCategories(String categoryName) {
        return null;
    }

    @Override
    public Category addNewCategory(Category category) {
        Category category1=categoryRepository.save(category);
        return category1;
    }
}
