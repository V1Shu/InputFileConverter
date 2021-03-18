package ru.example.app.converters;

import org.springframework.stereotype.Component;
import ru.example.app.model.Currency;
import ru.example.app.model.FileData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for parsing csv file to fileData model
 */
@Component
public class CSVToFileData implements ConvertToFileData {
    /**
     * Read file by lines, fill FileData model and add to list
     *
     * @param file csv class
     * @return List of FileData models
     */
    @Override
    public List<FileData> convertToFileData(File file) {

        FileData fileData = new FileData();
        List<FileData> fileDataList = new ArrayList<>();
        try {
            List<String> fileContent = Files.readAllLines(file.toPath());
            int line = 1;
            for (String fileLine : fileContent) {
                fileData = new FileData();
                fileDataList.add(fileData);
                String[] currentLine = fileLine.split(",");
                fileData.setId(Long.valueOf(currentLine[0]));
                fileData.setAmount(Double.valueOf(currentLine[1]));
                fileData.setCurrency(getCurrency(currentLine[2]));
                fileData.setComment(currentLine[3]);
                fileData.setFileName(file.getName());
                fileData.setLine(line);
                fileData.setResult("OK");
                line++;
            }
        } catch (IOException | NumberFormatException e) {
            fileData.setResult("File reading error. Check file " + file.getName());
        }

        return fileDataList;
    }

    /**
     *  Return currency from enum
     * @param currentLine name of currency from file
     * @return element from currency enum
     */
    private Currency getCurrency(String currentLine) {
        for (Currency currency : Currency.values()) {
            if (currency.name().equalsIgnoreCase(currentLine)) {
                return currency;
            }
        }
        return Currency.NOTDETERMINATED;
    }
}
