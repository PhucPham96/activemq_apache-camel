package com.example.activeMQ.extensions;

import lombok.Getter;
import lombok.Setter;
import org.apache.camel.Component;
import org.apache.camel.component.jms.JmsComponent;

import javax.jms.ConnectionFactory;

public abstract class Connections {

    @Getter @Setter
    protected String camelName;

    protected abstract ConnectionFactory connectionFactory();

    public Component getComponent() {
        return JmsComponent.jmsComponentAutoAcknowledge(connectionFactory());
    }

}
