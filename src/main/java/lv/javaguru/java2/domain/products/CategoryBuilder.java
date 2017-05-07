package lv.javaguru.java2.domain.products;

import java.util.Collection;
import java.util.List;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public final class CategoryBuilder {
    private Short categoryId;
    private String categoryName;
    private Collection<Product> products;

    private CategoryBuilder() {
    }

    public static CategoryBuilder createCategory() {
        return new CategoryBuilder();
    }

    public CategoryBuilder withCategoryId(Short categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public CategoryBuilder withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public CategoryBuilder withProducts(Collection<Product> products) {
        this.products = products;
        return this;
    }

    public Category build() {
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setProductCollection(products);
        return category;
    }
}
