package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.products.Product;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;

/**
 * Created by Vijai3D on 17.06.2017.
 */
@Entity
@Table(name="pictures")
public class Pictures {
    private long id;
    private byte[] imageData;
    private String encodedData;
    private String name;
    private Integer prymary;
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "image_data", nullable = false)
    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] name) {
        this.imageData = name;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "prymary", nullable = true)
    public Integer getPrymary() {
        return prymary;
    }

    @Basic
    @Column(name="encoded_data", nullable = false)
    public String getEncodedData() {
        return encodedData;
    }

    public void setEncodedData(String encodedData) {
        this.encodedData = encodedData;
    }

    public void setPrymary(Integer prymary) {
        this.prymary = prymary;
    }

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pictures pictures = (Pictures) o;

        return product != null ? product.equals(pictures.product) : pictures.product == null;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
}
