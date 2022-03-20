package liga.medical.core.rest;

import liga.medical.DeviceIdentificationDto;
import liga.medical.core.api.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Главный контроллер.
 * */
@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/main")
    public void notification(@RequestBody DeviceIdentificationDto deviceIdentificationDto){
        notificationService.notify(deviceIdentificationDto);
    }
}
