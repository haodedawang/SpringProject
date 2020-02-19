import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Start {
     static void run() throws LifecycleException {
         Tomcat tomcat=new Tomcat();
         tomcat.setPort(9999);
         tomcat.addWebapp("/","d:\\web");
         tomcat.start();
         tomcat.getServer().await();
    }
}
