package Aparts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Master
 */
public class GetWebpageContent {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        URL url;

        try {
            // enter any url to get its content
            url = new URL("http://codeforces.com/problemset/problem/1/A");
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;

            // save it anywhere in local machine for offline use
            String fileName = "testAlt.html";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }

            bw.close();
            br.close();

            System.out.println("Your file is saved in " + fileName
                    + " location.");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
