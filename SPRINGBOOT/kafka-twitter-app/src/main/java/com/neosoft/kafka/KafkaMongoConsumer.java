package com.neosoft.kafka;

import com.neosoft.kafka.consumer.KafkaConsumerMongoDb;
import com.neosoft.kafka.consumer.TwitterConsumer;
import com.neosoft.kafka.producer.TwitterProducer;

public class KafkaMongoConsumer {
	public static void main(String[] args) {
		try {
			// 3. Run Kafka producer, subscribe to Twitter Kafka topic and ingest data into
			// MongoDB database
			new KafkaConsumerMongoDb();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().getClass());
		}
	}

}
