package com.black.structional.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FacadeTest {
    public static void main(String[] args) {

    }
}

class PageMaker {
    private String mail;
    private String name;

    public PageMaker(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    public void makeHtml(String name, String fileName) {
        String mail = Database.getMail(name);

        try {
            Writer writer = new FileWriter(fileName);
            HtmlWriter htmlWriter = new HtmlWriter(writer);

            htmlWriter.title("this is a title");
            htmlWriter.paragraph("this is a page");
            htmlWriter.mailto(mail, name);

            htmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Database {
    public static String getMail(String name) {
        return name + "@qq.com";
    }
}

class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html><head><title" + title + "</title></head><body><h1>" + title + "</h1>");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
    }

    public void link(String href, String caption) throws IOException {
        writer.write("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto" + mailaddr, username);
    }

    public void close() throws IOException {
        writer.write("</body></html>");
    }
}