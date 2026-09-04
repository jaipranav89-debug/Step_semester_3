package Week1.class_problems;

import java.util.Scanner;

class BMICalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] height, double[] weight) {
        for (int i = 0; i < height.length; i++) {
            double bmi = weight[i] / (height[i] * height[i]);

            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + height[i]);
            System.out.println("Weight: " + weight[i]);
            System.out.println("BMI: " + bmi);
            System.out.println("Status: " + getBmiStatus(bmi));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height: ");
            height[i] = sc.nextDouble();

            System.out.print("Enter weight: ");
            weight[i] = sc.nextDouble();
        }

        printWellnessReport(height, weight);
    }
}