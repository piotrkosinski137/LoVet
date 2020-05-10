create table if not exists users
(
    id       varchar(255) not null,
    email    varchar(255),
    password varchar(255),
    role     varchar(255),
    primary key (id)
);


create table if not exists pet_owner
(
    id           varchar(255) not null,
    name         varchar(255),
    surname      varchar(255),
    phone_number varchar(255),
    primary key (id)
);


create table if not exists pet_owner_pet_id
(
    pet_owner_id varchar(255),
    pet_id       binary(16),
    FOREIGN KEY (pet_owner_id) REFERENCES pet_owner (id)
);

create table if not exists pet
(
    id            binary(16) not null,
    name          varchar(255),
    date_of_birth DATE,
    type          varchar(255),
    photo_url     varchar(255),
    primary key (id)
);

create or replace view pet_overview as
select p.id,
       p.name,
       p.type,
       p.photo_url,
       po_pi.pet_owner_id
from pet p
         join pet_owner_pet_id po_pi
where po_pi.pet_id = p.id;

create or replace view pet_owner_overview as
select p.id,
       p.name,
       p.surname,
       p.phone_number
from pet_owner p;
