
CREATE TABLE topicos(

    id bigint not null auto_increment,
    titulo varchar(50) not null unique,
    mensaje varchar(500) not null unique,
    fecha_creacion varchar(10) not null,
    status varchar(20) not null,
    autor varchar(20) not null,
    curso varchar(100) not null,

    primary key(id)

);