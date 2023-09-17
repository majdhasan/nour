CREATE TABLE nour.lesson
(
    id        UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
    course_id UUID NOT NULL,
    content   VARCHAR(255),
    FOREIGN KEY (course_id) REFERENCES nour.course (id)
);

CREATE INDEX if not exists idx_course_id__lesson on nour.lesson (course_id);
