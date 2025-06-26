CREATE SCHEMA vote_app AUTHORIZATION postgres;

CREATE TABLE vote_app.artists
(
    id integer NOT NULL,
    name character varying NOT NULL,
    count_of_votes integer DEFAULT 0,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS vote_app.artists
    OWNER to postgres;

CREATE TABLE vote_app.genres
(
    id integer NOT NULL,
    name character varying NOT NULL,
    count_of_votes integer DEFAULT 0,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS vote_app.genres
    OWNER to postgres;

CREATE TABLE vote_app.abouts
(
    id integer NOT NULL,
    text text NOT NULL,
    datetime timestamp(6) without time zone NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS vote_app.abouts
    OWNER to postgres;

CREATE TABLE vote_app.votes
(
    dt_create timestamp(6) without time zone NOT NULL,
    artist_id character varying NOT NULL,
    genre_1_id character varying NOT NULL,
    genre_2_id character varying NOT NULL,
    genre_3_id character varying NOT NULL,
    genre_4_id character varying,
    genre_5_id character varying,
    about text NOT NULL
);

ALTER TABLE IF EXISTS vote_app.votes
    OWNER to postgres;