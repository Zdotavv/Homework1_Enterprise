package com.zdotavv.homework1_enterprise;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ResourceReaderImpl implements ResourcaReader{
    @Setter
    private ClassPathResource resource;
    private List<List<String>> records;
private String regex=",";

    public void reader() {
        String line;
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                List<String> questions = new ArrayList<>();
                String[] units = line.split(regex);
                Arrays.stream(units).forEach(s -> questions.add(s.trim()));
                records.add(questions);
            }
        }  catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

}
