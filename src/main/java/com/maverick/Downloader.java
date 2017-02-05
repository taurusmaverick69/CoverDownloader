package com.maverick;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Downloader {

    private static String DESKTOP_PATH = System.getProperty("user.home") + "/Desktop";
    private static final String IMAGE_CSS_QUERY = "meta[property=og:image]";
    private static final String CONTENT_ATTR = "content";

    public static void saveImage(String URL) throws IOException {
        Document document = Jsoup.connect(URL).get();
        String imageUrl = document.select(IMAGE_CSS_QUERY).attr(CONTENT_ATTR);
        String fileName = FilenameUtils.getName(imageUrl);
        FileUtils.copyURLToFile(new URL(imageUrl), new File(DESKTOP_PATH, fileName));
    }
}