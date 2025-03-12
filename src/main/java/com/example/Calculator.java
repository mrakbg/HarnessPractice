package com.example;

import java.util.Scanner;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Calculator App is running...");

        while (true) {
            try {
                System.out.print("\nEnter first number (or type 'exit' to quit): ");
                if (!scanner.hasNext()) {  // Prevents crashing when no input
                    Thread.sleep(5000); // Waits for input
                    continue;
                }

                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting Calculator...");
                    break;
                }

                int a = Integer.parseInt(input);  // Convert input to integer
                System.out.print("Enter second number: ");
                int b = scanner.nextInt();

                System.out.println("Addition: " + calc.add(a, b));
                System.out.println("Subtraction: " + calc.subtract(a, b));
                System.out.println("Multiplication: " + calc.multiply(a, b));
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();  // Clear input buffer
            }
        }
        scanner.close();
    }
}
