package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) {
        try {
            // On utilise le protocol TCP
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();

            //start connection
            connection.start();

            // true : Only when we use session.commit
            // false : accept all (without commit)
            Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

            //the same message to all
            Destination destination = session.createTopic("MyTopic.topic");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Hello World!");
            producer.send(textMessage);
            
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
