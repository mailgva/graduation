DROP TABLE IF EXISTS voting;
DROP TABLE IF EXISTS daily_menu;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants (name);


CREATE TABLE dishes
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  price            DECIMAL                 NOT NULL,
  rest_id          INTEGER,
  FOREIGN KEY (rest_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX dishes_unique_name_rest_idx ON dishes (rest_id, name);


CREATE TABLE daily_menu (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date        DATE    NOT NULL,
  rest_id     INTEGER NOT NULL,
  dish_id     INTEGER NOT NULL,
  FOREIGN KEY (dish_id) REFERENCES dishes (id)      ON DELETE CASCADE
);
CREATE UNIQUE INDEX dailymenu_unique_date_rest_dish_idx ON daily_menu (date, rest_id, dish_id);

CREATE TABLE voting (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER   NOT NULL,
  rest_id     INTEGER   NOT NULL,
  date        DATE      NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)       ON DELETE CASCADE,
  FOREIGN KEY (rest_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX voting_unique_user_rest_date_idx ON voting (user_id, rest_id, date);

