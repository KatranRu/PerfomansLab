package org.testmdm;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonRead {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            if (null != args[0] && null != args[1]) {
                startLogic(args);
            } else {
                System.out.println("Error: not found files");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: empty arguments");
        }
    }

    public static void startLogic(String[] str) {

        File file = new File(str[0]);
        File file1 = new File(str[1]);
        ListValues va;
        ListTesticks te;
        try {
            va = objectMapper.readValue(file1, ListValues.class);
            te = objectMapper.readValue(file, ListTesticks.class);
            setValueTest(te.getTests(), va);
            File result = new File("report.json");
            try {
                if (result.createNewFile()) {
                    try {
                        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                        objectMapper.writeValue(result, te);
                    } catch ( IOException e) {
                        System.out.println("Error writing json file");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error creating json file");
            }
        } catch (IOException e) {
            System.out.println("Error reading json file");
        }
    }

    public static void setValueTest(List<Tests> te, ListValues va) {
        for (Tests t: te) {
            if (null != t.getValues()) {
                setValueTest(t.getValues(), va);
            }
            for (Tests v: va.getValues()) {
                if(v.getId() == t.getId()) {
                    t.setValue(v.getValue());
                }
            }
        }
    }
}
