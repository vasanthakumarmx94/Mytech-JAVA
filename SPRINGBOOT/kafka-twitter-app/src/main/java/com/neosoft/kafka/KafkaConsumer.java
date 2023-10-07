package com.neosoft.kafka;

import com.neosoft.kafka.consumer.KafkaConsumerMongoDb;
import com.neosoft.kafka.consumer.TwitterConsumer;
import com.neosoft.kafka.producer.TwitterProducer;

public class KafkaConsumer {

    public static void main(String[] args) {
        try {
            // 2. Uncomment it to run Kafka producer and subscribe to Twitter Kafka Topic
            new TwitterConsumer();            
        }catch(Exception e){
            System.out.println(e.getStackTrace().getClass());
        }
    }

}

