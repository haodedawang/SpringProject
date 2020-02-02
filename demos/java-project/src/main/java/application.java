import lombok.Data;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class application {
    final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) {
        final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

        Class[] clazz=new Class[]{ProxyInterface.class};
        ProxyInterface pro=
                (ProxyInterface) Proxy.newProxyInstance(application.class.getClassLoader(),clazz,new handler());
        pro.getsel();


    }

}
