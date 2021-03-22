package com.fr;

public class Test {
    public static void main(String[] args) {
        double[][] data = {
                {1, 2, 3}
        };
        var matrix1 = new Matrix(data);
        var matrix2 = matrix1.transpose();
        System.out.println(matrix1.mul(matrix2));
    }
}