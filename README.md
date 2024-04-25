API--Endpoints

Http:/localhost:8080/appointments/api/endpoints ---> Run this to know about all the Http req URL's and also i can provide them here as well with detailed ex.

http://localhost:8080/doctors/lists
Purpose ----> retrieve the list of all doctors

http://localhost:8080/doctors/{id}
Purpose ----> pass the doctor id from 1 to 10 range to retreive the information about the particular doctor

http://localhost:8080/doctors/specialization/{specialization}
Purpose ----> pass the doctor specialization from the list range to retreive the information about the particular doctor

http://localhost:8080/doctors/checkAvailability/{id}?appointmentTime=dd/MM/yyyy H:m
Purpose ----> To check the doctor availability pass the dr id and the date and time in the above format(in dd//MM/yyyy H:m => dd means day, MM means month, yyyy means year and H means hour and m means minute)

http://localhost:8080/appointments/book?doctorId=1&patientName=kishore Kumar&appointmentTime=dd/MM/yyyy H:m
Purpose ----> If you want to book appointment for checkup then first pass the doctor_Id from 1 to 10 range, then Patient_Name and then the appointment time in the above format(in dd//MM/yyyy H:m => dd means day, MM means month, yyyy means year and H means hour and m means minute)

http://localhost:8080/appointments/doctor/{doctorId}
Purpose ----> Pass the doctor id from 1 to 10 range to return the list of the doctor appointments booked slots
