package application.entities;

import application.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> hourContractList = new ArrayList<>();

    public Worker() {}

    public Worker(String name, WorkerLevel level, Double baseSalary, String department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = new Department(department);
    }

    public void addContract(HourContract contract){
        hourContractList.add(contract);
    }

    public void removeContract(HourContract contract){
        hourContractList.remove(contract);
    }

    public Double income(Integer year, Integer month){

        Double total = baseSalary;
        for(HourContract aux : hourContractList){
            if(aux.getDate().getYear() == year && aux.getDate().getMonthValue() == month)
                total += aux.totalValue();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String toString(){
        return "Name: " + name + "\n" +
                "Department: " + department.getName();
    }
}
