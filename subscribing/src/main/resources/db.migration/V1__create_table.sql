create table `subscribing_db`.coach (id bigint not null auto_increment, login varchar(255), password varchar(255), primary key (id));
create table `subscribing_db`.sportsmen (group_id smallint, id bigint not null auto_increment, number_workouts bigint, last_name varchar(255), name varchar(255), primary key (id));
create table `subscribing_db`.groups_param (grope_workout tinyint check (grope_workout between 0 and 2), id smallint not null auto_increment, is_frozen bit not null, primary key (id));
alter table `subscribing_db`.sportsmen add constraint FK39hcdsq8nmnqma2mo5avx84kf foreign key (group_id) references groups_param (id);
