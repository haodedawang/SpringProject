package spi;

import java.sql.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.logging.Logger;

public class MainClass {
    public static void main(String[] args) {
        testSpi();
        Thread.yield();
    }

    public static void testSpi() {
        //1.保存我们的IParseDoc到service
        //2.保存classLoader------>线程上线问加载器（默认是AppClassLoader）
        //3.创建一个懒加载迭代器
        ServiceLoader<IParseDoc> iParseDocs = ServiceLoader.load(IParseDoc.class);
        Iterator<IParseDoc> iParseDocIterator = iParseDocs.iterator();

        //读取meta-inf/services/接口全类名
        //读取一个保存到nextName属性
        while (iParseDocIterator.hasNext()) {
            //使用反射，通过nextName和线程上下文加载器获取对象c = Class.forName(nextName, false, loader);
            iParseDocIterator.next().parse();
        }
    }


}
