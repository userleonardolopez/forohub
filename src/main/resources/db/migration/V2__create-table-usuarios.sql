
CREATE TABLE usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null unique,
    clave varchar(500) not null,

    primary key(id)

);