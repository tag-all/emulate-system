insert into out_system(id, name)
values (nextval('out_system_seq'), 'Портал Поставщиков');

insert into out_system_key(id, out_system_id, key)
values (nextval('out_system_key_seq'), currval('out_system_seq'), '2db75760-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Детская школа исскуств "Центр"');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75a1c-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Академия цифровых технологий');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75bca-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Администрация Петроградского района');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75d46-bd8f-11ec-9d64-0242ac120002');

insert into customer(id, company_name)
values (nextval('customer_seq'), 'Центр по работе с населением "Преображенец"');
insert into customer_key(id, customer_id, key)
values (nextval('customer_key_seq'), currval('customer_seq'), '2db75ed6-bd8f-11ec-9d64-0242ac120002');

insert into session (id, name, customer_id, start_price, current_price, start_time, duration_time, bet, location,
                     status)
values (nextval('session_seq'), 'Диагностика оборудования', 1, 30000.0, 30000.0, '2022-04-16 15:28:30', 10800, 0.5,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, duration_time, bet, location,
                     status)
values (nextval('session_seq'), 'Строительные товары', 2, 60000.0, 60000.0, '2022-04-15 17:36:10', 86400, 0.5,
        'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, duration_time, bet, location,
                     status)
values (nextval('session_seq'), 'Услуги технического обслуживания', 3, 25000.0, 25000.0, '2022-04-11 11:18:50', 21600,
        0.5, 'г. Санкт-Петербург', 'ACTIVE');

insert into session (id, name, customer_id, start_price, current_price, start_time, duration_time, bet, location,
                     status)
values (nextval('session_seq'), 'Отчистка вентиляци', 4, 15000.0, 15000.0, '2022-04-02 22:56:40', 86400, 0.5,
        'г. Санкт-Петербург', 'ACTIVE');
