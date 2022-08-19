create table applicants(
	id serial primary key NOT NULL,
	full_name varchar(128),
	email varchar(64),
	description text,
	create_date timestamp,
	cv_file_name varchar(64),
	files bigint,
	applied bool,
	viewed bool
);

create table files(
	id serial primary key not null,
	name varchar(256),
	files bytea,
	create_date timestamp
);

create table vacancies(
	id serial primary key not null,
	short_name varchar(128),
	description text,
	grade int
);

create table persons(
	id serial primary key not null,
	family_name varchar(64),
	first_name varchar(64),
	last_name varchar(64),
	email varchar(64),
	sex char,
	birthday date,
	job_title varchar(128),
	description text,
	grade int,
	create_date timestamp,
	status int,
	user_id bigint,
	document_id bigint,
	organisation_tier_id bigint
);

create table persons_documents(
	id serial primary key not null,
	passport_id bigint,
	snils_id bigint,
	insurance_id bigint,
	work_book_id bigint
);

create table organisation_tier(
	id serial primary key not null
);


create table roles(
	name varchar(32)
);


create table users(
	id serial primary key not null,
	login varchar(32),
	password varchar(256),
	create_date timestamp,
	status int
);

create table department(
	id serial primary key not null,
	dep_name varchar(255),
	is_sub_dep bool,
	sub_dep_id bigint,
	description text,
	create_date timestamp,
	created_by bigint

);

create TABLE persons_history(
	id Serial PRIMARY KEY not null,
	person_id BIGINT,
	create_date TIMESTAMP,
	create_by VARCHAR(128),
	operation varchar(1024)
);


create table documents_type(
  id Serial not null primary key,
  name varchar(256),
  prefix varchar(32),
  create_date timestamp,
  user_id bigint
);


create table documents(
  id Serial not null primary key,
  name varchar(256),
  prefix varchar(32),
  external_id varchar(256),
  document_type_id bigint,
  document_body text,
  create_date timestamp,
  modify_date timestamp,
  version varchar(128),
  person_id bigint,
  user_id bigint
);