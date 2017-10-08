package com.company;

/**
 * Created by Ana Cirjan on 08.10.2017.
 */
public class MatrixAdditionThread extends Thread {
    private int[][] matrix1, matrix2, resMatrix;
    private int n,m;

    public MatrixAdditionThread (int n, int m,int[][] mat1, int[][] mat2) {
        this.n = n;
        this.m = m;
        this.matrix1 = mat1;
        this.matrix2 = mat2;
    }

    @Override
    public void run() {
        System.out.println("thread starts");
        //do stuff
    }
}
