CREATE TABLE COURSE (
  ID            INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  STARTDATE     TIMESTAMP    NOT NULL,
  ENDDATE       TIMESTAMP    NOT NULL,
  TOPIC         VARCHAR(255) NOT NULL,
  PLACE         VARCHAR(255),
  CLUB_ID       INTEGER,
  INSTRUCTOR_ID INTEGER,
  CONSTRAINT COURSE_CLUB_ID_FK FOREIGN KEY (CLUB_ID) REFERENCES CLUB (ID),
  CONSTRAINT COURSE_USER_ID_FK FOREIGN KEY (INSTRUCTOR_ID) REFERENCES USER (ID)
);

CREATE TABLE COURSE_USER (
  ID            INTEGER           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  COURSE_ID     INTEGER           NOT NULL,
  USER_ID       INTEGER           NOT NULL,
  ANNOTATION_ID INTEGER DEFAULT 0 NOT NULL,
  CONSTRAINT COURSE_USER_COURSE_ID_FK FOREIGN KEY (COURSE_ID) REFERENCES COURSE (ID),
  CONSTRAINT COURSE_USER_USER_ID_FK FOREIGN KEY (USER_ID) REFERENCES USER (ID),
  CONSTRAINT COURSE_USER_ANNOTATION_ID_FK FOREIGN KEY (ANNOTATION_ID) REFERENCES ANNOTATION (ID)
);