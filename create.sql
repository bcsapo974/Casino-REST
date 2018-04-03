create table entry (id bigint not null auto_increment, enter datetime not null, leave datetime, person_id bigint not null, primary key (id)) engine=MyISAM
create table game (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=MyISAM
create table person (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=MyISAM
create table play (id bigint not null auto_increment, end datetime, start datetime not null, game_id bigint not null, person_id bigint not null, primary key (id)) engine=MyISAM
alter table game add constraint UKjare70vqqti665ds3b2eh7rk8 unique (name)
alter table entry add constraint FKs8bmeq648q8k65x9045qyh844 foreign key (person_id) references person (id)
alter table play add constraint FKh5dyrwenqcpiuqbsl417ioqhs foreign key (game_id) references game (id)
alter table play add constraint FKh3tpmww81sy7i4ej2ix737xec foreign key (person_id) references person (id)
