package com.black.creational.abstractfactory.listfactory;

import com.black.creational.abstractfactory.factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHtml() {
        return "<li><a href=\""+ url +"\">" + caption + "</a></li>";
    }
}
