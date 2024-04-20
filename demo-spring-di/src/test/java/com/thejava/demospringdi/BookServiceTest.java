package com.thejava.demospringdi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class BookServiceTest {
//    BookService bookService = new BookServiceProxy(new DefaultBookService());

//    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}
//    , new InvocationHandler() {
//                BookService bookService = new DefaultBookService();
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    if (method.getName().equals("rent")) {
//                        System.out.println("aaaa");
//                        Object invoke = method.invoke(bookService, args);
//                        System.out.println("bbbb");
//                        return invoke;
//                    }
//
//                    return method.invoke(bookService, args);
//                }
//            });

    @Test
    public void di() throws Exception{
        //cglib 사용
//        MethodInterceptor methodInterceptor = new MethodInterceptor() {
//            BookClassService bookService = new BookClassService();
//
//            @Override
//            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//                if (method.getName().equals("rent")) {
//                    System.out.println("aaaa");
//                    Object invoke = method.invoke(bookService);
//                    System.out.println("bbbb");
//                    return invoke;
//                }
//                return method.invoke(bookService, args);
//            }
//        };
//        BookService bookService = (BookService) Enhancer.create(BookService.class, methodInterceptor);
        //bytebuddy 사용
        Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookClassService bookClassService = new BookClassService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("aaaa");
                        Object invoke = method.invoke(bookClassService, args);
                        System.out.println("bbbb");
                        return invoke;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();
        BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring!!!");
        bookService.rent(book);
    }
}
