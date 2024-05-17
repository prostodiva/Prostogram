CREATE TABLE users (
id serial primary key,
first_name varchar(50),
last_nama varchar(50),
profile_name varchar(50),
signup_date date,
email varchar(50),
password varchar(50)
);

CREATE TABLE post (
id serial primary key,
user_id int references users (id),
created_date date,
post_type int references post_type (id)
);

CREATE TABLE post_media (
id serial primary key,
post_id int references post (id),
media_data bytea,
position int
);

CREATE TABLE follower (
following_id int references users (id),
followed_id int references users (id)
);

CREATE TABLE reaction (
user_id int references users(id),
post_id int references post(id)
);

CREATE TABLE comment (
id serial primary key,
post_id int references post (id),
created_date date,
comment text,
comment_replied_to_id int references users(id)
);

CREATE TABLE post_type (
id serial primary key,
post_type_name varchar(50)
);