package org.shaikhabdulgani.comparison;

import lombok.*;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private long salary;

    @Override
    public int compareTo(Employee o) {
        return this.id - o.getId();
    }
}
