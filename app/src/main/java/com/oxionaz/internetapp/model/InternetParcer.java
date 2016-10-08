package com.oxionaz.internetapp.model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class InternetParcer {

    public static BufferedReader getHtmlContent(String path) throws IOException {
            URL url = new URL(path);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(10000);
            c.connect();
            return new BufferedReader(new InputStreamReader(c.getInputStream()));
    }

    public static Document getSchedule(String userID) throws IOException {
        Connection.Response response = Jsoup.connect("http://student.miu.by/learning-card.html").data("act","regnum").data("id","id").data("regnum", userID).
                followRedirects(false).
                timeout(9000).
                referrer("http://student.miu.by/rating/~/log.out.html").
                userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36 OPR/36.0.2130.46").
                method(Connection.Method.POST).execute();
        Map<String, String> cookies = response.cookies();
        return Jsoup.connect("http://student.miu.by/rating/~/my.group.html").
                followRedirects(true).
                timeout(10000).
                referrer("http://student.miu.by/learning-card.html").
                cookies(cookies).
                userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36 OPR/36.0.2130.46").
                method(Connection.Method.GET).get();
    }

    public static Document getStudentInfo(String userID) throws IOException {
        return Jsoup.connect("http://student.miu.by/learning-card.html").data("act","regnum").data("id","id").data("regnum", userID).
                followRedirects(false).
                timeout(10000).
                referrer("http://student.miu.by/rating/~/log.out.html").
                userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36 OPR/36.0.2130.46").
                method(Connection.Method.POST).post();
    }
}
