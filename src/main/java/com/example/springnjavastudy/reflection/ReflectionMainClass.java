package com.example.springnjavastudy.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionMainClass {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //reflection();
        //myAnnotation();
        instance();
    }

    private static void reflection() {
        //클래스 타입으로 가져오는 방법
        Class<Book> bookClass = Book.class;// JVM 메모리 heap 에 들어간다.

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // Class<?> aClass1 = Class.forName("com.example");

        //book class에서 field를 가져오는 법
        //getFields는 Public한것만 가져온다.
        //getDeclaredFields() 다 가져오겠다
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);


        //Field 가져올때
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);                //reflection으로는 접근지시자들을 무시하고 셋팅할 수도 있다.
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        //Method 가져올때

        System.out.println("=====================================");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //생성자 가져올때

        System.out.println("=====================================");
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        System.out.println(MyBook.class.getSuperclass());

        //Interface

        System.out.println("=====================================");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        //Fields
        System.out.println("=====================================");
        Arrays.stream(MyBook.class.getFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
    }


    private static void myAnnotation() {
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        //My Book에 있는것만 가지고 오고싶을때
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        Arrays.stream(MyBook.class.getDeclaredFields()).forEach(ReflectionMainClass::accept);
    }
    //instance

    private static void instance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> bookClass = Class.forName("com.example.springnjavastudy.reflection.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);


        Book book = (Book) constructor.newInstance("myBook");
        System.out.println(book);

        Method c = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) c.invoke(book, 1, 2);
        System.out.println(invoke);
    }

    private static void accept(Field f) {
        Arrays.stream(f.getAnnotations()).forEach(System.out::println);
    }
}
