 CREATE TABLE IF NOT EXISTS record(
     id bigserial NOT NULL,
     name character varying (100) NOT NULL,
     link character varying (200),
     PRIMARY KEY(id)
 )