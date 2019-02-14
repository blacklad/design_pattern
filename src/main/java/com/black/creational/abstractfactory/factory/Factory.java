package com.black.creational.abstractfactory.factory;

public abstract class Factory {
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
