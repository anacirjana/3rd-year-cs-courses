package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int n=0,m=0;
        int[][] matrix1,matrix2;
        matrix1 = new int[10][10];
        matrix2 = new int[10][10];
        String fileName = "Matrix.in";
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            String[] values = line.split(" ");
            n = Integer.parseInt(values[0]);
            m = Integer.parseInt(values[1]);

            for(int i = 0; i < n; i ++) {
                if((line = bufferedReader.readLine()) != null) {
                    String[] vals = line.split(" ");
                    for(int j = 0; j < vals.length; j ++) {
                        matrix1[i][j] = Integer.parseInt(vals[j]);
                    }
                }
            }
            for(int i = 0; i < n; i ++) {
                    if((line = bufferedReader.readLine()) != null) {
                        String[] vals = line.split(" ");

                        for (int j = 0; j < vals.length; j++) {
                            matrix2[i][j] = Integer.parseInt(vals[j]);
                        }
                    }
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }


        int nrThreads = 4,pace = 3;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j]);
            }
            System.out.println("\n");
        }

        Thread[] threads = new Thread[nrThreads];
        for(Thread t : threads) {
            t = new MatrixAdditionThread(n,m,matrix1,matrix2);
            t.run();
        }
    }
}
