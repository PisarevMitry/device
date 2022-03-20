package liga.medical.core.api;

import liga.medical.DeviceIdentificationDto;

public interface NotificationService {

    /**
     * Информирование о статистике.
     *
     * @param data передаваемые данные
     */
    void notify(DeviceIdentificationDto data);
}
