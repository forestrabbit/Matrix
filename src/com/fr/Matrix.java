package com.fr;

public class Matrix {
    private final double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
    }

    public double[][] getData() {
        return data;
    }

    public Matrix add(Matrix matrix) {
        if (data.length != matrix.data.length || data[0].length != matrix.data[0].length) {
            throw new IllegalArgumentException("只有同型矩阵才能相加");
        }
        Matrix ans = new Matrix(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                ans.data[i][j] += matrix.data[i][j];
            }
        }
        return ans;
    }

    public Matrix sub(Matrix matrix) {
        if (data.length != matrix.data.length || data[0].length != matrix.data[0].length) {
            throw new IllegalArgumentException("只有同型矩阵才能相减");
        }
        Matrix ans = new Matrix(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                ans.data[i][j] -= matrix.data[i][j];
            }
        }
        return ans;
    }

    public Matrix mul(Matrix matrix) {
        if (data.length != matrix.data[0].length || data[0].length != matrix.data.length) {
            throw new IllegalArgumentException("矩阵不能相乘");
        }
        double[][] temp = new double[data.length][matrix.data[0].length];
        Matrix ans = new Matrix(temp);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < matrix.data[0].length; j++) {
                for (int k = 0; k < data[0].length; k++) {
                    ans.data[i][j] += data[i][k] * matrix.data[k][j];
                }
            }
        }
        return ans;
    }

    public Matrix transpose() {
        double[][] temp = new double[data[0].length][data.length];
        Matrix ans = new Matrix(temp);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                ans.data[j][i] = data[i][j];
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (var x: data) {
            for (var element: x) {
                builder.append(element).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}