package aplicacao;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                    + "WHERE "
                    + "id = ?"
            );

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate(); // qnts linhas foram alteradas no banco

            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {

            DB.closeStatement(st);
            DB.closeConnection(); // sempre fecha a conexão por ultimo!
        }
    }
}