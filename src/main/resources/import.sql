INSERT INTO ROLE(id, roleName)
VALUES (1, 'Admin');
INSERT INTO ROLE(id, roleName)
VALUES (2, 'Team-Leiter');
INSERT INTO ROLE(id, roleName)
VALUES (3, 'Mitarbeiter');

INSERT INTO USER (username, password, role_Id)
VALUES ('zli', 'secret', 1);
INSERT INTO USER (username, password, role_Id)
VALUES ('ale', 'lue', 2);
INSERT INTO USER (username, password, role_Id)
VALUES ('jon', 'lol', 3);
INSERT INTO USER (username, password, role_Id)
VALUES ('alejandro', '12345', 1);

INSERT INTO TEAMS(id, teamName)
VALUES (1, 'Team-React');
INSERT INTO TEAMS(id, teamName)
VALUES (2, 'Teams-Teams');
INSERT INTO TEAMS(id, teamName)
VALUES (3, 'Teams-Values');

INSERT INTO PROJECT(projectName, teams_id)
VALUES ('React', 1);
INSERT INTO PROJECT(projectName, teams_id)
VALUES ('Teams', 2);
INSERT INTO PROJECT(projectName, teams_id)
VALUES ('Values', 3);

INSERT INTO ENTRY(checkIn, checkOut, message, project)
VALUES ('2021-11-19T12:43:16', '2021-11-19T12:43:16', 'testmessage', 'testProject');
INSERT INTO ENTRY(checkIn, checkOut, message, project)
VALUES ('2021-11-19T12:43:16', '2021-11-19T12:43:16', 'testmessage', 'testProject');
INSERT INTO ENTRY(checkIn, checkOut, message, project)
VALUES ('2021-11-19T12:43:16', '2021-11-19T12:43:16', 'testmessage', 'testProject');
INSERT INTO ENTRY(checkIn, checkOut, message, project)
VALUES ('2021-11-19T12:43:16', '2021-11-19T12:43:16', 'testmessage', 'testProject');
INSERT INTO ENTRY(checkIn, checkOut, message, project)
VALUES ('2021-11-19T12:43:16', '2021-11-19T12:43:16', 'testmessage', 'testProject');


