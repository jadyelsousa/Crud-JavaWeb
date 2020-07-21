create database db_projeto_final;
use db_projeto_final;

create table categoria (
   id_categoria int auto_increment primary key,
   nm_categoria varchar(35) not null);
   
create table usuario (
   email varchar(80) not null primary key,
   nm_usuario varchar(100) not null,
   dt_nascimento date not null,
   senha varchar(150) not null);
   
create table bebida (
   sku varchar(20) not null primary key,
   nm_bebida varchar(60) not null,
   ds_bebida varchar(255),
   teor_alcoolico float,
   vl_bebida decimal(7,2) not null,
   qt_bebida int not null,
   tp_bebida enum('Internacional','Nacional'),
   fk_categoria int,
   foreign key (fk_categoria) references categoria(id_categoria));
   

