 CREATE TABLE IF NOT EXISTS record(
     id bigserial NOT NULL,
     theme character varying (100) NOT NULL,
     name character varying (100) NOT NULL,
     link character varying (200),
     read boolean DEFAULT false,
     mark integer,
     PRIMARY KEY(id)
 )

