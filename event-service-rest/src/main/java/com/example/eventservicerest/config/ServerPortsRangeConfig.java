package com.example.eventservicerest.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.util.TestSocketUtils;

@Configuration
public class ServerPortsRangeConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        int port = TestSocketUtils.findAvailableTcpPort();
        factory.setPort(port);
        System.getProperties().put("server.port", port);
    }

}
