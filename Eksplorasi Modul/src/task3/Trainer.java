package task3;

/**
 * Trainer is a specialized Employee focusing on training others.
 */
public class Trainer extends Employee {
    private int sessionsLed;

    public Trainer(String name, double hourlyRate) {
        super(name, hourlyRate);
    }

    public void leadSession(String topic) {
        sessionsLed++;
        // Reuse attendTraining to log own session as attended knowledge
        attendTraining("Led: " + topic);
    }

    public int getSessionsLed() { return sessionsLed; }

    @Override
    public String toString() {
        return "Trainer{" + super.toString() + ",sessionsLed=" + sessionsLed + '}';
    }
}
