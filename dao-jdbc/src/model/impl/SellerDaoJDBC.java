package model.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{

            st = conn.prepareStatement(
                   "SELECT seller.*, department.name AS depname "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.departmentid = department.id "
                    + "WHERE seller.id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){ // pro rs ver se tem algum resultado, pois qnd começa o rs aponta pro 0 e os valores começa no 1
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);

                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("id"));
        obj.setName(rs.getString("name"));
        obj.setDepartment(dep);
        obj.setEmail(rs.getString("email"));
        obj.setBasesalary(rs.getDouble("basesalary"));
        obj.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("departmentid"));
        dep.setName(rs.getString("depname"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
