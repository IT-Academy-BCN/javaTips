package itacademy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

    private static String className = "itacademy.reflection.SampleClass";

    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName(className);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();

            for(Method method : methods)
                System.out.println(method.toString());

            for(Constructor ctor : ctors)
                System.out.println(ctor.toString());

        } catch(ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
