package com.pluralsight.payroll;

    import java.util.ArrayList;

    public class TimeCard {

        static class Employee {
            private int employeeId;
            private String name;
            private double hoursWorked;
            private double payRate;

            // Constructor to initialize an Employee object
            Employee(int employeeId, String name, double hoursWorked, double payRate) {
                this.employeeId = employeeId;
                this.name = name;
                this.hoursWorked = hoursWorked;
                this.payRate = payRate;
            }

            // Getter methods
            public int getEmployeeId() {
                return employeeId;
            }

            public String getName() {
                return name;
            }

            public double getHoursWorked() {
                return hoursWorked;
            }

            public double getPayRate() {
                return payRate;
            }

            public double calculatePay() {
                return hoursWorked * payRate;
            }
        }

        public static void main(String[] args) {
            ArrayList<Employee> employees = new ArrayList<>(); // Created an ArrayList

            // Add employees into the ArrayList
            employees.add(new Employee(10, "Dana Wyatt", 52, 12.50));
            employees.add(new Employee(60, "Zane Stephens", 45, 13.50));
            employees.add(new Employee(80, "Kamari Todd", 32, 14.50));

            // Print the payroll details
            System.out.println("Payroll Details:");
            for (Employee emp : employees) {
                System.out.printf("ID: %d, Name: %s, Hours: %.1f, Pay Rate: $%.2f, Total Pay: $%.2f%n",
                        emp.getEmployeeId(), emp.getName(), emp.getHoursWorked(), emp.getPayRate(), emp.calculatePay());
            }
        }
    }
