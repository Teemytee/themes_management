CREATE TABLE IF NOT EXISTS users(
    id bigserial NOT NULL,
    email character varying (255) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying (100) NOT NULL,
    password character varying (255) NOT NULL,
    role character varying (20) NOT NULL,
    status character varying(20),
    image character varying (45),
    PRIMARY KEY(id)
)