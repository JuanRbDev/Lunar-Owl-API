package com.juanrbdev.lunarowl_api.Entity;
import com.juanrbdev.lunarowl_api.Enum.ProductCategoryEnum;
import com.juanrbdev.lunarowl_api.Enum.ProductSizeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_product_category", columnList = "category"),
                @Index(name = "idx_product_available", columnList = "available")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @DecimalMin("0.0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String description;

    @Column(length = 500)
    private String imageUrl;

    @Column(nullable = false)
    private Boolean available = true;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategoryEnum category;

    @ElementCollection
    @CollectionTable(
            name = "product_sizes",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private List<ProductSizeEnum> sizes;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

}
