package ru.example.app.services;

import ru.example.app.model.FileData;

import java.io.File;
import java.util.ArrayList;

public interface ConvertService {

    ArrayList<FileData> convertFile(String[] fileArray);
}
