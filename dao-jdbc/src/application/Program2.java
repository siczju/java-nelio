package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao depDAO = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1 - Department Insert");
        Department obj = new Department(null, "Informática");
        // depDAO.insert(obj);
        System.out.println("Inserted! New id = " + obj.getId());

        System.out.println("=== TEST 2 - Department Update");
        obj = new Department(5, "Tech");
        // depDAO.update(obj);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 3: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        depDAO.deleteById(id);
        System.out.println("Delete completed");

        System.out.println("=== TEST 4: findById =======");
        Department dep = depDAO.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 5: findAll =======");
        List<Department> list = depDAO.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        sc.close();

    }
}
