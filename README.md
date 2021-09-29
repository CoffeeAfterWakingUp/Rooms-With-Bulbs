# Rooms-With-Bulbs

### Инструкция по развертыванию окружения к проекту

###### *Проект написан в Intellij IDEA 2021.1.3 Ultimate, использовались openjdk 11.0.3, Tomcat Server v. 9.0.33, XAMPP для СУБД MySQL поэтому для развертывания окружения понадобятся все данные инструменты

1. Откройте XAMPP и запустите MySQL.После запуска, через кнопку “Admin” переходите на страницу (http://localhost/phpmyadmin/).
2. Создайте БД “rooms_with_bulbs” через кнопку “Создать БД”.Charset:utf8_general_ci.
3. В верхнем меню выбираете “Импорт”.В импортируемый файл выбираете sql файл “room_with_bulbs.sql”, кодировка файла utf-8.Нажимаете кнопку “Вперед”.
4. В файле ConnectionPool.properties (путь к файлу ...resources\ConnectionPool.properties) укажите или измените настройки для доступа к созданной БД (в случае необходимости)
5. Необходимо подключить сервер Apache Tomcat для запуска проекта. Нажимаете в меню Run – Edit configuration. Затем в левом верхнем углу значок ‘+’ и выбираете Tomcat Server – Local.
6. Появится окно - настройки сервера – выбираете заранее установленный Tomcat 9.0.33 в качестве Application server, затем указываете JRE 11.
7. После выбираете вкладку “Deployment”,нажимате на ‘+’ и выбираете артефакт “Rooms-With-Bulbs:war exploded”.Application context должен быть ‘/’

![Снимок экрана (81)](https://user-images.githubusercontent.com/76391010/135253128-b047b0fa-ca84-4d05-acef-70b5c1467173.png)

![Снимок экрана (80)](https://user-images.githubusercontent.com/76391010/135253157-6441095a-ff76-4255-a726-198ebd770ca8.png)

8. Для подключения к базе данных нажмите в правой части IDEA на вкладку Database и затем выберите MySQL в меню ‘+’
![Снимок экрана (82)](https://user-images.githubusercontent.com/76391010/135253419-1a7060cc-9233-47de-8677-5922f0cbbed9.png)

9. В открывшемся окне вводите название БД «rooms_with_bulbs», затем пользователь «root»,пароль должен быть пустым,URL можете взять из ConnectionPool.properties.После проверяете соединение кнопкой Test.Результат должен быть successful. Жмете Ок, БД соединена.
![Снимок экрана (79)](https://user-images.githubusercontent.com/76391010/135253345-ceae1c95-73b3-4f23-927e-7b997da85145.png)
10. Можно запускать приложение.


