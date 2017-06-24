package lv.javaguru.java2.domain.customer;

import lv.javaguru.java2.services.validators.Phone;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vijai3D on 14.05.2017.
 */
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name field can't be empty!")
    @Size(min=2, max=30, message = "Name is too short!")
    private String name;

    @NotNull(message = "Can't be empty!")
    @Email(message = "Email is not correctly entered")
    private String email;
    @NotNull
    @Phone(message = "Phone number is incorrect. Valid formats are 1234567890, 123-456-7890 x1234")
    private String phone;

    @NotNull(message = "Can't be empty!")
    @Size(min=2, max=145, message = "Address is incorrect!")
    private String address;

    @NotNull(message = "Can't be empty!")
    @Size(min=2, max=45, message = "City is incorrect!")
    private String city;

    @NotNull(message = "Can't be empty!")
    @Size(min=2, max=45, message = "Country name is incorrect!")
    private String country;

    @Column(name = "password", length = 60)
    @NotNull(message = "Can't be empty!")
    private String password;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval=true)
    private List<CustomerOrder> customerOrderList;

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address, String city, String country, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
