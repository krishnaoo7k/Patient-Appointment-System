package outpatient.appointment.system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import outpatient.appointment.system.Appointment;
import outpatient.appointment.system.Doctor;
import outpatient.appointment.system.Repository.AppointmentRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorService doctorService;

    public Appointment bookAppointment(Long doctorId, String patientName, LocalDateTime appointmentTime) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (!doctor.isAvailableOnSunday() && appointmentTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
         throw new  RuntimeException(doctor.getName() + " is not available on Sundays.");
        }

        List<Appointment> existingAppointments = appointmentRepository.findByDoctorIdAndAppointmentTime(doctor.getId(), appointmentTime);
        if (!existingAppointments.isEmpty()) {
            throw new RuntimeException("Doctor " + doctor.getName() + " is already booked at the specified time please change your booking time.");
        }

        Appointment newAppointment = new Appointment(doctor, patientName, appointmentTime);
        return appointmentRepository.save(newAppointment);
    }


    public List<Appointment> getAppointmentsListByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }


    public List<String> returnAllApiEndPoints(){
        List<String> dataList = new ArrayList<>();

        dataList.add("1. http://localhost:8080/doctors/lists");
        dataList.add("2. http://localhost:8080/doctors/{id}");
        dataList.add("3. http://localhost:8080/doctors/specialization/{specialization}");
        dataList.add("4. http://localhost:8080/doctors/checkAvailability/{id}?appointmentTime=dd/MM/yyyy H:m");
        dataList.add("5. http://localhost:8080/appointments/book?doctorId=1&patientName=kishore Kumar&appointmentTime=dd/MM/yyyy H:m");
        dataList.add("6. http://localhost:8080/appointments/doctor/{doctorId}");
        dataList.add("IMP Note ----> for detailed information like what they do how its work just go with the ReadMe_for_api_endpoints ");

        return dataList;
    };

}