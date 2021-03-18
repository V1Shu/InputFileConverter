package ru.example.app.converters;

import ru.example.app.model.FileData;

import java.io.File;
import java.util.List;

public interface ConvertToFileData {

    List<FileData> convertToFileData (File file);
}
