insert into genre (id, name)
values (1, 'COMEDIAN'),
       (2, 'DRAMA'),
       (3, 'ROMAN'),
       (4, 'ADVENTURE');

insert into author(id, name)
values (1, 'A.S.Pushkin'),
       (2, 'Михаил Булгаков'),
       (3, 'Лев Толстой'),
       (4, 'Александр Грибоедов'),
       (5, 'Александр Куприн'),
       (6, 'A.S.Pushkin1'),
       (7, 'A.S.Pushkin2');

insert into book(id, name, price)
values (1, 'Сказка о царе Салтане', 241),
       (2, 'Роковые яйца', 242),
       (3, 'Война и мир', 243),
       (4, 'Горе от ума', 244),
       (5, 'Чудесный мир', 245);

insert into author_genre(author_id, genre_id)
values (1, 1),
       (2, 3),
       (3, 4),
       (4, 2),
       (5, 1),
       (6, 2),
       (7, 3);

insert into book_genre(genre_id, book_id)
values (1, 1),
       (2, 3),
       (3, 4),
       (4, 2),
       (5, 1);

insert into book_author(author_id, book_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);