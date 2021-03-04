package ru.example.app.services;

import ru.example.app.model.FileData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface ConvertService {

    List<FileData> convertFile(String[] fileArray);
}
