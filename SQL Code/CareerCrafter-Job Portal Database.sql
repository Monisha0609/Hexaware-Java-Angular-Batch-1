create database CareerCrafter;
Use CareerCrafter;

-- Users table
create table Users(
User_id int auto_increment primary key,
Username varchar(50) not null,
Password varchar(100) not null,
Role enum('Employer','Jobseeker') not null,
email varchar(100) unique not null);

-- Employers table
create table Employers(
Employer_id int auto_increment primary key,
User_id int,
Company_name varchar(100),
Contact_number varchar(20),
foreign key(User_id)references Users (User_id)
);

-- Jobseekers table
create table Jobseekers(
 Jobseeker_id int auto_increment primary key,
 User_id int,
 Full_name varchar(100),
 Phone_number varchar(20),
 Education varchar(200),
 Experience text,
 foreign key (User_id) references Users(User_id)
 );
 
-- JobListing table
create table Joblistings(
Job_id int auto_increment primary key,
Employer_id int,
Job_title varchar(100),
Description text,
Qualifications text,
Location varchar(100),
Date_posted date,
foreign key(Employer_id) references Employers(Employer_id)
);

-- Applications table
create table Applications(
Application_id int auto_increment primary key,
Job_id int,
Jobseeker_id int,
Resume_link varchar(255),
Application_date date,
Status enum('Applied','Under_review','Accepted','Rejected'),
foreign key(Job_id)references Joblistings(Job_id),
foreign key (Jobseeker_id)references Jobseekers(Jobseeker_id)
);

-- Resume table
create table Resume(
Resume_id int auto_increment primary key,
Jobseeker_id int,
Resume_title varchar(100),
Document_link varchar(255),
Last_updated date,
foreign key (Jobseeker_id) references Jobseekers(Jobseeker_id)
);

-- insert users
insert into Users(Username,Password,Role,Email)values
('Monisha','pass1','Employer','monisha@gmail.com'),
('Saran','Pass2','Employer','saran@gmail.com'),
('Sam','Pass3','Jobseeker','sam@gmail.com'),
('Mary','Pass4','Jobseeker','mary@gmail.com'),
('Jansi','Pass5','Jobseeker','jansi@gmail.com');

-- insert Employers
insert into Employers (User_id, Company_name, Contact_number) values
(1, 'Alpha Tech', '9234567890'),
(2, 'Beta Solutions', '9876543210'),
(1, 'Alpha Tech - Division B', '8122334455'),
(2, 'Beta HR', '9988776655'),
(1, 'Alpha Sales', '7766554433');

-- insert Jobseekers
insert into JobSeekers (User_id, full_name, Phone_number, Education, Experience) values
(3, 'Jebisha', '7894561230', 'B.Tech CSE', '2 years in Software Dev'),
(4, 'Aksha', '7418529630', 'MBA HR', '3 years in Recruitment'),
(5, 'Aadhi', '7008009001', 'B.Sc IT', '1 year in QA'),
(3, 'Arvin', '9632587410', 'BCA', 'Fresher'),
(4, 'Avisha', '8527419630', 'B.Com', 'Internship at TCS');

-- insert Joblistings
insert into JobListings (Employer_id, job_title, Description, Qualifications, Location, Date_posted) values
(1, 'Java Developer', 'Develop backend services', 'B.Tech, Java, Spring Boot', 'Chennai', curdate()),
(2, 'HR Executive', 'Manage HR functions', 'MBA, Communication Skills', 'Mumbai',curdate() ),
(1, 'Sales Manager', 'Handle corporate sales', 'MBA Sales', 'Delhi', curdate()),
(2, 'UI/UX Designer', 'Design web interfaces', 'Any degree, Figma', 'Bangalore', curdate()),
(1, 'DevOps Engineer', 'Maintain CI/CD pipelines', 'B.Tech, Jenkins, AWS', 'Hyderabad', curdate());

-- insert Applications
insert into Applications (Job_id, jobseeker_id, Resume_link, Application_date, Status) values
(1, 1, 'resumes/jebisha_java.pdf', curdate(), 'Applied'),
(2, 2, 'resumes/aksha_hr.pdf', curdate(), 'Under_review'),
(3, 3, 'resumes/aadhi_sales.pdf', curdate(), 'Applied'),
(4, 4, 'resumes/arvin_uiux.pdf', curdate(), 'Rejected'),
(5, 5, 'resumes/avisha_devops.pdf', curdate(), 'Accepted');

-- insert Resume data
insert into Resume(Jobseeker_id, Resume_title, Document_link, Last_updated) values
(1, 'Jebisha Resume Java', 'resumes/jebisha_java.pdf', curdate()),
(2, 'Aksha HR Profile', 'resumes/aksha_hr.pdf', curdate()),
(3, 'Aadhi Sales Resume', 'resumes/aadhi_sales.pdf', curdate()),
(4, 'Arvin UI/UX', 'resumes/arvin_uiux.pdf', curdate()),
(5, 'Avisha DevOps', 'resumes/avisha_devops.pdf',curdate());

alter table employers add location varchar(100);

UPDATE Employers SET Location = 'Chennai' WHERE Employer_id = 1;
UPDATE Employers SET Location = 'Mumbai' WHERE Employer_id = 2;
UPDATE Employers SET Location = 'Delhi' WHERE Employer_id = 3;
UPDATE Employers SET Location = 'Hyderabad' WHERE Employer_id = 4;
UPDATE Employers SET Location = 'Pune' WHERE Employer_id = 5;

alter table Jobseekers add Resume varchar(255);
alter table Jobseekers add Skill varchar(100);

UPDATE Jobseekers SET Resume = 'resumes/jebisha_java.pdf', Skill = 'Java, Spring Boot' WHERE Jobseeker_id = 1;
UPDATE Jobseekers SET Resume = 'resumes/aksha_hr.pdf', Skill = 'HR, Communication' WHERE Jobseeker_id = 2;
UPDATE Jobseekers SET Resume = 'resumes/aadhi_sales.pdf', Skill = 'Sales, CRM' WHERE Jobseeker_id = 3;
UPDATE Jobseekers SET Resume = 'resumes/arvin_uiux.pdf', Skill = 'UI/UX, Figma' WHERE Jobseeker_id = 4;
UPDATE Jobseekers SET Resume = 'resumes/avisha_devops.pdf', Skill = 'DevOps, AWS' WHERE Jobseeker_id = 5;

alter table Joblistings add Salary_range varchar(50);

UPDATE Joblistings SET Salary_range = '6-8 LPA' WHERE Job_id = 1;
UPDATE Joblistings SET Salary_range = '4-6 LPA' WHERE Job_id = 2;
UPDATE Joblistings SET Salary_range = '7-10 LPA' WHERE Job_id = 3;
UPDATE Joblistings SET Salary_range = '5-7 LPA' WHERE Job_id = 4;
UPDATE Joblistings SET Salary_range = '8-12 LPA' WHERE Job_id = 5;

















