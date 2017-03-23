package lv.javaguru.java2.domain.products;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public final class ProductBuilder {

    private String code;
    private String description;
    private double price;
    private Category category;
    private ProductBuilder() {
    }

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withCode() {
        this.code = code;
        return this;
    }

    public ProductBuilder withDescription() {
        this.description = description;
        return this;
    }

    public ProductBuilder withPrice() {
        this.price = price;
        return this;
    }

    public ProductBuilder withCategory() {
        this.category = category;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        return product;
    }
}
