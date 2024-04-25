package outpatient.appointment.system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import outpatient.appointment.system.Doctor;
import outpatient.appointment.system.Service.DoctorService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/lists")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable Long id) {
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            return ResponseEntity.ok(doctor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found with id: " + id+" please select the doctor_id from 1 to 10 range only");
        }
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> findDoctorsBySpecialization(@PathVariable String specialization) {
        return doctorService.findDoctorBySpecialization(specialization);
    }

    @GetMapping("/checkAvailability/{id}")
    public String checkDoctorAvailability(@PathVariable Long id, @RequestParam("appointmentTime") @DateTimeFormat(pattern = "dd/MM/yyyy H:m") LocalDateTime appointmentTime) {
        return doctorService.checkDoctorAvailability(id, appointmentTime);
    }
}
