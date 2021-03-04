package ru.example.app.adapters;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.example.app.model.Currency;
import ru.example.app.model.FileData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JSONToFileData implements ConvertToFileData {

    JSONParser parser = new JSONParser();

    @Override
    public List<FileData> convertToFileData(File file) {
        FileData fileData = null;
        List<FileData> fileDataList = new ArrayList<>();
        try {
            JSONObject a = (JSONObject) parser.parse(new FileReader(file));
            int line = 1;
//            for (String fileLine : fileContent) {
//                fileData = new FileData();
//                fileDataList.add(fileData);
//                String[] currentLine = fileLine.split(",");
//                fileData.setId(Long.valueOf(currentLine[0]));
//                fileData.setAmount(Double.valueOf(currentLine[1]));
//                fileData.setCurrency(getCurrency(currentLine[2]));
//                fileData.setComment(currentLine[3]);
//                fileData.setFileName(file.getName());
//                fileData.setLine(line);
//                fileData.setResult("OK");
//                line++;
//            }
            throw new IOException();
        } catch (IOException | NumberFormatException e) {
            //fileData.setResult(e.getClass().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fileDataList;
    }

    private Currency getCurrency(String currentLine) {
        for (Currency currency : Currency.values()) {
            if (currency.name().equalsIgnoreCase(currentLine)) {
                return currency;
            }
        }
        return Currency.NOTDETERMINATED;
    }
}