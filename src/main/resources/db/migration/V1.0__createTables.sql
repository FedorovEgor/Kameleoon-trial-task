DROP TABLE IF EXISTS users;
CREATE TABLE users
(
	user_id SERIAL PRIMARY KEY,
	user_first_name varchar(255),
	user_last_name varchar(255),
	user_email varchar UNIQUE,
	user_password varchar(255),
	registration_date timestamp
);

DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes
(
    quote_id SERIAL PRIMARY KEY,
    user_id int REFERENCES users(user_id),
    text varchar,
    creation_date timestamp,
    like_counter int DEFAULT 0
);

DROP TABLE IF EXISTS votes;
CREATE TABLE votes
(
    vote_id SERIAL PRIMARY KEY,
    quote_id int REFERENCES quotes(quote_id),
    user_id int REFERENCES users(user_id),
    is_upvote boolean,
    creation_date timestamp
);