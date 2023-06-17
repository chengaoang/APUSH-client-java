package org.apush.msg;


import java.util.Base64;

public class ShowDoc {
    private String title;
    private final StringBuilder content = new StringBuilder();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.toString();
    }

    public void appendContent(String content) {
        this.content.append("\\n");
        this.content.append(content);
    }

    public String toJson(){
        return "{\"title\": \""+ this.title+"\",\"content\": \""+this.content+"\"}";
    }
}
