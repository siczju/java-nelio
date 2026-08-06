package aplicacao;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        try {

            conn = DB.getConnection();
            st = conn.createStatement();
            conn.setAutoCommit(false); // não é para confirmar as operações sql automaticamente
                                        // agora todas operações vao ficar pendentes de uma confirmação


            int rows1 = st.executeUpdate("UPDATE seller SET basesalary = 2090 WHERE departmentid = 1");

            /*
            int x = 1;
            if(x < 2){
                throw new SQLException("Fake error");
            }
            */


            int rows2 = st.executeUpdate("UPDATE seller SET basesalary = 3090 WHERE departmentid = 2");

            conn.commit();

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback(); // voltar ao estado inicial do banco
                throw new DbException("Transaction  rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection(); // sempre fecha a conexão por ultimo!
        }
    }
}