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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cs4347.jdbcProject.ecomm.dao.PurchaseDAO;
import cs4347.jdbcProject.ecomm.entity.Product;
import cs4347.jdbcProject.ecomm.entity.Purchase;
import cs4347.jdbcProject.ecomm.services.PurchaseSummary;
import cs4347.jdbcProject.ecomm.util.DAOException;

public class PurchaseDaoImpl implements PurchaseDAO {

	private static final String createSQL = "INSERT INTO purchase (product, customer, purchaseDate, purchaseAmount) VALUES (?, ?, ?, ?);";

	@Override
	public Purchase create(Connection connection, Purchase purchase) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		if (purchase.getId() != null) {
			throw new DAOException("Trying to insert Customer with NON-NULL ID");
		}

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(createSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, purchase.getProductID());
			ps.setLong(2, purchase.getCustomerID());
			ps.setDate(3, purchase.getPurchaseDate());
			ps.setFloat(4, (float) purchase.getPurchaseAmount());
			ps.executeUpdate();

			// Copy the assigned ID to the customer instance.
			ResultSet keyRS = ps.getGeneratedKeys();
			keyRS.next();
			int lastKey = keyRS.getInt(1);
			purchase.setId((long) lastKey);
			return purchase;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	
		
	}

	@Override
	public Purchase retrieve(Connection connection, Long id) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Connection connection, Purchase purchase) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection connection, Long id) throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Purchase> retrieveForCustomerID(Connection connection, Long customerID)
			throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> retrieveForProductID(Connection connection, Long productID)
			throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseSummary retrievePurchaseSummary(Connection connection, Long customerID)
			throws SQLException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
