package aplicacao;

import db.DB;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main (String[] args){

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET basesalary = basesalary + ? " // para incrementar
                    + "WHERE "
                    + "(departmentid = ?)"
            );

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rows = st.executeUpdate();

            System.out.println("Rows affected: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
