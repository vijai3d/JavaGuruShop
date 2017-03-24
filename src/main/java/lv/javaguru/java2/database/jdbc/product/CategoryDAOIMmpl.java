package lv.javaguru.java2.database.jdbc.product;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;

import java.sql.*;

/**
 * Created by Victor on 24.03.2017.
 */
public class CategoryDAOIMmpl extends DAOImpl implements CategoryDAO {
    @Override
    public Category save(Category category) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert INTO category VALUES(default, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getCategoryName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                category.setCategoryId(rs.getInt(1));
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
}
