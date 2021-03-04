package ru.example.app.adapters;

import org.springframework.stereotype.Component;
import ru.example.app.model.FileData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVToFileData implements ConvertToFileData {

    @Override
    public List<FileData> convertToFileData(File file) {

        List<FileData> fileDataList = new ArrayList<>();
        try {
            List<String> fileContent = Files.readAllLines(file.toPath());
            int line = 1;
            for (String fileLine : fileContent) {
                FileData fileData = new FileData();
                String[] currentLine = fileLine.split(",");
                for (int counter = 0; counter < currentLine.length; counter++) {

                }
                System.out.println(fileLine);
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDataList;
    }
}
