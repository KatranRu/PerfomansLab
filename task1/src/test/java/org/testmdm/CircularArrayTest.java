package org.testmdm;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CircularArrayTest {

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(outputStream));

    }


    @AfterAll
    public static void returnOutputStream() {
        System.setOut(originalOut);
    }

    @Test
    void main() {
        ArrayList<String[]> masTest = new ArrayList<>();
        masTest.add(new String[]{"4", "3", "13\n"});
        masTest.add(new String[]{"5", "4", "14253\n"});
        masTest.add(new String[]{"asd", "3", "First argument is not an integer\nError initialization\n"});
        masTest.add(new String[]{"4", "adas", "The second argument is not an integer\nError initialization\n"});
        masTest.add(new String[]{"asd", "asd", "First argument is not an integer\nThe second argument is not an integer\nError initialization\n"});
        masTest.add(new String[]{"0", "3", "Not circular array\n"});
        masTest.add(new String[]{"3", "0", "Interval is zero\n"});
        masTest.add(new String[]{"4", "-3", "13\n"});
        masTest.add(new String[]{"5", "-4", "13524\n"});
        masTest.add(new String[]{null, null, "First argument is not an integer\nThe second argument is not an integer\nError initialization\n"});
        for (int i = 0; i < 10; i++) {
            CircularArray.main(masTest.get(i));
            assertEquals(masTest.get(i)[2], outputStream.toString(), "Errors ");
            outputStream.reset();
        }
    }
    @Test
    public void tes(String[] a, String s) {

    }
}