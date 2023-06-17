package org.apush;

import org.apush.msg.ShowDoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 */
public class App {
    public static void test(String[] args) {
        ShowDoc sd = new ShowDoc();
        sd.setTitle("fuck test");
        sd.appendContent("# this a test");
        sd.appendContent("- a");
        sd.appendContent("- b");
        sd.appendContent("> asdf");
        String json = sd.toJson();
        doPush(json);
    }

    public static String doPush(String param){
        HttpURLConnection conn = null;
        OutputStream os = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = Config.ShowDocUrl;
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("POST");
            conn.connect();
            os = conn.getOutputStream();
            os.write(param.getBytes(StandardCharsets.UTF_8));
            os.flush();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String current;
            while((current = in.readLine()) != null)
            {
                resp.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                conn.disconnect();
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException ignored) {
                }
            }
        }
        return resp.toString();
    }
}
