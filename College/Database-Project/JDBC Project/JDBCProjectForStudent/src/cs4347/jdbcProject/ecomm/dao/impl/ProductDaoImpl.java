/* NOTICE: All materials provided by this project, and materials derived 
 * from the project, are the property of the University of Texas. 
 * Project materials, or those derived from the materials, cannot be placed 
 * into publicly accessible locations on the web. Project materials cannot 
 * be shared with other project teams. Making project materials publicly 
 * accessible, or sharing with other project teams will result in the 
 * failure of the team responsible and any team that uses the shared materials. 
 * Sharing project materials or using shared materials will also result 
 * in the reporting of every team member to the Provost Office for academic 
 * dishonesty. 
 */

package cs4347.jdbcProject.ecomm.dao.impl;

/**
 * @author Master Ward
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cs4347.jdbcProject.ecomm.dao.ProductDAO;
import cs4347.jdbcProject.ecomm.entity.Customer;
import cs4347.jdbcProject.ecomm.entity.Product;
import cs4347.jdbcProject.ecomm.util.DAOException;

public class ProductDaoImpl implements ProductDAO {
	
	
	private static final String createSQL = "INSERT INTO product (name, description, category, upc) VALUES (?, ?, ?, ?);";
	@Override
	public Product create(Connection connection, Product product) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		if (product.getId() != null) {
			throw new DAOException("Trying to insert Customer with NON-NULL ID");
		}

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(createSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, product.getProdName());
			ps.setString(2, product.getProdDescription());
			ps.setInt(3, product.getProdCategory());
			ps.setString(4, product.getProdUPC());
			ps.executeUpdate();

			// Copy the assigned ID to the customer instance.
			ResultSet keyRS = ps.getGeneratedKeys();
			keyRS.next();
			int lastKey = keyRS.getInt(1);
			product.setId((long) lastKey);
			return product;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	final static String selectSQL = "SELECT id, name, description, category, upc FROM product WHERE id = ?";

	@Override
	public Product retrieve(Connection connection, Long id) throws SQLException, DAOException {
		if (id == null) {
			throw new DAOException("Trying to retrieve Customer with NULL ID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(selectSQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}

			Product prod = new Product();
			prod.setId(rs.getLong("id"));
			prod.setProdName(rs.getString("name:"));
			prod.setProdDescription(rs.getString("description"));
			prod.setProdCategory(rs.getInt("category"));
			prod.setProdUPC(rs.getString("upc"));
			
			return prod;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	
	final static String updateSQL = "UPDATE product SET name = ?, description=?, category=?, upc=? WHERE id=?";

	@Override
	public int update(Connection connection, Product product) throws SQLException, DAOException {
		Long id = product.getId();
		if (id == null) {
			throw new DAOException("Trying to UPDATE customer with NULL ID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(updateSQL);
			ps.setString(1, product.getProdName());
			ps.setString(2, product.getProdDescription());
			ps.setInt(3, product.getProdCategory());
			ps.setString(4, product.getProdUPC());;
			ps.setLong(6, id);

			int rows = ps.executeUpdate();
			return rows;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	
	final static String deleteSQL = "DELETE FROM product WHERE id= ?";

	@Override
	public int delete(Connection connection, Long id) throws SQLException, DAOException {
		if (id == null) {
			throw new DAOException("Trying to DELETE customer with NULL ID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(deleteSQL);
			ps.setLong(1, id);
			int rows = ps.executeUpdate();
			return rows;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	@Override
	public List<Product> retrieveByCategory(Connection connection, int category) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product retrieveByUPC(Connection connection, String upc) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
