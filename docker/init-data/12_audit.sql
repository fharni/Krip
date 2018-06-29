CREATE TABLE audit_status
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status varchar(255) NOT NULL
);
INSERT INTO audit_status (id, status) VALUES (1, 'Beantragt');
INSERT INTO audit_status (id, status) VALUES (2, 'Teilnehmer festlegen');

CREATE TABLE audit
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    club_id int(11) NOT NULL,
    auditor_id int(11) NOT NULL,
    startdate datetime NOT NULL,
    status_id int(11) DEFAULT 1 NOT NULL,
    CONSTRAINT audit_club_ID_fk FOREIGN KEY (club_id) REFERENCES club (ID),
    CONSTRAINT audit_user_ID_fk FOREIGN KEY (auditor_id) REFERENCES user (ID),
    CONSTRAINT audit_status_id_fk FOREIGN KEY (status_id) REFERENCES audit_status (id)
);
CREATE INDEX audit_club_ID_fk ON audit (club_id);
CREATE INDEX audit_user_ID_fk ON audit (auditor_id);
CREATE INDEX audit_status_id_fk ON jupa.audit (status_id);

CREATE TABLE audit_user
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    audit_id int(11),
    user_id int(11) NOT NULL,
    grade_id int(11) NOT NULL,
    CONSTRAINT audit_user_audit_id_fk FOREIGN KEY (audit_id) REFERENCES audit (id),
    CONSTRAINT audit_user_user_ID_fk FOREIGN KEY (user_id) REFERENCES user (ID),
    CONSTRAINT audit_user_grading_ID_fk FOREIGN KEY (grade_id) REFERENCES grading (ID)
);
CREATE INDEX audit_user_audit_id_fk ON audit_user (audit_id);
CREATE INDEX audit_user_user_ID_fk ON audit_user (user_id);
CREATE INDEX audit_user_grading_ID_fk ON audit_user (grade_id);