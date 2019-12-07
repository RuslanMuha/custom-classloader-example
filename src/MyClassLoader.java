import java.io.*;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);

    }

    private byte[] loadClassData(String className) throws ClassNotFoundException {


        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len;
        try {
            while ((len = is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return byteSt.toByteArray();
  }
}