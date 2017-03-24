package lv.javaguru.java2.database.jdbc.product;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.database.product.ProductDAO;
import lv.javaguru.java2.domain.products.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class ProductDAOImpl extends DAOImpl implements ProductDAO {

    public Product save(Product product) throws DBException{
        Connection connection = null;
        //set Category ne proishodit!!!!!!!!!!!
        System.out.println(product.getCategory());
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into product values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategory().getCategoryId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                product.setProductId(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return product;
    }
}
