
CREATE SCHEMA IF NOT EXISTS barrierfree autorization postgres;

CREATE TABLE IF NOT EXISTS barrierfree.users
(
    user_id SERIAL primary key,
    first_name character varying(50),
    last_name  character varying(50),
    login character varying(60) unique,
    password character varying(70),
    mail character varying(70) unique
);

select * from barrierfree.users;

insert into barrierfree.users (first_name, last_name, login, password, mail)
values ('Ivan', 'Ivanov', 'login', 'password', 'ivan@gmail.com');

CREATE SCHEMA IF NOT EXISTS barrierfree autorization postgres;

CREATE TABLE IF NOT EXISTS barrierfree.status
(
    status SERIAL primary key
);

CREATE TABLE IF NOT EXISTS barrierfree.role (
id bigserial constraint role_pk primary key,
"name" character varying(20) not null
);
alter table barrierfree.users add foreign key (status_id) references barrierfree.user_status(status_id);

alter TABLE barrierfree.users add column references barrierfree.user_role;

INSERT INTO users(user_id, first_name, last_name, login,
			password, mail, status_id,
		   role_id) VALUES('Tom', 'Soyer', 'tom5444', 'password', 'tom@gmail.com'
								 );
								 INSERT INTO user_role(role_id, user_id) VALUES (USER,0);
