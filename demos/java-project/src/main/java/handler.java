import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class handler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("getsel")){

            System.out.println("ssssssssssssssss");
            method.invoke(args);
        }
        return null;
    }
}
