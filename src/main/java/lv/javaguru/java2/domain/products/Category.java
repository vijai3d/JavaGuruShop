package lv.javaguru.java2.domain.products;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by Vijai3D on 23.03.2017.
 */
@Entity
public class Category {

    private Short categoryId;
    private String categoryName;
    //private Collection<Product> productCollection;

    public Category() {

    }

    public Category(Short categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Short categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }*/
    @Override
    public String toString() {
        return "entity.Category[id=" + categoryId + "]";
    }

}
