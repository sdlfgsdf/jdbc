create table user
(
    id       int auto_increment
        primary key,
    name     varchar(32) not null,
    password varchar(32) not null,
    age      varchar(32) not null,
    sex      char        not null,
    email    varchar(32) not null
);