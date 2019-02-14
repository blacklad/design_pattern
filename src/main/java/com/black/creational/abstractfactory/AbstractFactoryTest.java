package com.black.creational.abstractfactory;

import com.black.creational.abstractfactory.factory.Factory;
import com.black.creational.abstractfactory.factory.Link;
import com.black.creational.abstractfactory.factory.Page;
import com.black.creational.abstractfactory.factory.Tray;
import com.black.creational.abstractfactory.listfactory.ListFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        Factory factory = new ListFactory();

        Link link1 = factory.createLink("人民日报","www.people.com");
        Link link2 = factory.createLink("西安日报", "www.xian.com");

        Tray tray = factory.createTray("日报");
        tray.add(link1);
        tray.add(link2);

        Page page = factory.createPage("this is page", "aaa");

        page.add(link1);
        page.add(tray);

        page.output();
    }
}
