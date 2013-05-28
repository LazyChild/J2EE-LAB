package com.ryliu.j2ee.lab03;

import com.ryliu.j2ee.utils.ConnectionFactory;
import com.ryliu.j2ee.utils.Helper;

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
            Helper.setStatement(customer, statement);
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
            statement = connection.prepareStatement("DELETE FROM customer_information WHERE cid = " + cid);
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
            statement = connection.prepareStatement("SELECT * FROM customer_information WHERE cid = " + cid);
            result = statement.executeQuery();
            if (result.next()) {
                customer = Helper.getResult(Customer.class, result);
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
                Customer customer = Helper.getResult(Customer.class, result);
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
            statement = connection.prepareCall("UPDATE customer_information SET cid = ?, cname = ?, phone = ?, mobile = ?, address = ? WHERE cid = " + customer.getCid());
            Helper.setStatement(customer, statement);
            statement.executeUpdate();
        } finally {
            close();
        }
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
                result.close();
            }
        } catch (SQLException e) {
            // ignore
        }
    }
}
