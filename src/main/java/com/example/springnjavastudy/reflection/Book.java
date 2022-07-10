package com.example.springnjavastudy.reflection;

@MyAnnotation(name = "asdf")
public class Book {

    public static String A = "A";

    public String B = "B";

    private void c(){
        System.out.println("C");
    }

    public Book() {
    }

    public Book(String b) {
        B = b;
    }

    public int sum(int left, int right){
        return left + right;
    }

    /*
    private String a;

    private static String B = "BOOK";

    private static final String C = "BOOK";

    public String d;

    protected String e;

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
    */
}
