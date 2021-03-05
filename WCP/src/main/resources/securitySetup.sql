create table SEC_USER
(
  userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName         VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;


create table SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;


create table USER_ROLE
(
  ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('jon', '$2a$10$dmBY.Fn1uZfGYn0.5Z7rZe0delHFdQNBeCxBKr9WE2HD4xfx68TLG', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('tod', '$2a$10$dmBY.Fn1uZfGYn0.5Z7rZe0delHFdQNBeCxBKr9WE2HD4xfx68TLG', 1);
 

 
insert into sec_role (roleName)
values ('ROLE_OWNER');
 
insert into sec_role (roleName)
values ('ROLE_CASHIER');
 
insert into user_role (userId, roleId)
values (1, 1);
 
insert into user_role (userId, roleId)
values (1, 2);
 
insert into user_role (userId, roleId)
values (2, 2);