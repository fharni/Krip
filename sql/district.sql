CREATE TABLE district (
  id            INTEGER GENERATED BY DEFAULT AS IDENTITY (
  START WITH 1 )             NOT NULL PRIMARY KEY,
  name          VARCHAR(100) NOT NULL,
  federation_id INTEGER      NOT NULL,
  displayid     INTEGER,
  FOREIGN KEY (federation_id) REFERENCES federation (id)
);

-- 1 Bremen  
INSERT INTO DISTRICT VALUES (1, 'Bremen', 1, 1);
-- 2 Hamburg
INSERT INTO DISTRICT VALUES (2, 'Hamburg', 2, 1);
-- 3 Schleswig-Holstein
INSERT INTO DISTRICT VALUES (3, 'Schleswig-Holstein', 3, 1);
-- 4 Mecklenburg-Vorpommern
INSERT INTO DISTRICT VALUES (4, 'Mecklenburg-Vorpommern', 4, 1);
-- 5 Nordrhein-Westfalen
INSERT INTO DISTRICT VALUES (5, 'Aachen', 5, 1);
INSERT INTO DISTRICT VALUES (6, 'Bielefeld', 5, 2);
INSERT INTO DISTRICT VALUES (7, 'Arnsberg', 5, 3);
INSERT INTO DISTRICT VALUES (8, 'Köln', 5, 4);
INSERT INTO DISTRICT VALUES (9, 'Düsseldorf', 5, 5);
INSERT INTO DISTRICT VALUES (10, 'Mönchengladbach', 5, 6);
INSERT INTO DISTRICT VALUES (11, 'Siegen', 5, 7);
INSERT INTO DISTRICT VALUES (12, 'Polizei', 5, 8);
INSERT INTO DISTRICT VALUES (13, 'Justiz', 5, 9);
INSERT INTO DISTRICT VALUES (14, 'Jiu-Jitsu', 5, 10);
-- 6 Hessen
INSERT INTO DISTRICT VALUES (15, 'Hessen', 6, 1);
-- 7 Sachsen-Anhalt
INSERT INTO DISTRICT VALUES (16, 'Sachsen-Anhalt', 7, 1);
-- 8 Th\u00fcringen
INSERT INTO DISTRICT VALUES (17, 'Thüringen', 8, 1);
-- 9 Brandenburg
INSERT INTO DISTRICT VALUES (18, 'Brandenburg', 9, 1);
-- 10 Berlin
INSERT INTO DISTRICT VALUES (19, 'Berlin', 10, 1);
-- 11 Sachsen
INSERT INTO DISTRICT VALUES (20, 'Sachsen', 11, 1);
-- 12 Rheinland-Pfalz
INSERT INTO DISTRICT VALUES (21, 'Rheinland-Pfalz', 12, 1);
-- 13 Saarland
INSERT INTO DISTRICT VALUES (22, 'Saarland', 13, 1);
-- 14 Baden
INSERT INTO DISTRICT VALUES (23, 'Baden', 14, 1);
-- 15 W\u00fcrtemberg
INSERT INTO DISTRICT VALUES (24, 'Würtemberg', 15, 1);
-- 16 Bayern
INSERT INTO DISTRICT VALUES (25, 'Oberbayern', 16, 1);
INSERT INTO DISTRICT VALUES (26, 'Niederbayern', 16, 2);
INSERT INTO DISTRICT VALUES (27, 'Oberfranken', 16, 3);
INSERT INTO DISTRICT VALUES (28, 'Mittelfranken', 16, 4);
INSERT INTO DISTRICT VALUES (29, 'Unterfranken', 16, 5);
INSERT INTO DISTRICT VALUES (30, 'Oberpfalz', 16, 6);
INSERT INTO DISTRICT VALUES (31, 'Schwaben', 16, 7);
-- 17 Niedersachsen
INSERT INTO DISTRICT VALUES (32, 'Braunschweig', 17, 1);
INSERT INTO DISTRICT VALUES (33, 'Hannover', 17, 2);
INSERT INTO DISTRICT VALUES (34, 'Lüneburg', 17, 3);
INSERT INTO DISTRICT VALUES (35, 'Weser-Ems', 17, 4);