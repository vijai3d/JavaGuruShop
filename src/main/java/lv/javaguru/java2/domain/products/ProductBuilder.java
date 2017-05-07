package lv.javaguru.java2.domain.products;

import java.math.BigDecimal;

/**
 * Created by Victor on 24.03.2017.
 */
public final class ProductBuilder {
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;

    private ProductBuilder() {
    }

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        return product;
    }
}
