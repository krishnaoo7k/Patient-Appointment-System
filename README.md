This is a Patient Appointment booking system project so patient can book their appointment and also can get the doctor information
like their availaiblity, list of dr, etc.. by passing the correct URL 

I have created this project with the help of springboot and also i have followed the mvc design pattern to enhance my project 
readability by defining separate packages for seperatte sections, this makes it easy to understand.


To use the below URL's first you need to downlad this project into your local pc/macos then in your built tool(intellij, eclipse) go to new/project from existing souce and find this project and then from it inport the pom.xml file, it will take couple of seconds to auto configure all its dependencies and then in application.properties do your own database configuration then hit the run button and you are all set to use it

API--Endpoints________________________

http://localhost:8080/appointments/api/endpoints   

Purpose ---> To retrieve all HTTP URLs. For detailed information on each URL, refer to the list below.


1. http://localhost:8080/doctors/lists
   
Purpose ----> retrieve the list of all doctors


2. http://localhost:8080/doctors/{id}
   
Purpose ----> pass the doctor id from 1 to 10 range to retreive the information about the particular doctor


3.  http://localhost:8080/doctors/specialization/{specialization}
 
Purpose ----> pass the doctor specialization from the list range to retreive the information about the particular doctor


 4. http://localhost:8080/doctors/checkAvailability/{id}?appointmentTime=dd/MM/yyyy H:m
 
Purpose ----> To check the doctor availability pass the dr id and the date and time in the above format(in dd//MM/yyyy H:m => dd means day, MM means month, yyyy means year and H means hour and m means minute)


5. http://localhost:8080/appointments/book?doctorId=1&patientName=kishoreKumar&appointmentTime=dd/MM/yyyy H:m
 
Purpose ----> If you want to book appointment for checkup then first pass the doctor_Id from 1 to 10 range, then Patient_Name and then the appointment time in the above format(in dd//MM/yyyy H:m => dd means day, MM means month, yyyy means year and H means hour and m means minute)


6. http://localhost:8080/appointments/doctor/{doctorId}
 
Purpose ----> Pass the doctor id from 1 to 10 range to return the list of the doctor appointments booked slots
