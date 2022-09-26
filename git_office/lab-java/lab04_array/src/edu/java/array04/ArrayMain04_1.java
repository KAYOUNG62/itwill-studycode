package edu.java.array04;

public class ArrayMain04_1 {

    public static void main(String[] args) {
        // 200페이지 연습문제 4
        int max = 0;
        int[] array = { 1, 5, 3, 8, 2 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max = " + max);

        
        System.out.println("-----------------------");
        
        // 5
        int[][] array2 = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

        int sum = 0;
        double avg = 0.0; // double

        int n = 0;
        for (int x = 0; x <array2.length; x++) {
            for (int s = 0; s <array2[x].length; s++) {
                sum += array2[x][s];
                n += 1; 
            }
        }
        avg = (double) sum / n; 
        
        
        System.out.println("sum : " + sum);
        System.out.println("avg : " + avg);

    }

}
