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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cs4347.jdbcProject.ecomm.dao.CustomerDAO;
import cs4347.jdbcProject.ecomm.entity.Customer;
import cs4347.jdbcProject.ecomm.util.DAOException;

public class CustomerDaoImpl implements CustomerDAO {
	
	private static final String createSQL = "INSERT INTO customer (first_name, last_name, dob, gender, email) VALUES (?, ?, ?, ?, ?);";

	@Override
	public Customer create(Connection connection, Customer customer) throws SQLException, DAOException {
		if (customer.getId() != null) {
			throw new DAOException("Trying to insert Customer with NON-NULL ID");
		}

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(createSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setDate(3, customer.getDob());
			ps.setString(4, String.valueOf(customer.getGender()));
			ps.setString(5, customer.getEmail());
			ps.executeUpdate();

			// Copy the assigned ID to the customer instance.
			ResultSet keyRS = ps.getGeneratedKeys();
			keyRS.next();
			int lastKey = keyRS.getInt(1);
			customer.setId((long) lastKey);
			return customer;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	final static String selectSQL = "SELECT id, first_name,last_name,gender, dob, email FROM customer WHERE id = ?";

	@Override
	public Customer retrieve(Connection connection, Long id) throws SQLException, DAOException {
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

			Customer cust = new Customer();
			cust.setId(rs.getLong("id"));
			cust.setFirstName(rs.getString("first_name:"));
			cust.setLastName(rs.getString("last_name"));
			cust.setGender(rs.getString("gender").charAt(0));
			cust.setDob(rs.getDate("dob"));
			cust.setEmail(rs.getString("email"));
			return cust;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	final static String updateSQL = "UPDATE customer SET first_name = ?, last_name=?, gender=?,dob=?,email=? WHERE id=?";

	@Override
	public int update(Connection connection, Customer customer) throws SQLException, DAOException {
		Long id = customer.getId();
		if (id == null) {
			throw new DAOException("Trying to UPDATE customer with NULL ID");
		}
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(updateSQL);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, String.valueOf(customer.getGender()));
			ps.setDate(4, customer.getDob());
			ps.setString(5, customer.getEmail());
			ps.setLong(6, id);

			int rows = ps.executeUpdate();
			return rows;
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
	}

	final static String deleteSQL = "DELETE FROM customer WHERE id= ?";

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

	final static String selectZIP = "SELECT * FROM customer WHERE zipcode = ?";
	
	@Override
	public List<Customer> retrieveByZipCode(Connection connection, String zipCode) throws SQLException, DAOException {
		// TODO CODE
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(selectZIP);
			ps.setString(1,  zipCode);
			ResultSet rs = ps.executeQuery();
			
			
			
			
		} finally {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
		
		return null;
	}

	@Override
	public List<Customer> retrieveByDOB(Connection connection, Date startDate, Date endDate)
			throws SQLException, DAOException {
		
		return null;
	}

}
