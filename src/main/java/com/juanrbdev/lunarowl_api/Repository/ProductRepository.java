package com.juanrbdev.lunarowl_api.Repository;
import com.juanrbdev.lunarowl_api.Entity.ProductEntity;
import com.juanrbdev.lunarowl_api.Enum.ProductCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    boolean existsByName(String name);
    List<ProductEntity> findByCategory(ProductCategoryEnum category);

}
