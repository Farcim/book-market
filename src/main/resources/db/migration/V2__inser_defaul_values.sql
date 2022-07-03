insert into genre (id, name)
values (1, 'COMEDIAN'),
       (2, 'DRAMA'),
       (3, 'ROMAN'),
       (4, 'ADVENTURE');

insert into author(id, name)
values (1, 'Александ Пушкин'),
       (2, 'Михаил Булгаков'),
       (3, 'Лев Толстой'),
       (4, 'Александр Грибоедов'),
       (5, 'Александр Куприн'),
       (6, 'Василий Гоголь'),
       (7, 'Дмитрий Минделеев');

insert into book(id, name, price)
values (1, 'Сказка о царе Салтане', 241),
       (2, 'Роковые яйца', 242),
       (3, 'Война и мир', 243),
       (4, 'Горе от ума', 244),
       (5, 'Чудесный мир', 245),
       (6, 'Ужасный мир', 246),
       (7, 'Путеводитель', 247),
       (8, 'Мой компьютер', 248),
       (9, 'Что такое радуга', 249),
       (10, 'Переосмысление', 250),
       (11, 'Запретный плод', 251),
       (12, 'Мир наизнанку', 252),
       (13, 'Дом там где я спокоен', 253),
       (14, 'Лучший друг', 254),
       (15, 'Владимир Зеленский', 255),
       (16, 'Третий рейх', 256);

insert into author_genre(author_id, genre_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 1),
       (6, 2),
       (7, 3);

insert into genre_book(genre_id, book_id)
values (genre_id = 1, book_id = 1),
       (genre_id = 2, book_id = 2),
       (genre_id = 3, book_id = 3),
       (genre_id = 4, book_id = 4),
       (genre_id = 1, book_id = 5),
       (genre_id = 2, book_id = 6),
       (genre_id = 3, book_id = 7),
       (genre_id = 4, book_id = 8),
       (genre_id = 1, book_id = 9),
       (genre_id = 2, book_id = 10),
       (genre_id = 3, book_id = 11),
       (genre_id = 4, book_id = 12),
       (genre_id = 1, book_id = 13),
       (genre_id = 2, book_id = 14),
       (genre_id = 3, book_id = 15),
       (genre_id = 4, book_id = 16);

insert into book_author(book_id, author_id)
values (book_id = 1, author_id = 1),
       (book_id = 2, author_id = 2),
       (book_id = 3, author_id = 3),
       (book_id = 4, author_id = 4),
       (book_id = 5, author_id = 5),
       (book_id = 6, author_id = 6),
       (book_id = 7, author_id = 7),
       (book_id = 8, author_id = 1),
       (book_id = 9, author_id = 2),
       (book_id = 10, author_id = 1),
       (book_id = 11, author_id = 2),
       (book_id = 12, author_id = 3),
       (book_id = 13, author_id = 4),
       (book_id = 14, author_id = 5),
       (book_id = 15, author_id = 6),
       (book_id = 16, author_id = 7);