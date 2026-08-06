package aplicacao;

import db.DB;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main (String[] args){

        Connection conn = null;
        PreparedStatement st = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(name, email, birthdate, basesalary, departmentid)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS // para retornar a chave primaria criada
            );

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, java.sql.Date.valueOf(LocalDate.parse("22/04/1985", dtf)));
            st.setDouble(4, 3000);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate(); // qnts linhas foram alteradas no banco

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys(); // chave primaria vai pro ResultSet, com um ou mais chaves
                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! ID: " + id);
                }


            }
            else{
                System.out.println("No Rows Affected");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection(); // sempre fecha a conexão por ultimo!
        }

    }
}
