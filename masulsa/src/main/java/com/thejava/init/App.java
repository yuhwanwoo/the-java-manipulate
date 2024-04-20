package com.thejava.init;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader); // App Class Loader
        System.out.println(classLoader.getParent()); // Platform Class Loader
        System.out.println(classLoader.getParent().getParent()); // 있지만 네이티브 코드라 구현되어 있고 VM 마다 달라서 볼 수 없다. (부트스트랩 클래스 로더)
    }
}
