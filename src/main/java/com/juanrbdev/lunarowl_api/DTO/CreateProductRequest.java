package com.juanrbdev.lunarowl_api.DTO;
import com.juanrbdev.lunarowl_api.Enum.ProductCategoryEnum;
import com.juanrbdev.lunarowl_api.Enum.ProductSizeEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotBlank
    private String description;

    @NotNull
    private ProductCategoryEnum category;

    private List<ProductSizeEnum> sizes;

}