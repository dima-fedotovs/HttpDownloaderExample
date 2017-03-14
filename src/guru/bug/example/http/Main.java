package guru.bug.example.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Parameter with URL to download expected");
        }
        String strURL = args[0];
        long timeStart = System.currentTimeMillis();
        try {
            URL url = new URL(strURL);
            System.out.println("Reading " + strURL);

            try (InputStream is = url.openStream();
                 InputStreamReader r = new InputStreamReader(is);
                 BufferedReader bis = new BufferedReader(r)) {

                String line;
                while ((line = bis.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("URL is malformed");
        } catch (IOException e) {
            System.out.println("Something wrong. Sorry.");
            e.printStackTrace();
        } finally {
            long timeFinish = System.currentTimeMillis();
            System.out.printf("Process took %d ms", timeFinish - timeStart);
        }
    }
}
