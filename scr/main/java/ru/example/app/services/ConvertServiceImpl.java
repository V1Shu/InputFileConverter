package ru.example.app.services;

import org.springframework.stereotype.Component;
import ru.example.app.adapters.CSVToFileData;
import ru.example.app.adapters.JSONToFileData;
import ru.example.app.model.FileData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertServiceImpl implements ConvertService {

    private final CSVToFileData csvToFileData = new CSVToFileData();
    private final JSONToFileData jsonToFileData = new JSONToFileData();

    @Override
    public List<FileData> convertFile(String[] fileArray) {
        String path = System.getProperty("user.dir");
        List<File> fileList = new ArrayList<>();
        List<FileData> fileDataList = new ArrayList<>();

        for (String fileName : fileArray) {
            String fullFileName = path + File.separator + fileName;
            fileList.add(new File(fullFileName));
        }

        for (File file : fileList) {
            int lastDot = file.getName().lastIndexOf('.');
            String expansion = (lastDot == -1) ? null : file.getName().substring(++lastDot);

            if (expansion.equalsIgnoreCase("csv")) {
                fileDataList.addAll(csvToFileData.convertToFileData(file));
            } else if (expansion.equalsIgnoreCase("json")) {
                fileDataList.addAll(jsonToFileData.convertToFileData(file));
            }
        }

        return fileDataList;
    }
}
