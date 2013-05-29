package com.ryliu.j2ee.lab03;

import com.ryliu.j2ee.labfinal.services.AbstractDAO;
import com.ryliu.j2ee.labfinal.services.RowCallbackHandler;
import com.ryliu.j2ee.labfinal.services.StatementSetter;
import com.ryliu.j2ee.utils.Helper;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> {

    /**
     * Insert the element into database.
     *
     * @param customer the element
     * @throws SQLException if any SQL error occurred.
     */
    public void insert(final Customer customer) throws SQLException {
        String sql = "INSERT INTO customer_information VALUES(?, ?, ?, ?, ?)";
        executeUpdate(sql, new StatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int index = 0;
                ps.setString(++index, customer.getCid());
                ps.setString(++index, customer.getCname());
                ps.setString(++index, customer.getPhone());
                ps.setString(++index, customer.getMobile());
                ps.setString(++index, customer.getAddress());
            }
        });
    }

    /**
     * Delete the customer according to its cid.
     *
     * @param cid the cid
     * @throws SQLException if any SQL error occurred.
     */
    public void delete(String cid) throws SQLException {
        String sql = "DELETE FROM customer_information WHERE cid = " + cid;
        executeUpdate(sql, null);
    }

    /**
     * Get the customer according to its cid.
     *
     * @return the customer
     * @throws SQLException if any SQL error occurred.
     */
    public Customer get(String cid) throws SQLException {
        final Customer customer = new Customer();
        String sql = "SELECT * FROM customer_information WHERE cid = " + cid;
        executeQuery(sql, null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                generateFromResult(customer, resultSet);
            }
        });
        return customer;
    }

    /**
     * List all customers.
     *
     * @return the list of customers
     * @throws SQLException if any SQL error occurred.
     */
    public List<Customer> list() throws SQLException {
        final List<Customer> list = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer_information";
        executeQuery(sql, null, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Customer customer = new Customer();
                generateFromResult(customer, resultSet);
                list.add(customer);
            }
        });
        return list;
    }

    /**
     * Update the customer.
     *
     * @param customer the customer to update
     * @throws SQLException if any SQL error occurred.
     */
    public void update(final Customer customer) throws SQLException {
        String sql = "UPDATE customer_information SET cname = ?, phone = ?, mobile = ?, address = ? WHERE cid = ?";
        executeUpdate(sql, new StatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int index = 0;
                ps.setString(++index, customer.getCname());
                ps.setString(++index, customer.getPhone());
                ps.setString(++index, customer.getMobile());
                ps.setString(++index, customer.getAddress());
                ps.setString(++index, customer.getCid());
            }
        });
    }

    /**
     * Generate from result set.
     *
     * @param resultSet the result set
     * @param customer the customer
     * @throws SQLException if any issue occurred.
     */
    private static void generateFromResult(Customer customer, ResultSet resultSet) throws SQLException {
        customer.setCid(resultSet.getString("cid"));
        customer.setCname(resultSet.getString("cname"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setMobile(resultSet.getString("mobile"));
        customer.setAddress(resultSet.getString("address"));
    }

    /**
     * Generate from request.
     *
     * @param request the HTTP request
     * @return the instance
     */
    @Override
    public Customer generateFromRequest(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setCid(Helper.getParameter(request, "cid"));
        customer.setCname(Helper.getParameter(request, "cname"));
        customer.setPhone(Helper.getParameter(request, "phone"));
        customer.setMobile(Helper.getParameter(request, "mobile"));
        customer.setAddress(Helper.getParameter(request, "address"));
        return customer;
    }
}
