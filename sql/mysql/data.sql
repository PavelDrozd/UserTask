/*
truncate table users;
truncate table roles;
*/

insert into roles values
		("CUSTOMER_USER"),
		("SALE_USER"),
		("ADMINISTRATOR"),
		("SECURE_API_USER");

insert into users values
		("admin", "adminL", "adminP", "admin@gmail.com", "2"),
		("user", "customer", "customer_user", "customer@gmail.com", "0"),
		("user", "sale", "sale_user", "sale@gmail.com", "1"),
		("user", "secure", "secure_api_user", "secure@gmail.com", "3");
		("Aleksandra", "Fedorova", "Olegovna", "aleksandra_fedorova_25@gmail.com", "3");
		("Egor", "Kiselev", "Michailovich", "egor000@gmail.com", "1"),
		("Adnrey", "Parfenov", "Emirovich", "andrey2000@gmail.com", "0"),
		("Maxim", "Orlov", "Andreevich", "maximorlov1@gmail.com", "0"),
		("Arina", "Radionova", "Aleksandrovna", "arina32@gmail.com", "0"),
		("Eva", "Cudryavceva", "Aleksandrovna", "eva_aleksandrovna33@gmail.com", "0"),
		("Kirill", "Firsov", "Lvovich", "kirill_firsov_lvovich@gmail.com", "0"),
		("Emilia", "Belousova", "Michailovna", "emilia_22356@gmail.com", "0"),
		("Nikita", "Sokolov", "Yaroslavovich", "sokolov1995@gmail.com", "0");