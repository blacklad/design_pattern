package com.black.creational.abstractfactory.listfactory;

import com.black.creational.abstractfactory.factory.Item;
import com.black.creational.abstractfactory.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    protected String makeHtml() {
        StringBuffer sb = new StringBuffer();

        sb.append("<html><head><title> " + title + "</title></head><body>");

        sb.append("<ul>\n");
        Iterator<Item> it = content.iterator();
        while (it.hasNext()) {
            sb.append(it.next().makeHtml());
        }
        sb.append("</ul>\n");

        sb.append("author is: " + author);

        sb.append("</body></html>");
        return sb.toString();
    }
}
