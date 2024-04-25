package outpatient.appointment.system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import outpatient.appointment.system.Appointment;
import outpatient.appointment.system.Service.AppointmentService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestParam ("doctorId") Long doctorId, @RequestParam ("patientName") String patientName, @RequestParam("appointmentTime") @DateTimeFormat(pattern = "dd/MM/yyyy H:m") LocalDateTime appointmentTime) {
        try {
            Appointment newAppointment = appointmentService.bookAppointment(doctorId, patientName, appointmentTime);

            return ResponseEntity.ok("Appointment booked successfully: " + newAppointment.getId());
        } catch (RuntimeException e) {
            if (e.getMessage().contains("is not available on Sundays")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error booking appointment: " + e.getMessage());
            } else if (e.getMessage().contains("is already booked at the specified time")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error booking appointment: " + e.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
            }
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsListByDoctor(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsListByDoctor(doctorId);
    }

    @GetMapping("/api/endpoints")
    public List<String>returnAllApiEndPoints(){
        return appointmentService.returnAllApiEndPoints();
    }
}