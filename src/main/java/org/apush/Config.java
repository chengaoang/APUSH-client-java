package org.apush;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    public static URL ShowDocUrl;
    public static URL DingTalkUr;

    public static String host = "http://127.0.0.1";

    static {
        try {
            ShowDocUrl = new URL(host+"/sd");
            DingTalkUr = new URL(host+"/dt");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
