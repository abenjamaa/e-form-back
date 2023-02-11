# e-Attestation-back

## Prérquis
```
Java 17
Apache Maven 3.6.3
```
## Base de données
il faut créer une base de donnée avec ces information :

![bdd.png](src%2Fmain%2Fresources%2Fimage%2Fbdd.png)
```
        - url=jdbc:postgresql://localhost:5432/postgres
        - username=postgres
        - password=mysecretpassword 
```

Lancer le script suivant :
```
    CREATE TABLE IF NOT EXISTS e_attestation(
    id SERIAL PRIMARY KEY,
    siret char(14) NOT NULL UNIQUE ,
    enterprise varchar(100) NOT NULL ,
    iso_27001 boolean NOT NULL ,
    iso_9001 boolean NOT NULL ,
    iso_45001 boolean NOT NULL,
    creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
```
## Démarrage spring boot
```
    - Se mettre à la racine du dossier e-Attestation-back
    - lancer la commande : mvn spring-boot:run
```
## open api

Vous pouvez trouver la documentation swagger aux adresses suivantes :  
http://localhost:8080/v3/api-docs 

http://localhost:8080/swagger-ui/index.html#/

## Postman
Vous pouvez aussi utiliser le curl suivant pour créer une entreprise :
```
curl --location --request POST 'http://localhost:8080/v1/certifications/add-enterprise' \
--header 'Content-Type: application/json' \
--data-raw '{
    "siret": "36374885928565",
    "enterprise": "Enterprise 1",
    "iso27001": true,
    "iso9001": false,
    "iso45001" : true
}'
```