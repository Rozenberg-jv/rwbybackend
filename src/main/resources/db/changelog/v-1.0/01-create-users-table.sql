create table users (
        id bigint not null auto_increment,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        password varchar(50) not null,
        email varchar(50) not null,
        employee_number varchar(100) not null,
        employee_position varchar(100) not null,
        organization_unit varchar(100) not null,
        enabled bit not null,
        date date,
        primary key (id)
    ) engine=InnoDB

GO


alter table users
       add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)

GO