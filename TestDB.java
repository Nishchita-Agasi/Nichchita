package employeeJDBCapp;


import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            DBConnection.closeConnection(conn);
        }
    }
}
