create table users  (
    username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null
);

insert into users(username, password, enabled)
  values('tamami','rahasia',true);