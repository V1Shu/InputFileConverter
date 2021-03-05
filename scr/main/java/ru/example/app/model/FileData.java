package ru.example.app.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileData {

    @SerializedName("orderId")
    private long id;
    private double amount;
    private Currency currency;
    private String comment;
    private String fileName;
    private int line;
    private String result;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"amount\":" + amount +
                ", \"comment\":" + "\"" + comment + "\"" +
                ", \"fileName\":" + "\"" + fileName + "\"" +
                ", \"line\":" + line +
                ", \"result\":" + "\"" + result + "\"" +
                '}';
    }
}
