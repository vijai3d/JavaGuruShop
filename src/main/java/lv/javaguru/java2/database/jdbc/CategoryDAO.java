package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */

public interface CategoryDAO {
    Category save(Category category);

    Category findById(Short id);

    void delete(Short id);

    void update(Category category);

    List<Category> getAll();


}

@Component
class CategoryDAOIMmpl extends DAOImpl implements CategoryDAO{

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
                category.setCategoryId(rs.getByte(1));
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
    public Category findById(Short categoryId) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from category where id = ?");
            preparedStatement.setShort(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category = null;
            if (resultSet.next()) {
                category = new Category();
                category.setCategoryId(resultSet.getByte("id"));
                category.setCategoryName(resultSet.getString("name"));

            }
            return category;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Short id) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public List<Category> getAll() throws DBException {

        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getByte("id"));
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