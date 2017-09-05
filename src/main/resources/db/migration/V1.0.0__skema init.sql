create table role (
    id serial primary key,
    name varchar(50) not null
);

create table users (
    id serial not null primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    role_id integer references role(id)
);

insert into role(name) values('ROLE_VIEW');
insert into role(name) values('ROLE_UPDATE');


insert into users(username, password, role_id)
  values('tamami','rahasia',1);
insert into users(username, password, role_id)
  values('tamami','rahasia',2);