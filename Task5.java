package com.company1;

import java.util.Scanner;

interface Calculator{
    double add(double num1,double num2);
    double subtract(double num1,double num2);
    double multiply(double num1,double num2);
    double divide(double num1,double num2);
}
class Calculations implements Calculator{

    @Override
    public double add(double num1, double num2) {
        return num1+num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1-num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1*num2;
    }

    @Override
    public double divide(double num1, double num2) {

            if (num2==0){
                throw new ArithmeticException("Division by zero is not allowed");
            }
            return num1/num2;

    }
}
public class Task5 {
    public static void main(String[] args) {
        Calculations calculations=new Calculations();
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to perform more operation: Yes/No");
            String choice=sc.next();
            if (choice.equalsIgnoreCase("Yes")) {
                System.out.println("Enter the first number: ");
                double num1 = sc.nextDouble();
                System.out.println("Enter the second number: ");
                double num2 = sc.nextDouble();

                System.out.println("1. Add" + "\n" + "2. Subtract" + "\n" + "3. Multiply" + "\n" + "4. Divide" + "\n");
                System.out.println("Enter the operation to perform: ");
                int operation = sc.nextInt();
                switch (operation) {
                    case 1 -> System.out.println("Your Result After Addition: " + calculations.add(num1, num2));
                    case 2 -> System.out.println("Your Result After Subtraction: " + calculations.subtract(num1, num2));
                    case 3 -> System.out.println("Your Result After Multiplication: " + calculations.multiply(num1, num2));
                    case 4 -> System.out.println("Your Result After Division: " + calculations.divide(num1, num2));
                    default -> System.out.println("Invalid Operations!!!");
                }
            }
            else if (choice.equalsIgnoreCase("No")){
                System.exit(0);
            }
            else {
                System.out.println("Invalid input!!!");
            }
        }
    }
}
