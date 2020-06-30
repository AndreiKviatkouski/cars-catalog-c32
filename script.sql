create sequence messageforadvert_date_seq;

alter sequence messageforadvert_date_seq owner to postgres;

create table advert
(
    id                  serial not null,
    mark                varchar,
    model               varchar,
    color               varchar,
    yearcar             integer,
    price               double precision,
    id_user             integer,
    dateadvert          varchar,
    specificationadvert varchar
);

alter table advert
    owner to postgres;

create table messageforadvert
(
    id       serial not null
        constraint messageforadvert_pk
            primary key,
    idadvert integer,
    iduser   integer,
    body     varchar,
    date     varchar
);

alter table messageforadvert
    owner to postgres;

create unique index messageforadvert_id_uindex
    on messageforadvert (id);

create table userscarcatalog
(
    id       serial not null
        constraint userscarcatalog_pk
            primary key,
    name     varchar,
    lastname varchar,
    login    varchar,
    password varchar,
    phone    varchar,
    role     varchar
);

alter table userscarcatalog
    owner to postgres;

create unique index userscarcatalog_column_1_uindex
    on userscarcatalog (id);

create table useradvertlist
(
    iduser   integer,
    idadvert integer
);

alter table useradvertlist
    owner to postgres;

create table car
(
    mark  varchar,
    model varchar
);

alter table car
    owner to postgres;


