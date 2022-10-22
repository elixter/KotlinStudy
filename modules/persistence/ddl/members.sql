-- auto-generated definition
create table members
(
    id       bigint auto_increment
        primary key,
    name     varchar(50)                  not null,
    login_id varchar(30)                  not null,
    password varchar(256)                 not null comment 'sha256',
    email    varchar(100)                 not null,
    role     varchar(10) default 'MEMBER' not null,
    constraint UNIQUE_IDX_EMAIL
        unique (email),
    constraint UNIQUE_IDX_LOGIN_ID
        unique (login_id)
)