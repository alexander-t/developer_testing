package dao;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public List<String> getCustomers()
            throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> customers = new ArrayList<String>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT name FROM customers");
            rs = ps.executeQuery();
            while (rs.next()) {
                customers.add("<li class=\"clist\"><b>"
                        + fixHtml(rs.getString("name"))
                        + "</b></li>");
            }
            return customers;
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(conn);
        }
    }

    private String fixHtml(String s) {

        // Simulates a misplaced and poorly named method that "cleans" up a string
        return s;
    }

    protected Connection getConnection() {

        // Don't care. We just need the method
        return null;
    }
}


