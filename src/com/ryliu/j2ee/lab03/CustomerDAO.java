package com.ryliu.j2ee.lab03;

import com.mysql.jdbc.CallableStatement;
import com.ryliu.j2ee.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    public CustomerDAO() {

    }

    /**
     * Insert the element into database.
     *
     * @param customer the element
     * @throws SQLException if any SQL error occurred.
     */
    public void insert(Customer customer) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement("INSERT INTO customer_information VALUES(?, ?, ?, ?, ?)");
            setProperties(customer);
            statement.executeUpdate();
        } finally {
            close();
        }
    }

    /**
     * Delete the customer according to its cid.
     *
     * @param cid the cid
     * @throws SQLException if any SQL error occurred.
     */
    public void delete(String cid) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement("DELETE FROM customer_information WHERE cid = ?");
            statement.setString(1, cid);
            statement.executeUpdate();
        } finally {
            close();
        }
    }

    /**
     * Get the customer according to its cid.
     *
     * @return the customer
     * @throws SQLException if any SQL error occurred.
     */
    public Customer get(String cid) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            Customer customer = null;
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM customer_information WHERE cid = ?");
            statement.setString(1, cid);
            result = statement.executeQuery();
            if (result.next()) {
                customer = getProperties();
            }
            return customer;
        } finally {
            close();
        }
    }

    /**
     * List all customers.
     *
     * @return the list of customers
     * @throws SQLException if any SQL error occurred.
     */
    public List<Customer> list() throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            List<Customer> list = new ArrayList<Customer>();
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement("SELECT * FROM customer_information");
            result = statement.executeQuery();
            while (result.next()) {
                Customer customer = getProperties();
                list.add(customer);
            }
            return list;
        } finally {
            close();
        }
    }

    /**
     * Update the customer.
     *
     * @param customer the customer to update
     * @throws SQLException if any SQL error occurred.
     */
    public void update(Customer customer) throws SQLException {
        connection = null;
        statement = null;
        result = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareCall("UPDATE customer_information SET cid = ?, cname = ?, phone = ?, mobile = ?, address = ? WHERE cid = ?");
            setProperties(customer);
            statement.setString(6, customer.getCid());
            statement.executeUpdate();
        } finally {
            close();
        }
    }

    private void setProperties(Customer customer) throws SQLException {
        statement.setString(1, customer.getCid());
        statement.setString(2, customer.getCname());
        statement.setString(3, customer.getPhone());
        statement.setString(4, customer.getMobile());
        statement.setString(5, customer.getAddress());
    }

    private Customer getProperties() throws SQLException {
        Customer customer = new Customer();
        customer.setCid(result.getString(1));
        customer.setCname(result.getString(2));
        customer.setPhone(result.getString(3));
        customer.setMobile(result.getString(4));
        customer.setAddress(result.getString(5));
        return customer;
    }

    /**
     * Close all the resources.
     */
    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // ignore
        }
    }
}
