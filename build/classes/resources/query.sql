/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  00348046
 * Created: 07/05/2024
 */

create database formfam ;
use formfam;
create table clientes(
    codcli int primary key AUTO_INCREMENT,
    nome varchar(60) not null,
    endereço varchar(60),
    fone varchar(20)
);

use formfam;
create table logar(
    login varchar(100),
    senha varchar(10)
);