package com.black.creational.abstractfactory.listfactory;

import com.black.creational.abstractfactory.factory.Item;
import com.black.creational.abstractfactory.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<li>" + caption + "\n");

        sb.append("<ul>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            sb.append(it.next().makeHtml());
        }
        sb.append("</ul>\n");

        sb.append( "</li>");
        return sb.toString();
    }
}
