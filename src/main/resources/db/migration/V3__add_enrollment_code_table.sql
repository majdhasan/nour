CREATE TABLE nour.enrollment_code
(
    id         UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    tutor_id   UUID         NOT NULL,
    course_id  UUID,
    student_id UUID,
    code       VARCHAR(255) NOT NULL,
    valid_once BOOLEAN,
    is_active  BOOLEAN,
    FOREIGN KEY (tutor_id) REFERENCES nour.tutor (id),
    FOREIGN KEY (course_id) REFERENCES nour.course (id),
    FOREIGN KEY (student_id) REFERENCES nour.student (id)
);

CREATE UNIQUE INDEX if not exists uidx_tutor_code__enrollment_code on nour.enrollment_code (tutor_id, code);
