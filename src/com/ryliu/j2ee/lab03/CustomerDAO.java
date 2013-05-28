package com.ryliu.j2ee.lab03;

import com.ryliu.j2ee.labfinal.services.AbstractDAO;
import com.ryliu.j2ee.labfinal.services.RowCallbackHandler;
import com.ryliu.j2ee.utils.Helper;

import javax.servlet.http.HttpServletRequest;
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
    public void insert(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer_information VALUES(?, ?, ?, ?, ?)";
        executeUpdate(sql, new Object[]{customer.getCid(), customer.getCname(), customer.getPhone(), customer.getMobile(), customer.getAddress()});
    }

    /**
     * Delete the customer according to its cid.
     *
     * @param cid the cid
     * @throws SQLException if any SQL error occurred.
     */
    public void delete(String cid) throws SQLException {
        String sql = "DELETE FROM customer_information WHERE cid = ?";
        executeUpdate(sql, new Object[] {cid});
    }

    /**
     * Get the customer according to its cid.
     *
     * @return the customer
     * @throws SQLException if any SQL error occurred.
     */
    public Customer get(String cid) throws SQLException {
        final Customer[] customer = {null};
        String sql = "SELECT * FROM customer_information WHERE cid = ?";
        executeQuery(sql, new Object[] {cid}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                customer[0] = generateFromResult(resultSet);
            }
        });
        return customer[0];
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
        executeQuery(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Customer customer = generateFromResult(resultSet);
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
    public void update(Customer customer) throws SQLException {
        String sql = "UPDATE customer_information SET cname = ?, phone = ?, mobile = ?, address = ? WHERE cid = ?";
        executeUpdate(sql, new Object[]{customer.getCname(), customer.getPhone(), customer.getMobile(), customer.getAddress(), customer.getCid()});
    }

    /**
     * Generate from result set.
     *
     * @param resultSet the result set
     * @return the instance
     * @throws SQLException if any issue occurred.
     */
    private static Customer generateFromResult(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCid(resultSet.getString("cid"));
        customer.setCname(resultSet.getString("cname"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setMobile(resultSet.getString("mobile"));
        customer.setAddress(resultSet.getString("address"));
        return customer;
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
