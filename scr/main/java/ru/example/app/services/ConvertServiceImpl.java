package ru.example.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.example.app.adapters.CSVToFileData;
import ru.example.app.model.FileData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertServiceImpl implements ConvertService {

    private final CSVToFileData csvToFileData = new CSVToFileData();

    @Override
    public ArrayList<FileData> convertFile(String[] fileArray) {
        String path = System.getProperty("user.dir");
        List<File> fileList = new ArrayList<>();

        for (String fileName : fileArray) {
            String fullFileName = path + File.separator + fileName;
            System.out.println(fullFileName);
            fileList.add(new File(fullFileName));
        }

        for (File file : fileList) {
            int lastDot = file.getName().lastIndexOf('.');
            String expansion = (lastDot == -1) ? null : file.getName().substring(++lastDot);
            System.out.println(expansion);

            if (expansion.toLowerCase().equals("csv")) {
                List<FileData> fileDataList = csvToFileData.convertToFileData(file);
                //System.out.println(fileData.toString());
            }
        }
        ArrayList<FileData> returnArray = new ArrayList<FileData>();
        returnArray.add(new FileData());
        return returnArray;
    }
}
