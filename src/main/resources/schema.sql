create table if not exists Applicform3(
   id bigint auto_increment primary key,
   dateOfPost varchar(255),
   sortOfWork varchar(255),
   houseNumber int not null,
   message varchar(255) not null,
   status varchar(255)
);
