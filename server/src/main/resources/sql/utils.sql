SELECT * FROM user_account;


INSERT INTO user_account (id,name,login,phone,password,email,role) values (4,'kek','kek','kek','kek','kek','Waiter');

INSERT INTO user_account (id,name,login,phone,password,email, role) values (2,'kek2','kek2','kek2','kek2','kek2','Waiter');

INSERT INTO user_account (id,name,login,phone,password,email,role) values (3,'kek3','kek3','kek3','kek3','kek3','Waiter');


DELETE FROM user_account WHERE id = (SELECT id FROM user_account);

INSERT INTO restaurant (id, name, description, location, cousine, rate, waiter) values (1, 'Пряности и Радости',
                                                                                'Сегодня решил таки попробовать ягненка на косточке. Здесь ягненок визуально был очень симпатичен, качество мясо отменное, но вот той хрустящей корочки здесь тоже, увы, нет...Хотя в целом ягненок неплох, неплох... ',
                                                                             'СПб', 'Украинская', 0, 1);


INSERT INTO restaurant (id, name, description, location, cousine, rate, waiter) values (2, 'Спаггети Хренети',
                                                                                'Макарохи, пицца, сыры иногда бывают и винище рекой как положено!',
                                                                                'СПб', 'Итальянская', 0, 2);

INSERT INTO restaurant (id, name, description, location, cousine, rate, waiter) values (3, 'Терраса',
                                                                                'Пофоткаться можно кушать не стоит слишком дорого лучше в мак сходи или в дикси дошик купи)))',
                                                                                'СПб', 'Испанская', 0, 3);

SELECT * FROM restaurant;


