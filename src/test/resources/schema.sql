CREATE TABLE IF NOT EXISTS e_attestation(
    id SERIAL PRIMARY KEY,
    siret char(14) NOT NULL UNIQUE ,
    enterprise varchar(100) NOT NULL ,
    iso_27001 boolean NOT NULL ,
    iso_9001 boolean NOT NULL ,
    iso_45001 boolean NOT NULL
    );