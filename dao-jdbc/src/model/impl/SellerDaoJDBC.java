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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
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

        try {

            st = conn.prepareStatement(
                    "SELECT seller.*, department.name AS depname "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.departmentid = department.id "
                            + "WHERE seller.id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) { // pro rs ver se tem algum resultado, pois qnd começa o rs aponta pro 0 e os valores começa no 1
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);

                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                    + "FROM seller "
                    + "INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.DepartmentId = ? "
                    + "ORDER BY seller.Name;"
            );

            st.setInt(1, department.getId());
            rs = st.executeQuery();


            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) { // pro rs ver se tem algum resultado, pois qnd começa o rs aponta pro 0 e os valores começa no 1

                // Retorna null se não existir e se existir não cria um igual
                Department dep = map.get(rs.getInt("departmentid"));

                if(dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("departmentid"), dep);
                }
                Seller obj = instantiateSeller(rs, dep);

                list.add(obj);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
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
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                            + "FROM seller "
                            + "INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY seller.Name;"
            );

            rs = st.executeQuery();


            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) { // pro rs ver se tem algum resultado, pois qnd começa o rs aponta pro 0 e os valores começa no 1

                // Retorna null se não existir e se existir não cria um igual
                Department dep = map.get(rs.getInt("departmentid"));

                if(dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("departmentid"), dep);
                }
                Seller obj = instantiateSeller(rs, dep);

                list.add(obj);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
