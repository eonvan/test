
    create table CREDIT_APPLICATION (
        id int8 not null,
        APPLICANT varchar(255),
        BANK varchar(255),
        RATING float8,
        STATUS varchar(255),
        primary key (id)
    );

    create sequence hibernate_sequence;
