package aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main (String[] args){

        Connection conn = null;
        Statement st = null; // Consulta
        ResultSet rs = null; // Resultado da consulta
        try{

            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM department");

            while(rs.next()){
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
