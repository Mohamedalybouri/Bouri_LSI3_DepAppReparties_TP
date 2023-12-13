package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consummer {
    public static void main(String[] args){
        try {
            // On utilise le protocol TCP
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            //start connection
            connection.start();
            //create session
            Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //the same message to all
            Destination destination = session.createTopic("MyTopic.topic");
            //create message consumer
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage){
                        TextMessage textMessage =(TextMessage)message;
                        try {
                            System.out.println("Message recu:"+textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
