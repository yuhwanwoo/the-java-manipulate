package com.thejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Class<Book> bookClass = Book.class;
//        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//
//        Class<?> aClass1 = Class.forName("com.thejava.Book");
//        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
//        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
//        Book book = new Book();
//        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
//            try {
//                f.setAccessible(true);
//                System.out.printf("%s %s\n", f, f.get(book));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        });
//        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
//        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
//        System.out.println(MyBook.class.getSuperclass());
//        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
//        Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
//            int modifiers = field.getModifiers();
//            System.out.println(field);
//            System.out.println(Modifier.isPrivate(modifiers));
//            System.out.println(Modifier.isStatic(modifiers));
//        });
//        Arrays.stream(Book.class.getMethods()).forEach(m -> {
//            int modifiers = m.getModifiers();
//        });

        // 단순히 이렇게 하면 안뜬다. 그냥 어노테이션으로만 생성하면 그렇고 @Retention 설정 추가해줘야함
//        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

//        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
//        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
//        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
//        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
//            Arrays.stream(f.getAnnotations()).forEach(a -> {
//                if (a instanceof MyAnnotation) {
//                    MyAnnotation myAnnotation = (MyAnnotation) a;
//                    System.out.println(myAnnotation.value());
//                    System.out.println(myAnnotation.number());
//                }
//            });
//        });

        Class<?> bookClass = Class.forName("com.thejava.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("myBook");
//        System.out.println(book);
//
//        Field a = Book.class.getDeclaredField("A");
//        System.out.println(a.get(null));
//        a.set(null, "AAAAAA");
//        System.out.println(a.get(null));

//        Field b = Book.class.getDeclaredField("B");
//        b.setAccessible(true);
//        System.out.println(b.get(book));
//        b.set(book, "BBBB");
//        System.out.println(b.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book, 1, 2);
        System.out.println(invoke);
    }
}
