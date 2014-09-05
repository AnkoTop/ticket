INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('1', '0', 'Tommy.Tester@redoair.be', 'Tommy', 'Tester', 'ttester');
INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('2', '0', 'Theo.Dummy@redoair.be', 'Theo', 'Dummy', 'tdummy');
INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('3', '0', 'John.Doe@redoair.be', 'John', 'Doe', 'johndoe');
INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('4', '0', 'Jane.Doe@redoair.be', 'Jane', 'Doe', 'janedoe');
INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('5', '0', 'John.Snow@redoair.be', 'John', 'Snow', 'jsnow');
INSERT INTO user (id, version, email, firstName, lastName, userName) VALUES ('6', '0', 'Claire.Farron@redoair.be', 'Claire', 'Farron', 'cfarron');

INSERT INTO passenger (id, version, birthDate, firstName, lastName, TYPE) VALUES ('1', '0', '1970-10-10', 'Deep', 'Thought','OCCASIONAL');
INSERT INTO passenger (id, version, birthDate, firstName, lastName, TYPE) VALUES ('2', '0', '1968-06-14', 'Rock', 'Star','REGULAR');
INSERT INTO passenger (id, version, birthDate, firstName, lastName, TYPE) VALUES ('3', '0', '1993-09-12', 'Blue', 'Fish','REGULAR');
INSERT INTO passenger (id, version, birthDate, firstName, lastName, TYPE) VALUES ('4', '0', '2001-01-30', 'Lightning', 'Storm','REGULAR');
INSERT INTO passenger (id, version, birthDate, firstName, lastName, TYPE) VALUES ('5', '0', '1930-05-01', 'Amber', 'Sun','OCCASIONAL');

INSERT INTO flight (DTYPE,id,number) VALUES ('Flight','1','AA001');
INSERT INTO flight (DTYPE,id,number) VALUES ('Flight','2','SNY2');
INSERT INTO flight (DTYPE,id,number) VALUES ('Flight','3','4Y-2');
INSERT INTO flight (DTYPE,id,number) VALUES ('Flight','4','12-GO');


INSERT INTO ticket (id, dateOfDeparture, price, flight_id,passenger_id) VALUES ('1', '2014-08-28' ,'125.00','1','1');
INSERT INTO ticket (id, dateOfDeparture, price, flight_id,passenger_id) VALUES ('2', '2014-08-28' ,'999.00','1','2');