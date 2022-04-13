package com.ori98.sitecheck.prod.Controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final String SITE_IS_UP = "Site is working";
    private final String SITE_IS_DOWN = "Site is down";
    private final String INVALID_URL = "URL is invalid";

    @GetMapping("/check")
    public String checkURL(@RequestParam String url){
        String returnMessage = "";

        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCodeCategory = connection.getResponseCode() / 100;

            if(responseCodeCategory == 2 || responseCodeCategory == 3){
                returnMessage = SITE_IS_UP;
            } else{
                returnMessage = SITE_IS_DOWN;
            }

        } catch (MalformedURLException e) {
            returnMessage = INVALID_URL;
        } catch (IOException e) {
            returnMessage = SITE_IS_DOWN;
        }
        return returnMessage;
    }
}
