# Hospital-Management-System

1. Introduction
The Hospital Management System is a Java-based application developed using Object-Oriented Programming concepts. It helps manage basic hospital activities such as patient registration, doctor assignment, and appointment scheduling through a simple menu-driven interface.

2. Abstract
The Hospital Management System is a console-based Java application designed to simplify basic hospital operations. It provides facilities for patient registration, doctor assignment, appointment scheduling, and record management.
The project demonstrates the practical implementation of Object-Oriented Programming concepts such as Encapsulation, Inheritance, Abstraction, Polymorphism, Association, and Aggregation.

3. Objectives
•	Register patients
•	Assign doctors
•	Schedule appointments
•	Maintain patient records
•	Demonstrate OOP concepts in Java
________________________________________

4. System Features
•	Patient Registration
•	Doctor Assignment
•	Appointment Scheduling
•	View Patient Details
•	View Appointment Details

5. Classes Used
Patient
Stores patient information such as ID, name, age, medical history, and assigned doctor.
Staff
An abstract parent class containing common staff information.
Doctor
Inherits from Staff and represents doctors in the hospital.
Nurse
Inherits from Staff and assists in treatment.
Appointment
Stores appointment details including patient, doctor, and date.
Hospital
Manages all patients, doctors, and appointments using ArrayList.
Main
Runs the program and displays the menu.
uns the program and displays the menu.

6. OOP Concepts Used
Class
A class is a blueprint used to create objects.
Examples:
•	Patient
•	Doctor
•	Nurse
•	Hospital
•	Appointment
•	Treatmen
Object
An object is an instance of a class.
Examples:
•	Hospital hospital = new Hospital();
•	Patient p = new Patient(...);
•	Doctor d = new Doctor(...);
Encapsulation
Encapsulation means binding data and methods together while restricting direct access to data.
Example:
private int patientID;
private String name;
private int age;
private String medicalHistory;
Getter methods such as getPatientID() and getName() provide controlled access.
Inheritance
Inheritance allows one class to inherit properties and methods from another class.
Example:
class Doctor extends Staff
class Nurse extends Staff
Doctor and Nurse inherit:
•	staffID
•	name
•	department
 Abstraction
Abstraction hides implementation details and exposes only essential functionality.
Example:
abstract class Staff
public abstract void handleTreatment();
The implementation is provided by Doctor and Nurse classes.
 Polymorphism
Polymorphism allows the same method to perform different tasks.
Doctor:
handleTreatment()
prints:
Doctor treating patient.
Nurse:
handleTreatment()
prints:
Nurse assisting treatment.
This is Runtime Polymorphism through Method Overriding.
Association
Association represents a relationship between two classes.
Example:
private Doctor assignedDoctor;
A Patient is associated with a Doctor through the assignDoctor() method.
Aggregation
Aggregation represents a "has-a" relationship.
Example:
ArrayList<Patient> patients;
ArrayList<Doctor> doctors;
ArrayList<Appointment> appointments;
The Hospital class has collections of patients, doctors, and appointments.

7.Data Structures Used
The project uses Java ArrayList.
Examples:
•	ArrayList
•	ArrayList
•	ArrayList
Advantages:
•	Dynamic size
•	Easy insertion
•	Easy searching
•	Easy management
