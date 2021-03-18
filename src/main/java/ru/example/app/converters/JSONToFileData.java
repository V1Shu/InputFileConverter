package ru.example.app.converters;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import ru.example.app.model.FileData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for parsing json file to fileData model (USING gson lib)
 */
public class JSONToFileData implements ConvertToFileData {
    /**
     * instance of gson
     */
    Gson gson = new Gson();

    /**
     * Read file, fill FileData model and add to list
     *
     * @param file json file
     * @return list of FileData models
     */
    @Override
    public List<FileData> convertToFileData(File file) {
        FileData fileData = new FileData();
        List<FileData> fileDataList = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new FileReader(file));
            FileData[] dataFromFile = new FileData[1];

            /* If file contains only one line throw JsonSyntaxException
                Then read only firs line
             */
            try {
                dataFromFile = gson.fromJson(reader, FileData[].class);
            } catch (JsonSyntaxException e) {
                dataFromFile[0] = gson.fromJson(reader, FileData.class);
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