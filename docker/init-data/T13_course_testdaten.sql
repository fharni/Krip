INSERT INTO course (ID, STARTDATE, ENDDATE, TOPIC, PLACE, CLUB_ID, INSTRUCTOR_ID) VALUES (1, '2018-06-30 14:00:00', '2018-06-30 17:00:00', 'Vorbereitung auf Kyu Prüfung', 'Littfeld', 4, 5);
INSERT INTO course (ID, STARTDATE, ENDDATE, TOPIC, PLACE, CLUB_ID, INSTRUCTOR_ID) VALUES (2, '2018-06-16 14:00:00', '2018-06-16 17:00:00', 'Hebeltechniken', 'Bad Driburg', 3, 4);
INSERT INTO course (ID, STARTDATE, ENDDATE, TOPIC, PLACE, CLUB_ID, INSTRUCTOR_ID) VALUES (3, '2018-05-05 13:00:00', '2018-05-05 16:00:00', 'Spaß mit Falk', 'Erftstadt', 2, 1);

INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (1, 2, 1, 3);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (2, 2, 3, 1);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (3, 2, 4, 2);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (4, 1, 5, 2);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (5, 1, 2, 3);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (6, 1, 1, 3);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (7, 1, 3, 1);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (8, 3, 1, 2);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (9, 3, 2, 3);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (10, 3, 5, 3);
INSERT INTO course_user (ID, COURSE_ID, USER_ID, ANNOTATION_ID) VALUES (11, 3, 3, 1);