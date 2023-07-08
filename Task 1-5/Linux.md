1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными (заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

mkdir final_work
cd final_work/
cat > pets
    собаки
    кошки
    хомяки
cat > pack_animals
    лошади
    верблюды
    ослы
cat pets pack_animals > animals
cat animals
mv animals human_friends
ll

2. Создать директорию, переместить файл туда.

mkdir Control_work
mv human_friends Control_work/
cd Control_work/
ll

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

apt update
apt list mysql-server mysql-client
apt-get install mysql-server
apt-get install mysql-client

4. Установить и удалить deb-пакет с помощью dpkg.

wget https://dev.mysql.com/get/mysql-apt-config_0.8.25-1_all.deb
dpkg -i mysql-apt-config_0.8.25-1_all.deb
dpkg --purge mysql-apt-config mysql-client-8.0 mysql-client-core-8.0 mysql-common mysql-server-8.0 mysql-server-core-8.0

5. Выложено в отдельном файле
