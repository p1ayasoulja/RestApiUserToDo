create sequence hibernate_sequence start 1 increment 1;

create table usr
(
    id       int8         not null,
    password varchar(255) not null,
    username varchar(255) not null unique,
    primary key (id)
);
create table todo
(
    id        int8    not null,
    title     varchar(255),
    completed boolean not null,
    primary key (id)
);