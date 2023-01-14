package org.testmdm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Moves {
    public static void main(String[] args) {
        try {
            readFile(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: empty arguments");
        }
    }

    public static void readFile(String str) {
        BufferedReader rer;
        Integer result = 0;
        int result1 = 0, result2 = 0;
        ArrayList<Integer> mas = new ArrayList<>();
        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sred;
        String bufer;
        try {
            if (null == str) {
                throw new FileNotFoundException();
            } else {
                rer = new BufferedReader(new FileReader(str));
            }
            try {
                while ((bufer = rer.readLine()) != null) {
                    try {
                        int buf = Integer.parseInt(bufer);
                        if (max < buf) {
                            max = buf;
                        }
                        if (min > buf) {
                            min = buf;
                        }
                        mas.add(buf);
                    } catch (NumberFormatException e) {
                        result = null;
                        System.out.println("Element is not a number");
                    }
                }
                if (null != result) {
                    sred = ((max - min) / 2) + min;

                    for (Integer el : mas) {
                        result1 += Math.abs((int) Math.floor(sred) - el);
                    }
                    for (Integer el : mas) {
                        result2 += Math.abs((int) Math.ceil(sred) - el);
                    }
                    result = Math.min(result1, result2);
                    System.out.println(result);
                }
            } catch (IOException e) {
                System.out.println("Error reading file");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
        }
    }
}
