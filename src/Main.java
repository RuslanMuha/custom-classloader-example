import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader = new MyClassLoader();

//        Class<?> aClass = myClassLoader.findClass("myClassLoader.MyClass");
       Class<?> aClass = myClassLoader.loadClass("myClassLoader.MyClass");

        System.out.println(aClass.getClassLoader());
        Object o = aClass.getDeclaredConstructor().newInstance();
        Method show = aClass.getMethod("show");
        show.invoke(o);

    }
}
