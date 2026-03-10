package com.juanrbdev.lunarowl_api.Service;
import com.juanrbdev.lunarowl_api.DTO.CreateProductRequest;
import com.juanrbdev.lunarowl_api.Entity.ProductEntity;
import com.juanrbdev.lunarowl_api.Enum.ProductCategoryEnum;
import com.juanrbdev.lunarowl_api.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //*  C R E A R   N U E V O    P R O D U C T O *//

    public ProductEntity createProduct(CreateProductRequest request, MultipartFile image) {

        try {

            if(productRepository.existsByName(request.getName())){
                throw new RuntimeException("Product already exists");
            }

            String uploadDir = "uploads/";

            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);

            Files.createDirectories(path.getParent());
            Files.write(path, image.getBytes());

            ProductEntity product = new ProductEntity();

            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());
            product.setCategory(request.getCategory());
            product.setSizes(request.getSizes());

            product.setImageUrl("/uploads/" + fileName);
            product.setAvailable(true);

            return productRepository.save(product);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear Producto", e);
        }
    }



    // * O B T E N E R   P R O D U C T O   P O R    C A T E G O R I A //

    public List<ProductEntity> getProductsByCategory(ProductCategoryEnum category){
        try {
            return  productRepository.findByCategory(category);
        } catch (Exception e) {
            throw new RuntimeException("Categoria no encontrada",e);
        }
    }



}