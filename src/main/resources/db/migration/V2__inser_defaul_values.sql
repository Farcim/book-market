insert into genre (id, name)
values (1, 'COMEDIAN'),
       (2, 'DRAMA'),
       (3, 'ROMAN'),
       (4, 'ADVENTURE');

insert into author(id, name)
values (1, 'A.S.Pushkin');

insert into book(id, name, price)
values (1, 'Сказка о царе Салтане', 24);

insert into author_genre(author_id, genre_id)
values (1, 1);

insert into book_genre(genre_id, book_id)
values (1, 1);

insert into book_author(author_id, book_id)
values (1, 1);