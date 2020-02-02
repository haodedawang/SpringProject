import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

@Configuration
public class WebServerConfiguration {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {

        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(11359);//端口号
        factory.setUriEncoding(Charset.forName("utf-8"));//编码
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        return factory;
    }

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {


        @Override
        public void customize(Connector connector) {
            // TODO Auto-generated method stub
            Http11NioProtocol handler = (Http11NioProtocol) connector.getProtocolHandler();
            handler.setAcceptCount(2000);//排队数
            handler.setMaxConnections(5000);//最大连接数
            handler.setMaxThreads(2000);//线程池的最大线程数
            handler.setMinSpareThreads(100);//最小线程数
            handler.setConnectionTimeout(30000);//超时时间                    
        }

    }

}
