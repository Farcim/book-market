create sequence hibernate_sequence start 20 increment 1;
create table if not exists author
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table if not exists genre
(
    id   int4 generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table if not exists book
(
    id    bigint generated by default as identity,
    name  varchar(255),
    price int4,
    primary key (id)
);
create table if not exists author_genre
(
    id        bigint generated by default as identity,
    author_id bigint default null,
    genre_id  int4   default null,
    primary key (id)
);
create table if not exists book_author
(
    id        bigint generated by default as identity,
    book_id   bigint default null,
    author_id bigint default null,
    primary key (id)
);
create table if not exists genre_book
(
    id       bigint generated by default as identity,
    genre_id int4   default null,
    book_id  bigint default null,
    primary key (id)
);
-- alter table if exists author_genre
--     add constraint author_genre_genre_id foreign key (genre_id) references genre;
--
-- alter table if exists author_genre
--     add constraint author_genre_author_id foreign key (author_id) references author;
--
-- alter table if exists book_author
--     add constraint book_author_book_id foreign key (book_id) references book;
--
-- alter table if exists book_author
--     add constraint book_author_author_id foreign key (author_id) references author;
--
-- alter table if exists book_genre
--     add constraint book_genre_book_id foreign key (genre_id) references genre;
--
-- alter table if exists book_genre
--     add constraint book_genre_genre_id foreign key (book_id) references book;