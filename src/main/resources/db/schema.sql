
CREATE TABLE student
(
	id  NUMBER NOT NULL auto_increment,
	student_name VARCHAR (120) NOT NULL
);

ALTER TABLE student
	ADD CONSTRAINT pk_student_id PRIMARY KEY (id);

CREATE TABLE course
(
	id  NUMBER NOT NULL auto_increment,
	course_name VARCHAR (120) NOT NULL
);

ALTER TABLE course
	ADD CONSTRAINT pk_course_id PRIMARY KEY (id);
ALTER TABLE course
	ADD CONSTRAINT ak_course_name UNIQUE (course_name);

CREATE TABLE registration
(
	id NUMBER NOT NULL auto_increment,
	student_id  NUMBER NOT NULL,
	course_id  NUMBER NOT NULL,
	score	NUMBER
);

ALTER TABLE registration
	ADD CONSTRAINT pk_registration_id PRIMARY KEY (id);
	
ALTER TABLE registration
	ADD CONSTRAINT ak_registration UNIQUE (student_id, course_id);