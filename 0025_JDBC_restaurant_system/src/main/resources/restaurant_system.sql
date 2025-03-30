drop database if exists restaurant_system;
create database restaurant_system;
use restaurant_system;

create table Endereco(
	id int primary key auto_increment,
    pais varchar(100) not null default 'Brasil',
    estado varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    rua varchar(100) not null,git
    numero int not null
);

create table Cliente(
	id int primary key auto_increment,
    nome varchar(150) not null,
    cpf char(11) not null unique,
    telefone varchar(20) not null unique,
    email varchar(150) not null unique,
    data_cadastro datetime not null, /* desejo que especifique a data atual como padrao */
    
    endereco_id int not null,
    foreign key(endereco_id) references Endereco(id)
);

create table Funcionario(
	id int primary key auto_increment,
    nome varchar(150) not null,
    cpf char(11) not null unique,
    telefone varchar(20) not null unique,
    email varchar(150) not null unique,
    salario double not null,
    cargo varchar(100) not null,
    data_contratacao datetime not null, /* desejo que se caso nenhuma data de contratacao for passada, preencher coluna com a data do momento */
    
    endereco_id int not null,
    foreign key(endereco_id) references Endereco(id)
);

create table Pedido(
	id int primary key auto_increment,
    data_pedido datetime not null, /* Desejo que especifique a data atual como padrao */
    status_pedido varchar(50) not null,
    total double not null,
    observacoes varchar(200),
    
    cliente_id int not null,
    foreign key(cliente_id) references Cliente(id),
    funcionario_id int not null,
    foreign key(funcionario_id) references Funcionario(id)
);
