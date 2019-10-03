create table table_leads(
    id int auto_increment,
    firstname varchar(255),
    lastname varchar(255),
    dob datetime,
    age int,
    phone_number varchar(255),

    constraint pk_table_leads_id primary key (id)
);

