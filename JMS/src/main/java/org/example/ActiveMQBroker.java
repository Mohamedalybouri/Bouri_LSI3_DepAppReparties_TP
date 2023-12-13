package org.example;

import org.apache.activemq.broker.BrokerService;

public class ActiveMQBroker {
    public static void main(String[] args){
        BrokerService brokerService = new BrokerService();
        try {
            brokerService.addConnector("tcp://0.0.0.0:61616");
            brokerService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
