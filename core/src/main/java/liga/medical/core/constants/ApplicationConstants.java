package liga.medical.core.constants;

/**
 * Константы приложения.
 */
public enum ApplicationConstants {

    MAIN_QUEUE("medical");

    private String medicalQueue;

    ApplicationConstants(String queueName) {
        this.medicalQueue = queueName;
    }

    public String getMedicalQueue() {
        return medicalQueue;
    }
}
