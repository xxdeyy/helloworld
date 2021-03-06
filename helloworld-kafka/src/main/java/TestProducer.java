import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        producer.send(new ProducerRecord<>("fcboxClientPostQueue", "{\"cmd\":\"STAFFGETORDER\",\"uicUserId\":350792370455833049,\"busyStatus\":1,\"clientPostTime\":\"2017-04-17 18:40:45\",\"closeTime\":\"2017-05-01 18:40:45\"}"));

//        for (int i = 0; i < 100; i++) {
//            producer.send(new ProducerRecord<>("test", "key" + i, "value" + i), (metadata, e) -> {
//                if (e != null) {
//                    e.printStackTrace();
//                }
//                System.out.println("The offset of the record we just sent is: " + metadata.offset());
//            });
//        }

        producer.close();
    }
}
