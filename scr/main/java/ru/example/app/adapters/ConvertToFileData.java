package ru.example.app.adapters;

import ru.example.app.model.FileData;

import java.io.File;

public interface ConvertToFileData {

    FileData convertToFileData (File file);
}
