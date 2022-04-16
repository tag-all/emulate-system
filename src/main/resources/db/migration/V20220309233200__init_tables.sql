create sequence customer_seq start 1;
create table customer
(
    id           int primary key,
    company_name varchar(255)
);

create sequence customer_key_seq start 1;
create table customer_key
(
    id          int primary key,
    customer_id int references customer (id),
    key         varchar(128) not null
);

create sequence out_system_seq start 1;
create table out_system
(
    id   int primary key,
    name varchar(255) not null
);

create sequence out_system_key_seq start 1;
create table out_system_key
(
    id            int primary key,
    out_system_id int references out_system (id),
    key           varchar(128) not null
);

create sequence session_seq start 1;
create table session
(
    id                   int primary key,
    name                 varchar(255) not null,
    customer_id          int references customer (id),
    start_price          real         not null,
    current_price        real check (current_price <= start_price),
    start_time           timestamp    not null,
    duration_time        int          not null,
    bet                  real         not null,
    location             varchar(255) not null,
    last_bet_customer_id int references customer (id),
    status               varchar(255) not null
);