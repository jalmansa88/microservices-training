insert into user (name, birth_date) values ('javi', sysdate());
insert into user (name, birth_date) values ('pepe', sysdate());
insert into user (name, birth_date) values ('juan', sysdate());

insert into post (description, user_id) values ('first post de javi', select id from user where name = 'javi');
insert into post (description, user_id) values ('first post de pepe', select id from user where name = 'pepe');