package com.black.behavioral.iterator;

public class IteratorTest {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(10);
        bookShelf.appendBook(new Book("yw"));
        bookShelf.appendBook(new Book("ss"));
        bookShelf.appendBook(new Book("yy"));

        MyIterator myIterator = bookShelf.iterator();

        while(myIterator.hasNext()) {
            Book book = (Book)myIterator.next();
            System.out.println(book.getName());
        }


        while(myIterator.hasPrev()) {
            Book book = (Book)myIterator.previous();
            System.out.println(book.getName());
        }
    }


}

interface Aggregate {
    MyIterator iterator();
}

interface MyIterator {
    boolean hasNext();
    Object next();

    boolean hasPrev();
    Object previous();
}

class Book {
    private  String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int l) {
        books = new Book[l];
    }

    public Book getBookAt(int index) {
        if (index < last) {
            return books[index];
        }
        return null;
    }

    public void appendBook(Book b) {
        books[last] = b;
        last++;
    }
    public int getLast() {
        return last;
    }

    public MyIterator iterator() {
        return new BookShelfIterator(this);
    }

}


class BookShelfIterator implements MyIterator {

    private BookShelf bookShelf;
    private int index;
    private int lastIndex;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
        this.lastIndex = bookShelf.getLast() - 1;
    }

    public boolean hasNext() {
        if (index < bookShelf.getLast()) {
            return true;
        }
        return false;
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }

    public boolean hasPrev() {
        if (lastIndex >= 0) {
            return true;
        }
        return false;
    }

    public Object previous() {
        Book book = bookShelf.getBookAt(lastIndex);
        lastIndex--;
        return book;
    }
}


