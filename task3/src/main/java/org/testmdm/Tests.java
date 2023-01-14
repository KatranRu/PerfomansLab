package org.testmdm;


import java.util.List;

public class Tests {
    private int id;
//    @JsonIgnore
    private String title;
//    @JsonIgnore
    private String value;
    private List<Tests> values;

    public Tests() {
    }

    public Tests(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Tests> getValues() {
        return values;
    }

    public void setValues(List<Tests> masTest) {
        this.values = masTest;
    }

    @Override
    public String toString() {
        if (null != this.values) {
            return "{\n" +
                    "\"id\": " + id +
                    ",\n\"title\": \"" + title + '\"' +
                    ",\n\"value\": \"" + value + '\"' +
                    ",\n\"values\": " + values +
                    "\n}";
        } else {
            return "{\n" +
                    "\"id\": " + id +
                    ",\n\"title\": \"" + title + '\"' +
                    ",\n\"value\": \"" + value +
                    "\n}";
        }
    }
}
