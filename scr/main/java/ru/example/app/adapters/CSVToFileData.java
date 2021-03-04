package ru.example.app.adapters;

import org.springframework.stereotype.Component;
import ru.example.app.model.FileData;

import java.io.File;

@Component
public class CSVToFileData implements ConvertToFileData {
    @Override
    public FileData convertToFileData(File file) {
        return new FileData();
    }
}
