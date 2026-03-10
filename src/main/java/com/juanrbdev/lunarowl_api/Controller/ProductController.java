package com.juanrbdev.lunarowl_api.Controller;
import com.juanrbdev.lunarowl_api.DTO.CreateProductRequest;
import com.juanrbdev.lunarowl_api.Entity.ProductEntity;
import com.juanrbdev.lunarowl_api.Enum.ProductCategoryEnum;
import com.juanrbdev.lunarowl_api.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value="/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductEntity> createProduct(
            @ModelAttribute CreateProductRequest request,
            @RequestParam MultipartFile image
    ) {

        ProductEntity product = productService.createProduct(request, image);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{category}")
    public List<ProductEntity> getProductsByCategory(@PathVariable ProductCategoryEnum category){
        return productService.getProductsByCategory(category);
    }

}
