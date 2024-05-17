CREATE TABLE user (
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
user_id int references user (id),
created_datetime datetime2,
post_type int references post_type (id)
);

CREATE TABLE post_media (
id serial primary key,
post_id int references post (id),
media_file binary,
position int
);

CREATE TABLE follower (
following_id int references user (id),
followed_id int references user (id)
);

CREATE TABLE reaction (
user_id int references user(id),
post_id references post(id)
);

CREATE TABLE comment (
id serial primary key,
post_id references post (id),
created_datetime datetime2,
comment text,
comment_replied_to_id int references user(id)
);

CREATE TABLE post_type (
id serial primary key,
post_type_name varchar(50)
);