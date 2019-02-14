package com.black.structional.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        Print p = new PrintBanner("aaaaaaaaaa");
        p.printStrong();
        p.printWeak();
    }


    interface Print {

        void printWeak();
        void printStrong();
    }

    static class Banner {
        private String s;

        public Banner(String s) {
            this.s = s;
        }

        public void showWithParen() {
            System.out.println("(" + s + ")");
        }
        public void showWithAster() {
            System.out.println("*" + s + "*");
        }
    }

    static class PrintBanner extends Banner implements Print {

        PrintBanner(String s) {
            super(s);
        }

        @Override
        public void printWeak() {
            showWithParen();
        }

        @Override
        public void printStrong() {
            showWithAster();
        }
    }

}


class AdapterTest1 {

    public static void main(String[] args) {
        Print p = new PrintBanner("aaaaa");
        p.printStrong();
        p.printWeak();
    }


    static abstract class Print {
        abstract void printWeak();
        abstract void printStrong();
    }

    static class Banner {
        private String s;

        public Banner(String s) {
            this.s = s;
        }

        public void showWithParen() {
            System.out.println("(" + s + ")");
        }
        public void showWithAster() {
            System.out.println("*" + s + "*");
        }
    }

    static class PrintBanner extends Print {

        private Banner banner;

        PrintBanner(String s) {
            banner = new Banner(s);
        }

        @Override
        public void printWeak() {
            banner.showWithParen();
        }

        @Override
        public void printStrong() {
            banner.showWithAster();
        }
    }
}
