package outpatient.appointment.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import outpatient.appointment.system.Appointment;
import outpatient.appointment.system.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  List<Appointment> findByDoctorId(Long doctorId);
  List<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
}

