package com.pluralsight.calculator;

public class Employee {
    // Private attributes of the Employee class
    private int employeeId;  // Employee ID
    private String name;      // Employee Name
    private double hoursWorked; // Hours worked by the employee
    private double payRate;     // Pay rate of the employee

    // Parameterized constructor to initialize the employee attributes

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Getter for employee ID
    public int getEmployeeId() {
        return employeeId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for hours worked
    public double getHoursWorked() {
        return hoursWorked;
    }

    // Getter for pay rate
    public double getPayRate() {
        return payRate;
    }

    // Method to calculate gross pay
    public double getGrossPay() {
        return hoursWorked * payRate; // Calculate gross pay
    }
}