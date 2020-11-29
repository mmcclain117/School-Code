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

import cs4347.jdbcProject.ecomm.dao.AddressDAO;
import cs4347.jdbcProject.ecomm.entity.Address;
import cs4347.jdbcProject.ecomm.util.DAOException;

public class AddressDaoImpl implements AddressDAO {

	private static final String insertSQL = "INSERT INTO address (id, address1, address2, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?);";

	@Override
	public Address create(Connection connection, Address address, Long customerID) throws SQLException, DAOException {
		if (customerID == null) {
			throw new DAOException("Trying to insert a Null customer ID");
		}

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, customerID);
			ps.setString(2, address.getAddress1());
			ps.setString(3, address.getAddress2());
			ps.setString(4, address.getCity());
			ps.setString(5, address.getState());
			ps.setString(6, address.getZipcode());
			ps.executeUpdate();
			return address;

		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	final static String selectSQL = "SELECT address1,address2, city,state, zipcode FROM address WHERE id = ?";

	@Override
	public Address retrieveForCustomerID(Connection connection, Long customerID) throws SQLException, DAOException {
		if (customerID == null) {
			throw new DAOException("Trying to retrieve Customer with NULL ID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(selectSQL);
			ps.setLong(1, customerID);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}

			Address addr = new Address();
			addr.setAddress1(rs.getString("address1"));
			addr.setAddress2(rs.getString("address2"));
			addr.setCity(rs.getString("city"));
			addr.setState(rs.getString("state"));
			addr.setZipcode(rs.getString("zipcode"));

			return addr;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}
	
	final static String deleteSQL = "DELETE FROM address WHERE id= ?";
	
	@Override
	public void deleteForCustomerID(Connection connection, Long customerID) throws SQLException, DAOException {
		if (customerID == null) {
			throw new DAOException("Trying to DELETE a NULL customerID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(deleteSQL);
			ps.setLong(1, customerID);
			ps.executeUpdate();
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

}
