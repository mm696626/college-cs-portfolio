CREATE TABLE doctor(
    iddoctor INT NOT NULL,
    fName VARCHAR(45) NOT NULL,
    lName VARCHAR(45) NOT NULL,
    image LONGBLOB,
    department_ID int,
    PRIMARY KEY (iddoctor),
    FOREIGN KEY (department_ID) REFERENCES department(department_id)
);



CREATE TABLE patientRecord (
    idpatientrecord INT NOT NULL,
    insurance VARCHAR(45) NOT NULL,
    phoneNumber VARCHAR(10),
    primary key (idpatientrecord)
);


CREATE TABLE patient(
    idpatient INT NOT NULL,
    fName VARCHAR(45) NOT NULL,
    lName VARCHAR(45) NOT NULL,
    DOB DATE NOT NULL,
    address VARCHAR(45) NOT NULL,
    bloodType VARCHAR(45) NOT NULL,
    visitDate DATETIME,
    doctor_iddoctor INT NOT NULL,
    patientRecord_idpatientrecord INT NOT NULL,
    PRIMARY KEY (idpatient),
    FOREIGN KEY (doctor_iddoctor) REFERENCES doctor(iddoctor),
    FOREIGN KEY (patientRecord_idpatientrecord) REFERENCES patientRecord(idpatientrecord)
);


CREATE TABLE visitor(
    idvisitor INT NOT NULL AUTO_INCREMENT,
    fName VARCHAR(45) NOT NULL,
    lName VARCHAR(45) NOT NULL,
    visitDate DATETIME,
    patient_idpatient INT,
    PRIMARY KEY (idvisitor),
    FOREIGN KEY (patient_idpatient) references patient(idpatient)
);

CREATE TABLE department (
    department_id INT NOT NULL,
    department_location VARCHAR(45),
    department_type VARCHAR(45),
    PRIMARY KEY (department_id)
);



CREATE TABLE appointment (
    appointmentID INT auto_increment PRIMARY KEY,
    apptDate DATETIME NOT NULL,
    idDoctor_appt INT NOT NULL,
    idPatient_appt INT NOT NULL,
    FOREIGN KEY (idDoctor_appt) REFERENCES doctor(iddoctor), FOREIGN KEY (idPatient_appt) REFERENCES patient(idpatient)
);




#duplicate prevention
create trigger checkDuplicate before insert on patient for each row begin
if(EXISTS(SELECT fName, lName from patient where fName = NEW.fName AND lName = NEW.lName))
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'DUPLICATE';
END IF;
end;

#check visitor hours
create trigger ifVisitorHours before insert on visitor for each row begin
if(TIME(NEW.visitDate) < '08:00:00' OR TIME(NEW.visitDate) > '23:00:00')
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'The hospital is closed right now. Please try another time :)';
END IF;
end;

#check appointment hours
create trigger ifAppointmentHours before insert on appointment for each row begin
if(TIME(NEW.apptDate) < '08:00:00' OR TIME(NEW.apptDate) > '23:00:00')
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'The hospital is closed right now. Please try another time :)';
END IF;
end;




#visitor schedule procedure
create procedure checkVisitor(IN patientID INT, IN visitorFName VARCHAR(45), IN visitorLName VARCHAR(45), IN visitDay DATETIME) BEGIN
IF (EXISTS(select * from visitor where patient_idpatient = patientID AND visitDay = visitDate))
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Visitor is already visiting patient at this time. Please schedule for another time :)';
ELSE
insert into visitor (fName, lName, visitDate, patient_idpatient) VALUES (visitorFName, visitorLName, visitDay, patientID);
end if;
end;


#appointment schedule procedure
create procedure checkAppointment(IN patientID INT, IN doctorID INT, IN visitDay DATETIME) BEGIN
IF (EXISTS(select * from appointment where doctorID = idDoctor_appt AND visitDay = apptDate))
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Patient is already visiting your doctor at this time. Please schedule for another time :)';
ELSE
insert into appointment (apptDate, idDoctor_appt, idPatient_appt) VALUES (visitDay, doctorID, patientID);
end if;
end;