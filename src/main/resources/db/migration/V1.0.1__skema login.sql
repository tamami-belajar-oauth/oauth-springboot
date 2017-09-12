create table login (
    id serial not null primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    active boolean default true
);

insert into login(username, password, active)
  values('tamami','rahasia',true);

insert into login(username, password, active)
  values('tamu','tamu',true)
