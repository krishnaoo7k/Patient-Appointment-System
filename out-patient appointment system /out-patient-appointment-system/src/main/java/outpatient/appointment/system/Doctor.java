package outpatient.appointment.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Long id;
    private String name;
    private String specialization;
    private int maxPatientsPerDay;

    public Doctor() {
    }

    public Doctor(Long id, String name, String specialization, int maxPatientsPerDay) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getMaxPatientsPerDay() {
        return maxPatientsPerDay;
    }

    public void setMaxPatientsPerDay(int maxPatientsPerDay) {
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", maxPatientsPerDay=" + maxPatientsPerDay +
                '}';
    }

    public boolean isAvailableOnSunday() {
        return false;
    }
}