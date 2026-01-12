create table DBprog3.Amministratore
(
    nome_utente varchar(40) not null
        primary key,
    password    varchar(40) not null
);

create table DBprog3.Utente
(
    email    varchar(40) not null
        primary key,
    password varchar(30) not null
);

create table DBprog3.Prodotto
(
    nome            varchar(45)  not null,
    quantità_scorta int          not null,
    codice          varchar(10)  not null
        primary key,
    costo           float        not null,
    descrizione     varchar(150) not null,
    categoria       varchar(20)  not null
);

create table DBprog3.Acquistato
(
    data                datetime    not null,
    quantità_acquistata int         not null,
    metodo_pagamento    varchar(30) not null,
    IDordine            varchar(30) not null
        primary key,
    email               varchar(40) not null,
    codice              varchar(10) not null
);

create index acquistato_Prodotto_codice_fk
    on DBprog3.Acquistato (codice);

create index acquistato_Utente_email_fk
    on DBprog3.Acquistato (email);

create table DBprog3.Raccomanda
(
    email       varchar(40) not null,
    codice      varchar(10) not null,
    nome_utente varchar(40) not null,
    primary key (email, codice, nome_utente),
    constraint Raccomanda_Amministratore_nome_utente_fk
        foreign key (nome_utente) references dbprog3.Amministratore (nome_utente),
    constraint Raccomanda_Prodotto_codice_fk
        foreign key (codice) references dbprog3.Prodotto (codice),
    constraint Raccomanda_Utente_email_fk
        foreign key (email) references dbprog3.Utente (email)
);

