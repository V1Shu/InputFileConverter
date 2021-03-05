package ru.example.app.adapters;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import ru.example.app.model.FileData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONToFileData implements ConvertToFileData {

    Gson gson = new Gson();

    @Override
    public List<FileData> convertToFileData(File file) {
        FileData fileData = null;
        List<FileData> fileDataList = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new FileReader(file));
            FileData[] dataFromFile = new FileData[1];
            try {
                dataFromFile = gson.fromJson(reader, FileData[].class);
            } catch (JsonSyntaxException e) {
                dataFromFile[0] = gson.fromJson(reader, FileData.class);;
            }

            int line = 1;
            for (FileData fileDataFromFile : dataFromFile) {
                fileData = fileDataFromFile;
                fileDataList.add(fileData);
                fileData.setFileName(file.getName());
                fileData.setLine(line);
                fileData.setResult("OK");
                line++;
            }
        } catch (IOException e) {
            fileData.setResult("File reading error. Check file " + file.getName());
        }

        return fileDataList;
    }
}