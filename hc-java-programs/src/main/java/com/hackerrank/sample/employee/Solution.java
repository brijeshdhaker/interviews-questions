package com.hackerrank.sample.employee;

import java.util.*;

abstract class Employee {

    abstract void setSalary(int salary);

    abstract int getSalary();

    abstract void setGrade(String grade);

    abstract String getGrade();

    public void label() {
        System.out.println("Employee's data:");
    }

}

class Engineer extends Employee {

    private int salary;
    private String grade;

    Engineer() {

    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getSalary() {
        return this.salary;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }

    String getGrade() {
        return this.grade;
    }

}

class Manager extends Employee {

    private int salary;
    private String grade;

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getSalary() {
        return this.salary;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }

    String getGrade() {
        return this.grade;
    }

}

public class Solution {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String sub = sc.nextLine();
        //int n = Integer.parseInt(sub);
        List<String> data = new ArrayList<>();
        data.add("ENGINEER A 10000");
        data.add("MANAGER B 8000");
        for (int i = 0; i < data.size(); i++) {
            String[] input = data.get(i).split(" ");
            if (input[0].equals("ENGINEER")) {
                Engineer e = new Engineer();
                e.setSalary(Integer.parseInt(input[2]));
                e.setGrade(input[1]);
                e.label();
                System.out.println("GRADE : " + e.getGrade());
                System.out.println("SALARY : " + e.getSalary());
            }
            if (input[0].equals("MANAGER")) {
                Manager e = new Manager();
                e.setSalary(Integer.parseInt(input[2]));
                e.setGrade(input[1]);
                e.label();
                System.out.println("GRADE : " + e.getGrade());
                System.out.println("SALARY : " + e.getSalary());
            }
        }
    }
}
