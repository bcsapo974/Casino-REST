INSERT INTO PERSON (name) VALUES ('John');
INSERT INTO PERSON (name) VALUES ('Jane');
INSERT INTO PERSON (name) VALUES ('Brian');
INSERT INTO PERSON (name) VALUES ('Cathy');

INSERT INTO GAME (name) VALUES ('Poker');
INSERT INTO GAME (name) VALUES ('Roulette');
INSERT INTO GAME (name) VALUES ('Black Jack');

INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='John', to_date('20170101101010','YYYYMMDDHH24MISS'), to_date('20170101111010','YYYYMMDDHH24MISS'));
INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='John', to_date('20170501101010','YYYYMMDDHH24MISS'), to_date('20170501121010','YYYYMMDDHH24MISS'));
INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='Brian', to_date('20171106142255','YYYYMMDDHH24MISS'), to_date('20171106182255','YYYYMMDDHH24MISS'));
INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='Jane', to_date('20170408102030','YYYYMMDDHH24MISS'), to_date('20170408182530','YYYYMMDDHH24MISS'));
INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='Cathy', to_date('20170323191919','YYYYMMDDHH24MISS'), to_date('20170323193019','YYYYMMDDHH24MISS'));
INSERT INTO ENTRY(person_id, enter, leave) VALUES (select id from person where name='Cathy', to_date('20170920155011','YYYYMMDDHH24MISS'), to_date('20170920164011','YYYYMMDDHH24MISS'));

INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='John', select id from game where name='Roulette', to_date('20170101103010','YYYYMMDDHH24MISS'), to_date('20170101104210','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='John', select id from game where name='Poker', to_date('20170101104510','YYYYMMDDHH24MISS'), to_date('20170101110110','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='John', select id from game where name='Roulette', to_date('20170101104310','YYYYMMDDHH24MISS'), to_date('201701011044510','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Jane', select id from game where name='Black Jack', to_date('20170408122030','YYYYMMDDHH24MISS'), to_date('20170408144230','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Jane', select id from game where name='Roulette', to_date('20170408151530','YYYYMMDDHH24MISS'), to_date('20170408155530','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Cathy', select id from game where name='Black Jack', to_date('20170323192019','YYYYMMDDHH24MISS'), to_date('20170323192519','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Cathy', select id from game where name='Roulette', to_date('20170920155811','YYYYMMDDHH24MISS'), to_date('20170920162211','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Cathy', select id from game where name='Poker', to_date('20170323192619','YYYYMMDDHH24MISS'), to_date('20170323192919','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Brian', select id from game where name='Black Jack', to_date('20171106142255','YYYYMMDDHH24MISS'), to_date('20171106164555','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='Brian', select id from game where name='Roulette', to_date('20171106173111','YYYYMMDDHH24MISS'), to_date('20171106180155','YYYYMMDDHH24MISS'));
INSERT INTO PLAY(person_id, game_id, start, end) VALUES (select id from person where name='John', select id from game where name='Poker', to_date('20170501118010','YYYYMMDDHH24MISS'), to_date('20170501120010','YYYYMMDDHH24MISS'));
