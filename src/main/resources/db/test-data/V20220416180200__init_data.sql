insert into out_system(id, name)
values (nextval('out_system_seq'), 'TagAllSmartSystem');

insert into out_system_key(id, out_system_id, key)
values (nextval('out_system_key_seq'), currval('out_system_seq'), '2db75760-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Детская школа исскуств "Центр"');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Академия цифровых технологий');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Администрация Петроградского района');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Центр по работе с населением "Преображенец"');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Поставщик бытовой техники');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75a1c-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Поставщик концелярских товаров');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75bca-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Поставщик строительных товаров');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75d46-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Поставщик услгу ремонта и диагностики');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75ed6-bd8f-11ec-9d64-0242ac120002');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Диагностика оборудования', 1, 30000.0, 30000.0, '2022-04-16 15:28:30',
        '2022-04-16 23:28:30', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Строительные товары', 2, 60000.0, 60000.0, '2022-04-16 23:36:10',
        '2022-04-17 01:36:10', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Услуги технического обслуживания', 3, 25000.0, 25000.0, '2022-04-16 20:18:50',
        '2022-04-17 03:00:50',
        0.05, 'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Отчистка вентиляци', 4, 15000.0, 15000.0, '2022-04-16 19:56:40', '2022-04-17 19:56:40',
        0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Ремонт электро-дверей', 1, 18000.0, 18000.0, '2022-04-16 19:56:40',
        '2022-04-17 19:56:40', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Концелярские товары', 2, 8000.0, 8000.0, '2022-04-16 19:55:40', '2022-04-17 19:55:40',
        0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Набор лампочек', 3, 2000.0, 2000.0, '2022-04-16 20:14:40', '2022-04-17 20:14:40', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Услуга грузоперевозки', 4, 45000.0, 45000.0, '2022-04-16 15:45:40',
        '2022-04-17 15:45:40', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Принтеры LaserJet', 3, 120000.0, 120000.0, '2022-04-16 23:30:40',
        '2022-04-17 23:40:40', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, end_time, bet, location,
                     status)
values (nextval('session_seq'), 'Обновление операциооной системы', 2, 20000.0, 20000.0, '2022-04-16 19:56:40',
        '2022-04-17 19:56:40', 0.05,
        'г. Санкт-Петербург', 'ACTIVE');
