package lv.javaguru.java2.domain.products;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vijai3D on 23.03.2017.
 */
@Entity
@Proxy(lazy = false)
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Short categoryId;

    @Column(name = "name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<Product> productCollection;

    public Category() {

    }

    public Category(Short categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Short categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
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

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
