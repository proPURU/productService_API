package create.puru.productservicettsevening.repositories;

import create.puru.productservicettsevening.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

//    Category saveCategory(Category category);
//
//    List<Category> findAllBy(List<Long> ids);

}
