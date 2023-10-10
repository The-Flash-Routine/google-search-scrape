package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleSearchService {

    //private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?key=" + "AIzaSyDTMW3I42FUDobU7QIX8P3Ng41Eq5SX66w" + "&cx=" + "005681851150756396207:mtsy4fy-nqi" + "&q=";
    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";

    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.0.0 Safari/537.36";


    public String scrapeFirstLinkFromGoogleSearch(String query) throws IOException {
        String searchUrl = GOOGLE_SEARCH_URL + query;
        Document doc = Jsoup.connect(searchUrl).userAgent(userAgent).get();

        // Get the first search result link (assuming it's a web link)
//        Element firstResultLink = doc.select("div.rc cite").first();
//        if (firstResultLink != null) {
//            return firstResultLink.text();
//        }
//        return "No results found";



//        String html = Jsoup.connect(GOOGLE_SEARCH_URL + query).get().html();
//        // Parse the HTML to get the URL of the first link.
//        String firstLinkUrl = Jsoup.parse(html).selectFirst(".yuRUbf a").attr("href");
//
//        // Get the HTML of the first link.
//        String linkHtml = Jsoup.connect(firstLinkUrl).get().html();
//
//        // Extract the data from the HTML.
//        String data = Jsoup.parse(linkHtml).text();
//
//        return data;

        Document document = Jsoup.connect(searchUrl).get();

        String description = document.text();

        //System.out.println(description);
        return description;
    }
}
