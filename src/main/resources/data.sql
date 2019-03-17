-- INITIAL DICTONARY DATA
-- PaymentType
insert ignore into payment_type(id, type) values (1, 'Składka');
insert ignore into payment_type(id, type) values (2, 'Zrzutka');
insert ignore into payment_type(id, type) values (3, 'Inne');
-- Currencies
insert ignore into currency(id, currency) values (1, 'PLN');
insert ignore into currency(id, currency) values (2, 'EUR');
insert ignore into currency(id, currency) values (3, 'USD');
insert ignore into currency(id, currency) values (4, 'CHF');
insert ignore into currency(id, currency) values (5, 'GBP');
insert ignore into currency(id, currency) values (6, 'JPY');
-- Roles
insert ignore into role(id, role) values (1, 'ADMIN');
insert ignore into role(id, role) values (2, 'MANAGEMENT');
insert ignore into role(id, role) values (3, 'REGION');
insert ignore into role(id, role) values (4, 'OFFICE');
-- Member statuses
insert ignore into member_status(id, status) values (1, 'Członek');
insert ignore into member_status(id, status) values (2, 'Kandydat');
insert ignore into member_status(id, status) values (3, 'Brak płatności');
insert ignore into member_status(id, status) values (4, 'Odrzucony');
insert ignore into member_status(id, status) values (5, 'Usunięty');
-- Regions
insert ignore into region(id, name, leadership) values (1, 'Centralno-wschodni', 'Warszawa');
insert ignore into region(id, name, leadership) values (2, 'Centralny', 'Łódź');
insert ignore into region(id, name, leadership) values (3, 'Południowy', 'Kraków');
insert ignore into region(id, name, leadership) values (4, 'Północno-wschodni', 'Gdańsk');
insert ignore into region(id, name, leadership) values (5, 'Północno-zachodni', 'Poznań');
insert ignore into region(id, name, leadership) values (6, 'Zachodni', 'Wrocław');
insert ignore into region(id, name, leadership) values (7, 'Zagranica', 'Zagranica');
-- Voivodeship
insert ignore into voivodeship(id, name, email, region_id) values (1, 'mazowieckie', 'warszawa@nomail.pl', 1);
insert ignore into voivodeship(id, name, email, region_id) values (2, 'lubelskie', 'warszawa@nomail.pl', 1);
insert ignore into voivodeship(id, name, email, region_id) values (3, 'podlaskie', 'warszawa@nomail.pl', 1);

insert ignore into voivodeship(id, name, email, region_id) values (4, 'łódzkie', 'lodz@nomail.pl', 2);
insert ignore into voivodeship(id, name, email, region_id) values (5, 'kujawsko-pomorskie', 'lodz@nomail.pl', 2);
insert ignore into voivodeship(id, name, email, region_id) values (6, 'świętokrzyskie', 'lodz@nomail.pl', 2);

insert ignore into voivodeship(id, name, email, region_id) values (7, 'małopolskie', 'krakow@nomail.pl', 3);
insert ignore into voivodeship(id, name, email, region_id) values (8, 'podkarpackie', 'krakow@nomail.pl', 3);
insert ignore into voivodeship(id, name, email, region_id) values (9, 'śląskie', 'krakow@nomail.pl', 3);

insert ignore into voivodeship(id, name, email, region_id) values (10, 'pomorskie', 'trojmiasto@nomail.pl', 4);
insert ignore into voivodeship(id, name, email, region_id) values (11, 'warmińsko-mazurskie', 'trojmiasto@nomail.pl', 4);

insert ignore into voivodeship(id, name, email, region_id) values (12, 'wielkopolskie', 'poznan@nomail.pl', 5);
insert ignore into voivodeship(id, name, email, region_id) values (13, 'zachodniopomorskie', 'szczecin@nomail.pl', 5);
insert ignore into voivodeship(id, name, email, region_id) values (14, 'lubuskie', 'poznan@nomail.pl', 5);

insert ignore into voivodeship(id, name, email, region_id) values (15, 'dolnośląskie', 'wroclaw@nomail.pl', 6);
insert ignore into voivodeship(id, name, email, region_id) values (16, 'opolskie', 'wroclaw@nomail.pl', 6);

insert ignore into voivodeship(id, name, email, region_id) values (17, 'ANGLIA', 'kontakt@nomail.pl', 7);
insert ignore into voivodeship(id, name, email, region_id) values (18, 'HOLANDIA', 'kontakt@nomail.pl', 7);
insert ignore into voivodeship(id, name, email, region_id) values (19, 'NIEMCY', 'kontakt@nomail.pl', 7);
insert ignore into voivodeship(id, name, email, region_id) values (20, 'Zagranica inne', 'kontakt@nomail.pl', 7);
