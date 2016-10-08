package com.oxionaz.internetapp.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static String getHtml(String url) throws IOException {
        BufferedReader reader = null;
        try {
            reader = InternetParcer.getHtmlContent(url);
            StringBuilder buf = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            return (buf.toString());
        } finally {
            if(reader != null) reader.close();
        }
    }

    public static String[] getStudentInfo(String userID) throws IOException {
        Document doc = InternetParcer.getStudentInfo(userID);
        Elements userPhoto = doc.select("#content-item > div > div > center:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(1) > img");
        Elements userF = doc.select("#content-item > div > div > center:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
        Elements userI = doc.select("#content-item > div > div > center:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2)");
        Elements userO = doc.select("#content-item > div > div > center:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(2)");
        Elements userBall = doc.select("#content-item > div > div > center:nth-child(1) > table > tbody > tr:nth-child(7) > td:nth-child(2)");
        return new String[]{"http://student.miu.by"+userPhoto.attr("src"), userF.text()+" "+userI.text()+" "+userO.text(), userBall.text()};
    }
}