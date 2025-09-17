package task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee demonstrates multiple inheritance via implementing multiple interfaces.
 */
public class Employee extends PersonBase implements Payable, WorkLog, Trainable {
    private final double hourlyRate;
    private double totalHours;
    private final List<String> trainings = new ArrayList<>();

    public Employee(String name, double hourlyRate) {
        super(name);
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be non-negative");
        }
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computePay() {
        return hourlyRate * totalHours;
    }

    @Override
    public void addHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours must be non-negative");
        }
        totalHours += hours;
    }

    @Override
    public double getTotalHours() {
        return totalHours;
    }

    @Override
    public void attendTraining(String topic) {
        trainings.add(topic == null ? "(unspecified)" : topic);
    }

    @Override
    public int getTrainingCount() {
        return trainings.size();
    }

    public double getHourlyRate() { return hourlyRate; }

    public List<String> getTrainings() { return List.copyOf(trainings); }

    @Override
    public String toString() {
        return String.format("Employee[%s,rate=%.2f,hours=%.2f,pay=%.2f,trainings=%d]", super.toString(), hourlyRate, totalHours, computePay(), trainings.size());
    }
}
