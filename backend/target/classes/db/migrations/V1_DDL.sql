CREATE TABLE users (
id serial primary key,
first_name text,
last_name text,
profile_name text,
created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
email text,
password text
);

CREATE TABLE post (
id serial primary key,
user_id int references users (id),
created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
post_type int references post_type (id)
);

CREATE TABLE post_media (
id serial primary key,
post_id int references post (id),

// change to S3
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
created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
comment text,
comment_replied_to_id int references users(id)
);

CREATE TABLE post_type (
id serial primary key,
post_type_name varchar(50)
);