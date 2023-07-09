7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

CREATE DATABASE Human_friends;
USE Human_friends;

8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

CREATE TABLE Animals (id INT PRIMARY KEY, `Type of animal` VARCHAR(50));
INSERT INTO `Animals` (`id`,`Type of animal`)
    VALUES
    ('1','Pets'),
    ('2','Packs');

SELECT * FROM Animals;

DROP TABLE IF EXISTS Dogs;
CREATE TABLE Dogs (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Dogs` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('1','Bailey','Sit','2017-05-10'),
    ('1','Luna','Fetch','2019-09-02'),
    ('1','Max','Bark','2022-01-25');
SELECT * FROM Dogs;

DROP TABLE IF EXISTS Cats;
CREATE TABLE Cats (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Cats` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('1','Oliver','Sit','2018-03-15'),
    ('1','Bella','Climb trees','2019-07-05'),
    ('1','Leo','Catch mice','2021-11-20');
SELECT * FROM Cats;

DROP TABLE IF EXISTS Hamsters;
CREATE TABLE Hamsters (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Hamsters` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('1','Peanut','Run in wheel','2017-04-12'),
    ('1','Daisy','Eat seeds','2019-06-03'),
    ('1','Charlie','Jump around cage','2022-01-08');
SELECT * FROM Hamsters;

DROP TABLE IF EXISTS Horses;
CREATE TABLE Horses (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Horses` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('2','Amber','Go forward','2015-04-15'),
    ('2','Magnus','Stop','2018-07-08'),
    ('2','Zephyr','Roll over','2022-03-03');
SELECT * FROM Horses;

DROP TABLE IF EXISTS Camels;
CREATE TABLE Camels (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Camels` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('2','Sahara','Sit down','2015-03-20'),
    ('2','Atlas','Store water supply','2017-07-10'),
    ('2','Zara','Carry loads','2022-11-05');
SELECT * FROM Camels;

DROP TABLE IF EXISTS Donkeys;
CREATE TABLE Donkeys (id INT, `Name` VARCHAR(50), Commands VARCHAR(50), birthday DATE, FOREIGN KEY (id) REFERENCES Animals (id));
INSERT INTO `Donkeys` (`id`,`Name`,`Commands`,`birthday`)
    VALUES
    ('2','Jasper','Walk slowly','2016-04-10'),
    ('2','Rosie','Carry loads','2028-09-08'),
    ('2','Oscar','Bray','2022-02-03');
SELECT * FROM Donkeys;


10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

SELECT * FROM Camels;
DROP TABLE Camels;
CREATE TABLE Horses_Donkeys SELECT * FROM Horses
UNION ALL SELECT * FROM Donkeys;
SELECT * FROM Horses_Donkeys;

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице

DROP TABLE IF EXISTS Young_Animals;
CREATE TABLE Young_Animals SELECT * FROM Dogs
WHERE birthday + INTERVAL 1 YEAR < NOW() and birthday + INTERVAL 3 YEAR > NOW()
UNION ALL SELECT * FROM Cats
WHERE birthday + INTERVAL 1 YEAR < NOW() and birthday + INTERVAL 3 YEAR > NOW()
UNION ALL SELECT * FROM Hamsters
WHERE birthday + INTERVAL 1 YEAR < NOW() and birthday + INTERVAL 3 YEAR > NOW()
UNION ALL SELECT * FROM Horses_Donkeys
WHERE birthday + INTERVAL 1 YEAR < NOW() and birthday + INTERVAL 3 YEAR > NOW();

SELECT * FROM Young_Animals;

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

DROP TABLE IF EXISTS `All Animals`;
CREATE TABLE `All Animals` SELECT * FROM Dogs
UNION ALL SELECT * FROM Cats
UNION ALL SELECT * FROM Hamsters
UNION ALL SELECT * FROM Horses_Donkeys;

SELECT * FROM `All Animals