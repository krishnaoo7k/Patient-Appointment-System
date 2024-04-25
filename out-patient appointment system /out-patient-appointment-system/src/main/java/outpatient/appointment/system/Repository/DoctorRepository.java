package outpatient.appointment.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import outpatient.appointment.system.Doctor;

import java.util.*;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> findBySpecialization(String specialization);

}
