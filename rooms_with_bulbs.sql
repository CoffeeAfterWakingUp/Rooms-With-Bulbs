-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Сен 29 2021 г., 13:13
-- Версия сервера: 10.1.38-MariaDB
-- Версия PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `rooms_with_bulbs`
--

-- --------------------------------------------------------

--
-- Структура таблицы `country`
--

CREATE TABLE `country` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(255) NOT NULL,
  `code` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `country`
--

INSERT INTO `country` (`c_id`, `c_name`, `code`) VALUES
(1, 'Russian Federation', 'RU'),
(2, 'Kazakhstan', 'KZ'),
(3, 'Germany', 'DE');

-- --------------------------------------------------------

--
-- Структура таблицы `room`
--

CREATE TABLE `room` (
  `r_id` int(11) NOT NULL,
  `r_name` varchar(255) NOT NULL,
  `bulb` tinyint(1) NOT NULL,
  `country_id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `room`
--

INSERT INTO `room` (`r_id`, `r_name`, `bulb`, `country_id`, `user`) VALUES
(4, 'Room 4', 0, 2, '192.168.56.1'),
(5, 'Room 5', 1, 2, '192.168.56.1'),
(14, 'room 6', 1, 1, '192.168.56.1'),
(15, 'Room 12', 1, 1, '192.168.56.1'),
(16, 'room 13', 1, 2, '192.168.56.1'),
(17, 'Room 14', 1, 2, '192.168.56.1'),
(18, 'room 15', 1, 3, '192.168.56.1'),
(19, 'room 54', 1, 1, '192.168.56.1'),
(20, 'room 16', 0, 2, '192.168.56.1'),
(21, 'room 55', 1, 2, '192.168.56.1'),
(22, 'room 56', 1, 2, '192.168.56.1'),
(23, 'room 57', 1, 3, '192.168.56.1'),
(24, 'room 58', 1, 1, '192.168.56.1'),
(25, 'rrrrrrr', 1, 1, '192.168.56.1');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`c_id`);

--
-- Индексы таблицы `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `room_country_id_fk` (`country_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `country`
--
ALTER TABLE `country`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `room`
--
ALTER TABLE `room`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
