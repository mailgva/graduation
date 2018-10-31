DELETE FROM voting;
DELETE FROM daily_menu;
DELETE FROM dishes;
DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants (name) VALUES
  ('Ресторан 1'), -- 100002
  ('Ресторан 2'), -- 100003
  ('Ресторан 3'), -- 100004
  ('Ресторан 4'); -- 100005


INSERT INTO dishes (name, price) VALUES
  ('Салат Оливье', 50.0), -- 100006
  ('Салат Столичный', 40.0),
  ('Салат Цезарь', 90.0),
  ('Стейк', 150.0),
  ('Шашлык', 120.0),
  ('Салат Шефский', 70.0),  -- 100011
  ('Салат Греческий', 80.0),
  ('Стейк', 140.0),
  ('Шашлык', 130.0),
  ('Запеченные овощи', 110.0),
  ('Пицца', 125.0),
  ('Картошка Фри', 40.0),
  ('Картошка запеченная', 45.0),
  ('Стейк', 170.0),   -- 100019
  ('Шашлык', 135.0),
  ('Запеченные овощи', 70.0),
  ('Курица Гриль', 105.0),
  ('Сэндвич', 50.0),  --100023
  ('Суп Харчо', 60.0),
  ('Салат Шефский', 65.0),
  ('Салат Греческий', 75.0); -- 100026

/*
INSERT INTO dishes (rest_id, name, price) VALUES
  (100002, 'Салат Оливье', 50.0), -- 100006
  (100002, 'Салат Столичный', 40.0),
  (100002, 'Салат Цезарь', 90.0),
  (100002, 'Стейк', 150.0),
  (100002, 'Шашлык', 120.0),
  (100003, 'Салат Шефский', 70.0),  -- 100011
  (100003, 'Салат Греческий', 80.0),
  (100003, 'Стейк', 140.0),
  (100003, 'Шашлык', 130.0),
  (100003, 'Запеченные овощи', 110.0),
  (100003, 'Пицца', 125.0),
  (100003, 'Картошка Фри', 40.0),
  (100003, 'Картошка запеченная', 45.0),
  (100004, 'Стейк', 170.0),   -- 100019
  (100004, 'Шашлык', 135.0),
  (100004, 'Запеченные овощи', 70.0),
  (100004, 'Курица Гриль', 105.0),
  (100005, 'Сэндвич', 50.0),  --100023
  (100005, 'Суп Харчо', 60.0),
  (100005, 'Салат Шефский', 65.0),
  (100005, 'Салат Греческий', 75.0); -- 100026
*/


INSERT INTO daily_menu (date, dish_id, rest_id) VALUES
  ('2018-05-21', 100006, 100002),
  ('2018-05-21', 100007, 100002),
  ('2018-05-21', 100011, 100002),
  ('2018-05-21', 100012, 100003),
  ('2018-05-21', 100019, 100003),
  ('2018-05-21', 100020, 100003),
  ('2018-05-21', 100023, 100004),
  ('2018-05-21', 100024, 100004),
  ('2018-05-21', 100025, 100004),
  ('2018-05-22', 100008, 100002),
  ('2018-05-22', 100009, 100002),
  ('2018-05-22', 100015, 100002),
  ('2018-05-22', 100016, 100003),
  ('2018-05-22', 100021, 100003),
  ('2018-05-22', 100022, 100003),
  ('2018-05-22', 100025, 100004),
  ('2018-05-22', 100026, 100004);

/*
INSERT INTO daily_menu (date, dish_id) VALUES
  ('2018-05-21', 100006),
  ('2018-05-21', 100007),
  ('2018-05-21', 100011),
  ('2018-05-21', 100012),
  ('2018-05-21', 100019),
  ('2018-05-21', 100020),
  ('2018-05-21', 100023),
  ('2018-05-21', 100024),
  ('2018-05-21', 100025),
  ('2018-05-22', 100008),
  ('2018-05-22', 100009),
  ('2018-05-22', 100015),
  ('2018-05-22', 100016),
  ('2018-05-22', 100021),
  ('2018-05-22', 100022),
  ('2018-05-22', 100025),
  ('2018-05-22', 100026);
*/
