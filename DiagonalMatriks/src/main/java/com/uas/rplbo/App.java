package com.uas.rplbo;

import java.io.*;

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\EDWIN\\KULIAH\\SEMESTER 4\\PRAK RPLBO\\TAS-71200541\\DiagonalMatriks\\soal.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int n = Integer.parseInt(line);
            int x = 0;
            if (x < n) {
                do {
                    int total = 0;
                    line = br.readLine();
                    String[] arr = line.split(" ");
                    if (arr.length != 2 || !arr[0].equals(arr[1])) {
                        System.out.println("-1");
                        int j = 0;
                        if (j < Integer.parseInt(arr[0])) {
                            do {
                                br.readLine();
                                j += 1;
                            } while (j < Integer.parseInt(arr[0]));
                        }
                    } else {
                        int index = 0;

                        int j = 0;
                        if (j < Integer.parseInt(arr[0])) {
                            do {
                                line = br.readLine();
                                String[] arr2 = line.split(" ");

                                total += Integer.parseInt(arr2[index]);
                                index += 1;
                                j++;
                            } while (j < Integer.parseInt(arr[0]));
                        }
                        System.out.println(total);
                    }
                    x++;
                } while (x < n);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan!");
            e.printStackTrace();
        }
    }
}
