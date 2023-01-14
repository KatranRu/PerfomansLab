package org.testmdm;

import java.util.List;

public class ListTesticks {
    private List<Tests> tests;

    public ListTesticks(List<Tests> testikList) {
        this.tests = testikList;
    }

    public ListTesticks() {
    }

    public List<Tests> getTests() {
        return tests;
    }

    public void setTests(List<Tests> testikList) {
        this.tests = testikList;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"tests\": " + tests.toString() +
                "\n}";
    }
}
