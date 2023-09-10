-- Create the schema to organize tables
CREATE SCHEMA IF NOT EXISTS nour;

-- Enable the UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Define the tutor table
CREATE TABLE nour.tutor
(
    id    UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Define the student table
CREATE TABLE nour.student
(
    id    UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);


-- Define the course table
CREATE TABLE nour.course
(
    id          UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    tutor_id    UUID NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (tutor_id) REFERENCES nour.tutor(id)
);



-- Define the enrollment table
CREATE TABLE nour.enrollment
(
    id      UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    course_id UUID NOT NULL,
    student_id UUID NOT NULL,
    paid    BOOLEAN,
    FOREIGN KEY (course_id) REFERENCES nour.course(id),
    FOREIGN KEY (student_id) REFERENCES nour.student(id)
);

-- Define the certificate table
CREATE TABLE nour.certificate
(
    id       UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    student_id UUID NOT NULL,
    course_id UUID NOT NULL,
    FOREIGN KEY (student_id) REFERENCES nour.student(id),
    FOREIGN KEY (course_id) REFERENCES nour.course(id)
);

-- Create indexes as needed for your specific query patterns
CREATE INDEX IF NOT EXISTS idx_tutor__course ON nour.course(tutor_id);
CREATE INDEX IF NOT EXISTS idx_course__enrollment ON nour.enrollment(course_id);
CREATE INDEX IF NOT EXISTS idx_student__enrollment ON nour.enrollment(student_id);
CREATE INDEX IF NOT EXISTS idx_student__certificate ON nour.certificate(student_id);