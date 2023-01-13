package org.testmdm;

import java.util.ArrayList;

public class CircularArray {
    public static void main(String[] args) {
        ArrayList<String[]> masTest = new ArrayList<>();
        masTest.add(new String[]{"4", "3"});
        masTest.add(new String[]{"5", "4"});
        masTest.add(new String[]{"asd", "3"});
        masTest.add(new String[]{"4", "adas"});
        masTest.add(new String[]{"asd", "asd"});
        masTest.add(new String[]{"0", "3"});
        masTest.add(new String[]{"3", "0"});
        masTest.add(new String[]{"4", "-3"});
        masTest.add(new String[]{"5", "-4"});
        Integer n = 0, m = 0;
        for (String[] mas: masTest) {
            n = initArray(mas, 0);
            m = initArray(mas, 1);
            if (null == n || null == m) {
                System.out.println("Error initialization");
            } else {
                if (0 >= n) {
                    System.out.println("Not circular array");
                } else {
                    if (0 == m) {
                        System.out.println("Interval is zero");
                    } else {
                        initArray(n, m);
                    }
                }
            }
        }
    }

    public static Integer initArray(String[] args, int i) {
        if (0 == i) {
            try {
                return Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("First argument is not an integer");
            }
        }
        if (1 == i) {
            try {
                return Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("The second argument is not an integer");
            }
        }
        return null;
    }

    public static void initArray(int n, int m) {
        int a = 1;
        int i = 1;
        int neg = 1;
        if (0 < m) {
            neg = -1;
        }
        do {
            System.out.print(0 == a % n ? 5 : a % n);
            a += (m + neg) + n * i;;
        } while (a % n != 1);
        System.out.println();
    }
}