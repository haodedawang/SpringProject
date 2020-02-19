package hotstart2;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class Application {
    public static String rootPath;

    public void start() throws Exception {
        init();
        new Test().hello();
    }

    private void init() {
        System.out.println("项目初始化");
    }


    public static void run(Class<?> clazz) throws Exception {
        String rootPath = MyClassLoader.class.getResource("/").getPath().replace("%20", " ");
        rootPath = new File(rootPath).getPath();
        Application.rootPath = rootPath;
        startFileMino(rootPath);
        MyClassLoader myClassLoader = new MyClassLoader(rootPath, rootPath + "/hotstart2");
        start0(myClassLoader);
    }

    public static void start0(MyClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("hotstart2.Application");
        aClass.getMethod("start").invoke(aClass.newInstance());
    }

    public static void startFileMino(String rootPath) throws Exception {
        FileAlterationObserver fileAlterationObserver=new FileAlterationObserver(rootPath);
        fileAlterationObserver.addListener(new FileListener());
        FileAlterationMonitor fileAlterationMonitor=new FileAlterationMonitor(500);
        fileAlterationMonitor.addObserver(fileAlterationObserver);
        fileAlterationMonitor.start();
    }

    public static void main(String[] args) throws Exception {
        Application.run(MyClassLoader.class);
    }


}
