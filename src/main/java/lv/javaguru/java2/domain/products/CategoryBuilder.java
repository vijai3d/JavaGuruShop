package lv.javaguru.java2.domain.products;

import java.util.List;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public final class CategoryBuilder {
    private int CategoryId;
    private String categoryName;
    private List<Product> products;

    private CategoryBuilder() {
    }

    public static CategoryBuilder createCategory() {
        return new CategoryBuilder();
    }

    public CategoryBuilder withCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
        return this;
    }

    public CategoryBuilder withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public CategoryBuilder withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Category build() {
        Category category = new Category();
        category.setCategoryId(CategoryId);
        category.setCategoryName(categoryName);
        category.setProducts(products);
        return category;
    }
}
