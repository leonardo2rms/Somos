-- Insert User
INSERT INTO Users (login, activated) values ('lcabello',true);

-- Insert Authorities
INSERT INTO Authorities (name) values ('ROLE_USER');
INSERT INTO Authorities (name) values ('ROLE_ADMIN');

-- Insert User_Authority
INSERT INTO AUTORITIES_USERS (user_login, name_authority) values ('lcabello','ROLE_USER');
INSERT INTO AUTORITIES_USERS (user_login, name_authority) values ('lcabello','ROLE_ADMIN');