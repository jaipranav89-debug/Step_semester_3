package StackAndQueue.class_problems;

import java.util.Scanner;

public class MaximizeContainerArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int area = height * (right - left);

            if (area > maxArea) {
                maxArea = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(maxArea);
    }
}