package outpatient.appointment.system;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private String patientName;
    private LocalDateTime appointmentTime;


    public Appointment() {

    }

    public Appointment(Doctor doctor, String patientName, LocalDateTime appointmentTime) {
        this.doctorId = doctor.getId();
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
    }


    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpatientName() {
        return patientName;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setpatientName(String patientName) {
        this.patientName = patientName;
    }

}