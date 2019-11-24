insert into board (id, name, description) values (10001, 'Board 1', 'Awesome board');
insert into board (id, name, description) values (10002, 'Board 2', 'Regular board');
insert into board (id, name, description) values (10003, 'Board 3', 'Terrible board');

insert into label_group (id, name, board_id) values (2001, 'Label Group 1', 10001);
insert into label_group (id, name, board_id) values (2002, 'Label Group 2', 10001);
insert into label_group (id, name, board_id) values (2003, 'Label Group 3', 10002);

insert into card (id, label_id) values (1001, 2001);
insert into card (id, label_id) values (1002, 2001);
insert into card (id, label_id) values (1003, 2001);