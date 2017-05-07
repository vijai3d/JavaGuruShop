package lv.javaguru.java2.database.jdbc.product;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Victor on 24.03.2017.
 */
@Component
public class CategoryDAOIMmpl extends DAOImpl implements CategoryDAO{
    public void test() {
        System.out.println("test");
    }
    @Override
    public Category save(Category category) throws DBException {
        System.out.println("im in CDI save");
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert INTO category VALUES(default, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getCategoryName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                category.setCategoryId(rs.getShort(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return category;
    }

    @Override
    public Optional<Category> getById(Short id) {
        return null;
    }

    @Override
    public void delete(Short id) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public List<Category> getAll() throws DBException {
        System.out.println("we are in CDI.getAll");
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getShort("id"));
                category.setCategoryName(resultSet.getString("name"));
                categories.add(category);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CategoryDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return categories;
    }
}
