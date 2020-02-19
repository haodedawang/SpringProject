package hotstart2;


import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {

    @Override
    public void onFileChange(File file) {
        if (file.getName().indexOf(".class") != -1) {
            try {
                MyClassLoader myClassLoader = new MyClassLoader(Application.rootPath, Application.rootPath + "/hotstart2");
                Application.start0(myClassLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
