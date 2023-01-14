package org.testmdm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testmdm.Moves;
import org.testmdm.RelativeCircle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovesTest {
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void main() {
        ArrayList<String[]> masTest = new ArrayList<>();
        masTest.add(new String[]{"task4/src/test/resources/test.txt", "16\n"});
        masTest.add(new String[]{"task4/src/test/resources/test1.txt", "5\n"});
        masTest.add(new String[]{"task4/src/test/resources/test2.txt", "2\n"});
        masTest.add(new String[]{"task4/src/test/resources/test3.txt", "5\n"});
        masTest.add(new String[]{null, "Error opening file\n"});
        masTest.add(new String[]{"task4/src/test/resources/test2t", "Error opening file\n"});
        masTest.add(new String[]{"task4/src/test/resources/test4.txt", "Element is not a number\n"});
        masTest.add(new String[]{"task4/src/test/resources/test5.txt", "0\n"});
        for (String[] mas: masTest) {
            Moves.main(mas);
            assertEquals(mas[1], outputStream.toString(), "Errors ");
            outputStream.reset();
        }
    }

    @AfterAll
    public static void returnOutputStream() {
        System.setOut(originalOut);
    }

}
