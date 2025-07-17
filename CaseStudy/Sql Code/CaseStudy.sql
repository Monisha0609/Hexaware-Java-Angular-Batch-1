-- Step 1: Drop and Recreate the Database
DROP DATABASE IF EXISTS CaseStudy;
CREATE DATABASE CaseStudy;
USE CaseStudy;

-- Step 2: Users Table
CREATE TABLE Users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('EMPLOYER', 'JOBSEEKER') NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Step 3: Employers Table
CREATE TABLE Employers (
    employerId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    companyName VARCHAR(100),
    contactNumber VARCHAR(20),
    location VARCHAR(100),
    FOREIGN KEY (userId) REFERENCES Users(userId) ON DELETE CASCADE
);

-- Step 4: Jobseekers Table
CREATE TABLE Jobseekers (
    jobseekerId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    fullName VARCHAR(100),
    phoneNumber VARCHAR(20),
    education VARCHAR(200),
    experience TEXT,
    resume VARCHAR(255),
    skill VARCHAR(100),
    FOREIGN KEY (userId) REFERENCES Users(userId) ON DELETE CASCADE
);

-- Step 5: JobListings Table
CREATE TABLE JobListings (
    jobId INT AUTO_INCREMENT PRIMARY KEY,
    employerId INT NOT NULL,
    jobTitle VARCHAR(100),
    jobDescription TEXT,
    qualifications TEXT,
    location VARCHAR(100),
    datePosted DATE,
    salaryRange VARCHAR(50),
    category VARCHAR(100),
    FOREIGN KEY (employerId) REFERENCES Employers(employerId) ON DELETE CASCADE
);

-- Step 6: Applications Table
CREATE TABLE Applications (
    applicationId INT AUTO_INCREMENT PRIMARY KEY,
    jobId INT NOT NULL,
    jobseekerId INT NOT NULL,
    resumeLink VARCHAR(255),
    applicationDate DATE,
    status ENUM('Applied','Under_review','Accepted','Rejected'),
    FOREIGN KEY (jobId) REFERENCES JobListings(jobId) ON DELETE CASCADE,
    FOREIGN KEY (jobseekerId) REFERENCES Jobseekers(jobseekerId) ON DELETE CASCADE
);

-- Step 7: Resume Table
CREATE TABLE Resume (
    resumeId INT AUTO_INCREMENT PRIMARY KEY,
    jobseekerId INT NOT NULL,
    resumeTitle VARCHAR(100),
    documentLink VARCHAR(255),
    lastUpdated DATE,
    FOREIGN KEY (jobseekerId) REFERENCES Jobseekers(jobseekerId) ON DELETE CASCADE
);

-- Step 8: Sample Users
INSERT INTO Users (username, password, role, email) VALUES
('Monisha', 'pass1', 'EMPLOYER', 'monisha@gmail.com'),
('Saran', 'Pass2', 'EMPLOYER', 'saran@gmail.com'),
('Jebisha', 'Pass3', 'JOBSEEKER', 'jebisha@gmail.com'),
('Aksha', 'Pass4', 'JOBSEEKER', 'aksha@gmail.com'),
('Aadhi', 'Pass5', 'JOBSEEKER', 'aadhi@gmail.com');

-- Step 9: Sample Employers
INSERT INTO Employers (userId, companyName, contactNumber, location) VALUES
(1, 'Alpha Tech', '9234567890', 'Chennai'),
(2, 'Beta Solutions', '9876543210', 'Mumbai'),
(1, 'Alpha Tech - Division B', '8122334455', 'Delhi'),
(2, 'Beta HR', '9988776655', 'Hyderabad'),
(1, 'Alpha Sales', '7766554433', 'Pune');

-- Step 10: Sample Jobseekers
INSERT INTO Jobseekers (userId, fullName, phoneNumber, education, experience, resume, skill) VALUES
(3, 'Jebisha', '7894561230', 'B.Tech CSE', '2 years in Software Dev', 'resumes/jebisha_java.pdf', 'Java, Spring Boot'),
(4, 'Aksha', '7418529630', 'MBA HR', '3 years in Recruitment', 'resumes/aksha_hr.pdf', 'HR, Communication'),
(5, 'Aadhi', '7008009001', 'B.Sc IT', '1 year in QA', 'resumes/aadhi_sales.pdf', 'Sales, CRM');

-- Step 11: Sample JobListings
INSERT INTO JobListings (employerId, jobTitle, jobDescription, qualifications, location, datePosted, salaryRange, category) VALUES
(1, 'Java Developer', 'Develop backend services', 'B.Tech, Java, Spring Boot', 'Chennai', CURDATE(), '6-8 LPA', 'IT'),
(2, 'HR Executive', 'Manage HR functions', 'MBA, Communication Skills', 'Mumbai', CURDATE(), '4-6 LPA', 'HR'),
(1, 'Sales Manager', 'Handle corporate sales', 'MBA Sales', 'Delhi', CURDATE(), '7-10 LPA', 'Sales'),
(2, 'UI/UX Designer', 'Design web interfaces', 'Any degree, Figma', 'Bangalore', CURDATE(), '5-7 LPA', 'Design'),
(1, 'DevOps Engineer', 'Maintain CI/CD pipelines', 'B.Tech, Jenkins, AWS', 'Hyderabad', CURDATE(), '8-12 LPA', 'DevOps');

-- Step 12: Sample Applications
INSERT INTO Applications (jobId, jobseekerId, resumeLink, applicationDate, status) VALUES
(1, 1, 'resumes/jebisha_java.pdf', CURDATE(), 'Applied'),
(2, 2, 'resumes/aksha_hr.pdf', CURDATE(), 'Under_review'),
(3, 3, 'resumes/aadhi_sales.pdf', CURDATE(), 'Applied');

-- Step 13: Sample Resume Entries
INSERT INTO Resume (jobseekerId, resumeTitle, documentLink, lastUpdated) VALUES
(1, 'Jebisha Resume Java', 'resumes/jebisha_java.pdf', CURDATE()),
(2, 'Aksha HR Profile', 'resumes/aksha_hr.pdf', CURDATE()),
(3, 'Aadhi Sales Resume', 'resumes/aadhi_sales.pdf', CURDATE());
