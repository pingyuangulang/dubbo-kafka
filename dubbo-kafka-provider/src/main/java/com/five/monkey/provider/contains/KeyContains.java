package com.five.monkey.provider.contains;

/**
 *
 *
 * @author jim
 * @date 2020/4/30 0:01
 */
public class KeyContains {

    public static class Book {

        /** redis类型：string */
        public static final String BOOK_INFO = "book:id:%s";
    }

    public static class Author {

        /** redis类型：string */
        public static final String AUTHOR_INFO = "author:id:%s";
    }
}
