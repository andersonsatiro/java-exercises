drop database if exists alunos;
create database alunos;
use alunos;

create table aluno(
	numero int primary key,
    nome varchar(150) not null,
    curso varchar(150) not null,
    nota1 double not null,
    nota2 double not null,
    nota3 double not null,
    nota4 double not null
);

insert into aluno values(1, "Anderson", "Informática", 8, 7, 7, 8);

select * from aluno;