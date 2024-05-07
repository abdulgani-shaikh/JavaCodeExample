package org.shaikhabdulgani.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEg {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(4,"Shaikh Abdul Gani",3_60_000_00));
        employees.add(new Employee(2,"Hemil",3_30_000_00));
        employees.add(new Employee(1,"Gaurav",3_50_000_00));
        employees.add(new Employee(5,"Amey",3_10_000_00));

        print(employees);

        //sort by name
        employees.sort(new NameComparator());
        System.out.println("-------Sort By Name-------");
        print(employees);

        //sort by salary using lambda as Comparator class is Functional Interface
        employees.sort((o1, o2) -> Math.toIntExact(o1.getSalary() - o2.getSalary()));
        System.out.println("-------Sort By Salary-------");
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

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
