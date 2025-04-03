drop database if exists restaurant_system;
create database restaurant_system;
use restaurant_system;

create table Endereco(
	id int primary key auto_increment,
    pais varchar(100) not null default 'Brasil',
    estado varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    rua varchar(100) not null,
    numero int not null
);

create table Cliente(
	id int primary key auto_increment,
    nome varchar(150) not null,
    cpf char(11) not null unique,
    telefone varchar(20) not null unique,
    email varchar(150) not null unique,
    data_cadastro datetime not null default current_timestamp,
    
    endereco_id int not null,
    foreign key(endereco_id) references Endereco(id)
    on update cascade
    on delete cascade
);

create table Funcionario(
	id int primary key auto_increment,
    nome varchar(150) not null,
    cpf char(11) not null unique,
    telefone varchar(20) not null unique,
    email varchar(150) not null unique,
    salario decimal(6, 2) not null,
    cargo varchar(100) not null,
    data_contratacao datetime not null default current_timestamp,
    
    endereco_id int not null,
    foreign key(endereco_id) references Endereco(id)
    on update cascade
    on delete cascade
);

create table Pedido(
	id int primary key auto_increment,
    data_pedido datetime not null default current_timestamp,
    status_pedido varchar(50) not null,
    total double not null,
    observacoes text,
    
    cliente_id int not null,
    foreign key(cliente_id) references Cliente(id)
    on update cascade
    on delete cascade,
    funcionario_id int not null,
    foreign key(funcionario_id) references Funcionario(id)
    on update cascade
    on delete set null
);

create table CategoriaProduto(
	id int primary key auto_increment,
    nome varchar(150) not null,
    descricao text not null
);

create table Produto(
	id int primary key auto_increment,
    nome varchar(150) not null,
    descricao text not null,
    data_cadastro datetime not null default current_timestamp,
    estoque int not null,
    preco decimal(6,2) not null,
    categoria_produto_id int not null,
    foreign key(categoria_produto_id) references CategoriaProduto(id)
    on update cascade
    on delete set null
);

create table Consumo(
	pedido_id int not null,
    produto_id int not null,
	quantidade int not null,
    foreign key(pedido_id) references Pedido(id)
    on update cascade
    on delete cascade,
    foreign key(produto_id) references Produto(id)
    on update cascade
    on delete cascade,
    primary key(pedido_id, produto_id)
);

