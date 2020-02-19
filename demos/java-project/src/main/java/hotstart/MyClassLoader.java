package hotstart;


import java.io.*;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;

public class MyClassLoader extends ClassLoader {
    private String rootPath;
    private List<String> clazzs;

    //动态加载更新后的代码
    //选择性加载某个范围下
    public MyClassLoader(String rootPath, String... loadPaths) throws Exception {
        this.rootPath = rootPath;
        this.clazzs = new ArrayList<>();
        //扫描传入路径
        for (String loadPath : loadPaths) {
            loadClassPath(new File(loadPath));
        }
    }

    public void loadClassPath(File file) throws IOException {
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                loadClassPath(file1);
            }
        } else {
            String fileName = file.getName();
            String filePath = file.getPath();
            String endName = fileName.substring(fileName.lastIndexOf(".") + 1);
            if ("class".equals(endName)) {
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                //将文件路径转换为类名  c://project//com//Test.class --> com.Test
                String className = filePathToClassName(filePath);
                this.clazzs.add(className);
                defineClass(className, bytes, 0, bytes.length);
            }
        }
    }

    public String filePathToClassName(String filePath) {

        String className = filePath.replace(rootPath, "").replaceAll("\\\\", ".");
        className = className.substring(0, className.lastIndexOf("."));
        className = className.substring(1);
        return className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass == null) {
            if (!clazzs.contains(name)) {
                loadedClass = getSystemClassLoader().loadClass(name);
            } else {
                throw new ClassNotFoundException("没有这个class");
            }
        }
        return loadedClass;
    }


    public static void main(String[] args) throws Exception {
        String rootPath = MyClassLoader.class.getResource("/").getPath().replace("%20", " ");
        rootPath = new File(rootPath).getPath();
        while (true) {
            MyClassLoader myClassLoader = new MyClassLoader(rootPath, rootPath + "/hotstart");
            Class<?> aClass = myClassLoader.loadClass("hotstart.Test");
            aClass.getMethod("hello").invoke(aClass.newInstance());
            Thread.sleep(2000);
        }
    }


}
