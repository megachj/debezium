package com.sunset.debezium.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChangeDataCaptureListener {

    @KafkaListener(topics = "dbhistory.inventory.customers")
    public void captureChangedData(String messageString) {
        log.info("------------------------------------------------------------------");
        log.info("messageString: {}", messageString);
    }
}
