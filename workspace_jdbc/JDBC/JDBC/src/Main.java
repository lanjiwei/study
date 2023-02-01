import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws Exception {

        Class t = Class.forName("java.lang.StringBuffer");
        StringBuffer stringBuffer = (StringBuffer)t.getDeclaredConstructor().newInstance();
        stringBuffer.append(1);
        Class clazz  = String.class;
        String string = (String) clazz.getDeclaredConstructor().newInstance();
        System.out.println(stringBuffer);
        System.out.println(string);
    }
}