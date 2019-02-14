package com.black.creational.abstractfactory.listfactory;

import com.black.creational.abstractfactory.factory.Factory;
import com.black.creational.abstractfactory.factory.Link;
import com.black.creational.abstractfactory.factory.Page;
import com.black.creational.abstractfactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
