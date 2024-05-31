create table configs
(
    id    bigint generated always as identity,
    name  varchar(200) not null unique,
    properties varchar(200)
);