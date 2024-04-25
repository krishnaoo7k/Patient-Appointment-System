package outpatient.appointment.system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import outpatient.appointment.system.Doctor;
import outpatient.appointment.system.Repository.DoctorRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;



    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

    }

    public List<Doctor> findDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    public String checkDoctorAvailability(Long id, LocalDateTime appointmentTime) {

        Doctor doctor ;

        try {
            doctor = getDoctorById(id);
        } catch (RuntimeException e) {
            return " The doctor with ID = " + id + " is not available. Please select a valid doctor ID from 1 to 10 only.";
        }

        LocalTime appointmentHour = appointmentTime.toLocalTime();

        if (doctor.getId() == 1) {
            // Doctor 1 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(17, 0)) && appointmentHour.isBefore(LocalTime.of(22, 0))) {

                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 5 PM to 10 Pm o'clock, please book your appointment";
            }
        } else if (doctor.getId() == 2) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(16, 30)) && appointmentHour.isBefore(LocalTime.of(22, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 4:30 PM to 10 Pm o'clock, please book your appointment";
            }
        } else if (doctor.getId() == 3) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(17, 0)) && appointmentHour.isBefore(LocalTime.of(23, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 5 PM to 11 Pm o'clock, please book your appointment";
            }
        } else if (doctor.getId() == 4) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(15, 0)) && appointmentHour.isBefore(LocalTime.of(21, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 3 PM to 9 Pm o'clock, please book your appointment";
            }
        } else if (doctor.getId() == 5) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(18, 0)) && appointmentHour.isBefore(LocalTime.of(21, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 6 PM to 9 Pm o'clock, please book your appointment";
            }
        }
        else if (doctor.getId() == 6) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(17, 0)) && appointmentHour.isBefore(LocalTime.of(21, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 5 PM to 9 Pm o'clock, please book your appointment";
            }
        }
        else if (doctor.getId() == 7) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(19, 0)) && appointmentHour.isBefore(LocalTime.of(23, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 7 PM to 11 Pm o'clock, please book your appointment";
            }
        }
        else if (doctor.getId() == 8) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(15, 30)) && appointmentHour.isBefore(LocalTime.of(21, 0))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 3:30 PM to 9 Pm o'clock, please book your appointment";
            }
        }
        else if (doctor.getId() == 9) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(18, 0)) && appointmentHour.isBefore(LocalTime.of(21, 0))) {
               return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 6 PM to 9 Pm o'clock, please book your appointment";
            }
        }
        else if (doctor.getId() == 10) {
            // Doctor 2 working hours check logic
            if (appointmentHour.isAfter(LocalTime.of(16, 0)) && appointmentHour.isBefore(LocalTime.of(20, 30))) {
                return "The Doctor "+ doctor.getName() +" who is "+doctor.getSpecialization()+" is available from 4 PM to 8 Pm o'clock, please book your appointment";
            }
        }
        return "The doctor "+ doctor.getName() +" is not available at that time, please change the appointment time to evening";
    }


}