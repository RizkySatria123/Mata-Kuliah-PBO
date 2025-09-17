package task3;

/**
 * Trainable interface for entities that can attend training.
 */
public interface Trainable {
    void attendTraining(String topic);
    int getTrainingCount();
}
