package com.example.activeMQ.initializer;

import com.example.activeMQ.extensions.Connections;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConnectionInitializer {

    @Autowired
    CamelContext camelContext;

    @Autowired(required = false)
    List<Connections> connections;

    @Bean
    public void loadCamelComponents() {
        if (connections != null) {
            for (Connections connection : connections) {
                camelContext.addComponent(connection.getCamelName(), connection.getComponent());
            }
        }
    }
}
