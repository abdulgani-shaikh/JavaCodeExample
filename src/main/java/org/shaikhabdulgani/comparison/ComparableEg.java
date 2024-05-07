package org.shaikhabdulgani.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEg {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(4,"Shaikh Abdul Gani",3_60_000_00));
        employees.add(new Employee(2,"Hemil",3_30_000_00));
        employees.add(new Employee(1,"Gaurav",3_50_000_00));
        employees.add(new Employee(5,"Amey",3_10_000_00));

        print(employees);

        //by default id will be used to sort the employees
        Collections.sort(employees);

        print(employees);

    }

    static void print(List<Employee> list) {
        System.out.println("{ ");
        for (Employee o : list) {
            System.out.println(o);
        }
        System.out.println(" }");
    }
}
