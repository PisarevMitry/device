package liga.medical.core.service;

import liga.medical.DeviceIdentificationDto;
import liga.medical.core.api.NotificationService;
import liga.medical.core.constants.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void notify(DeviceIdentificationDto data) {

        String message = null;
        try {
            message = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // отправляем сообщение в брокер
        amqpTemplate.convertAndSend(ApplicationConstants.MAIN_QUEUE.getMedicalQueue(), message);

    }
}
