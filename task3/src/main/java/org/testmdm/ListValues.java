package org.testmdm;

import java.util.List;

public class ListValues {
    private List<Tests> values;

    public ListValues() {
    }

    public ListValues(List<Tests> values) {
        this.values = values;
    }

    public List<Tests> getValues() {
        return values;
    }

    public void setValues(List<Tests> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"values\": " + values.toString() +
                "\n}";
    }
}
