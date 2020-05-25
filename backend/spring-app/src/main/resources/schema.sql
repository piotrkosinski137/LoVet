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

create table if not exists pet
(
    id            binary(16) not null,
    name          varchar(255),
    date_of_birth DATE,
    type          varchar(255),
    photo_url     varchar(255),
    primary key (id)
);

create table if not exists pet_owner_pet
(
    pet_owner_id varchar(255),
    pet_id       binary(16),
    FOREIGN KEY (pet_owner_id) REFERENCES pet_owner (id),
    FOREIGN KEY (pet_id) REFERENCES pet (id)
);

create table if not exists doctor
(
    id           varchar(255) not null,
    name         varchar(255),
    surname      varchar(255),
    phone_number varchar(255),
    speciality   varchar(255),
    primary key (id)
);

create or replace view doctor_overview as
select d.id,
       d.name,
       d.surname
from doctor d;

create table if not exists visit
(
    id binary(16) not null,
    pet_id binary(16) not null,
    doctor_id varchar(255),
    visit_date DATE,
    description varchar(2048),
    is_booked boolean,
    primary key (id)
);

create table if not exists doctor_visit
(
    doctor_id varchar(255),
    visit_id  binary(16),
    FOREIGN KEY (doctor_id) REFERENCES doctor (id),
    FOREIGN KEY (visit_id) REFERENCES visit (id)
);

create or replace view visit_overview as
    select
           v.id,
           v.doctor_id,
           v.pet_id,
           v.visit_date,
           v.description,
           v.is_booked,
           d.name as doctor_name,
           d.surname as doctor_surname,
           p.name as pet_name
    from visit v
        left join doctor d on v.doctor_id = d.id
        left join pet p on v.pet_id = p.id;

create or replace view pet_overview as
select p.id,
       p.name,
       p.type,
       p.photo_url,
       po_p.pet_owner_id
from pet p
         join pet_owner_pet po_p
where po_p.pet_id = p.id;

create or replace view pet_owner_overview as
select p.id,
       p.name,
       p.surname,
       p.phone_number
from pet_owner p;
