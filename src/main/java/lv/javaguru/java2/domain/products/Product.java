package lv.javaguru.java2.domain.products;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class Product {
    private Integer productId;
    private String name;
    private BigDecimal price;
    private String description;
    private Date lastUpdate;
    private Category category;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String name, BigDecimal price, String description, Date lastUpdate) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "entity.Product[id=" + productId + "]";
    }
}
