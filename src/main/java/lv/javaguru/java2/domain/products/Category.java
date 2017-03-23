package lv.javaguru.java2.domain.products;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class Category {

    private int CategoryId;
    private String categoryName;
    private List<Product> products;

    public Category() {
        this.products = new ArrayList<>();
    }

    public Category(String categoryName) {
        this();
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", products=" + products +
                '}';
    }
}
