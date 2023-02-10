CREATE TABLE IF NOT EXISTS e_attestation(
    id SERIAL PRIMARY KEY,
    siret char(14) NOT NULL UNIQUE ,
    enterprise varchar(100) NOT NULL ,
    iso_27001 boolean NOT NULL ,
    iso_9001 boolean NOT NULL ,
    iso_45001 boolean NOT NULL,
    creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO e_attestation (siret, enterprise, iso_27001, iso_9001, iso_45001) VALUES ('12345678912345', 'test-aymen', true, true, false);