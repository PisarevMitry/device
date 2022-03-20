package liga.medical.devicecore.controller;

import liga.medical.DeviceIdentificationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/device")
public class DeviceMessageController {

    Logger logger = LoggerFactory.getLogger(DeviceMessageController.class);
    String hostname = "Unknown";

    private final AmqpTemplate template;

    @Autowired
    public DeviceMessageController(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping("/send")
    public ResponseEntity<DeviceIdentificationDto> send(@RequestBody DeviceIdentificationDto dto) {
        logger.info("Sending to medical");
        template.convertAndSend("medical", dto.toString());

        try {
            InetAddress address;
            address = InetAddress.getLocalHost();
            hostname = address.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return ResponseEntity.ok(dto);
    }
}
