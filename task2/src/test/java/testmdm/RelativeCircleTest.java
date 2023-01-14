package testmdm;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testmdm.RelativeCircle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RelativeCircleTest {

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void main() {
        ArrayList<String[]> masTest = new ArrayList<>();
        masTest.add(new String[]{"task2/src/test/resources/test.txt", "task2/src/test/resources/re.txt", "1\n2\n2\n0\n"});
        masTest.add(new String[]{"task2/src/test/resources/test1.txt", "task2/src/test/resources/re.txt", "1\n2\n2\n2\n"});
        masTest.add(new String[]{"task2/src/test/resources/test2.txt", "task2/src/test/resources/re.txt", "1\n0\n2\n1\n"});
        masTest.add(new String[]{null, "task2/src/test/resources/re.txt", "Error initialization circle\n"});
        masTest.add(new String[]{"task2/src/test/resources/test2.txt", null, "Error reading file\n"});
        masTest.add(new String[]{null, null, "Error initialization circle\n"});
        masTest.add(new String[]{"task2/src/test/resources/test2t", "task2/src/test/resources/re.txt\n",
                "File open error\n" +
                        "Incorrect circle\n" +
                        "Error initialization circle\n"});
        masTest.add(new String[]{"task2/src/test/resources/test2.txt", "task2/src/test/resources/rext", "File open error\n"});
        masTest.add(new String[]{"task2/src/test/resources/test3.txt", "task2/src/test/resources/re.txt",
                "First coordinate is not an integer\n" +
                        "The second coordinate is not an integer\n" +
                        "Incorrect coordinates\n" +
                        "Incorrect circle\n" +
                        "Error initialization circle\n"});
        masTest.add(new String[]{"task2/src/test/resources/test2.txt", "task2/src/test/resources/re1.txt",
                "First coordinate is not an integer\n" +
                        "The second coordinate is not an integer\n" +
                        "Incorrect coordinates\n" +
                        "Incorrect coordinates\n" +
                        "Missing arguments to initialize coordinates\n" +
                        "Incorrect coordinates\n" +
                        "Incorrect coordinates\n" +
                        "The second coordinate is not an integer\n" +
                        "Incorrect coordinates\n" +
                        "Incorrect coordinates\n" +
                        "First coordinate is not an integer\n" +
                        "Incorrect coordinates\n" +
                        "Incorrect coordinates\n"});
        for (String[] mas: masTest) {
            RelativeCircle.main(mas);
            assertEquals(mas[2], outputStream.toString(), "Errors ");
            outputStream.reset();
        }
    }

    @AfterAll
    public static void returnOutputStream() {
        System.setOut(originalOut);
    }

}