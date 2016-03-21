/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     21.03.2016 18:58:59                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('KURSY') and o.name = 'FK_KURSY_AUTOKAR_W_AUTOKARY')
alter table KURSY
   drop constraint FK_KURSY_AUTOKAR_W_AUTOKARY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('KURSY') and o.name = 'FK_KURSY_KIEROWCA__KIEROWCY')
alter table KURSY
   drop constraint FK_KURSY_KIEROWCA__KIEROWCY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRZYSTANKI') and o.name = 'FK_PRZYSTAN_PRZYSTANK_MIEJSCOW')
alter table PRZYSTANKI
   drop constraint FK_PRZYSTAN_PRZYSTANK_MIEJSCOW
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REJESTR_PRZEJAZDOW') and o.name = 'FK_REJESTR__RELATIONS_KURSY')
alter table REJESTR_PRZEJAZDOW
   drop constraint FK_REJESTR__RELATIONS_KURSY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TRASA') and o.name = 'FK_TRASA_RELATIONS_KURSY')
alter table TRASA
   drop constraint FK_TRASA_RELATIONS_KURSY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TRASA') and o.name = 'FK_TRASA_TRASA_PRZ_PRZYSTAN')
alter table TRASA
   drop constraint FK_TRASA_TRASA_PRZ_PRZYSTAN
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AUTOKARY')
            and   type = 'U')
   drop table AUTOKARY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KIEROWCY')
            and   type = 'U')
   drop table KIEROWCY
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('KURSY')
            and   name  = 'kierowca_wykonujacy_trase_FK'
            and   indid > 0
            and   indid < 255)
   drop index KURSY.kierowca_wykonujacy_trase_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('KURSY')
            and   name  = 'autokar_wykonujacy_trase_FK'
            and   indid > 0
            and   indid < 255)
   drop index KURSY.autokar_wykonujacy_trase_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KURSY')
            and   type = 'U')
   drop table KURSY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MIEJSCOWOSCI')
            and   type = 'U')
   drop table MIEJSCOWOSCI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRZYSTANKI')
            and   name  = 'przystanki_w_miejscowosci_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRZYSTANKI.przystanki_w_miejscowosci_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRZYSTANKI')
            and   type = 'U')
   drop table PRZYSTANKI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REJESTR_PRZEJAZDOW')
            and   name  = 'Relationship_7_FK'
            and   indid > 0
            and   indid < 255)
   drop index REJESTR_PRZEJAZDOW.Relationship_7_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REJESTR_PRZEJAZDOW')
            and   type = 'U')
   drop table REJESTR_PRZEJAZDOW
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TRASA')
            and   name  = 'Relationship_6_FK'
            and   indid > 0
            and   indid < 255)
   drop index TRASA.Relationship_6_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TRASA')
            and   name  = 'trasa_przystanki_FK'
            and   indid > 0
            and   indid < 255)
   drop index TRASA.trasa_przystanki_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TRASA')
            and   type = 'U')
   drop table TRASA
go

/*==============================================================*/
/* Table: AUTOKARY                                              */
/*==============================================================*/
create table AUTOKARY (
   AUT_KEY              int                  not null,
   AUT_Marka            varchar(15)          null,
   AUT_Model            varchar(15)          null,
   AUT_Rok_Prod         datetime             null,
   AUT_Poj_silnik       decimal              null,
   "AUT_Spalanie_l/km"  int                  null,
   AUT_Kat_autokaru     varchar(15)          null,
   AUT_Iloœæ_miejsc     int                  null,
   AUT_Nr_rejestracji   varchar(15)          null,
   constraint PK_AUTOKARY primary key nonclustered (AUT_KEY)
)
go

/*==============================================================*/
/* Table: KIEROWCY                                              */
/*==============================================================*/
create table KIEROWCY (
   KIE_KEY              int                  not null,
   KIE_Imie             varchar(20)          null,
   KIE_Nazwisko         varchar(30)          null,
   KIE_Pesel            int                  null,
   KIE_Data_zatr        datetime             null,
   constraint PK_KIEROWCY primary key nonclustered (KIE_KEY)
)
go

/*==============================================================*/
/* Table: KURSY                                                 */
/*==============================================================*/
create table KURSY (
   KUR_KEY              int                  not null,
   AUT_KEY              int                  not null,
   KIE_KEY              int                  not null,
   KUR_Sygnatura_Kursu  varchar(10)          null,
   KUR_Opis             varchar(50)          null,
   KUR_Czas_Odjazdu     datetime             null,
   KUR_Czas_Przyjazdu   datetime             null,
   KUR_Iloœæ_pasa¿erów  int                  null,
   constraint PK_KURSY primary key nonclustered (KUR_KEY)
)
go

/*==============================================================*/
/* Index: autokar_wykonujacy_trase_FK                           */
/*==============================================================*/
create index autokar_wykonujacy_trase_FK on KURSY (
AUT_KEY ASC
)
go

/*==============================================================*/
/* Index: kierowca_wykonujacy_trase_FK                          */
/*==============================================================*/
create index kierowca_wykonujacy_trase_FK on KURSY (
KIE_KEY ASC
)
go

/*==============================================================*/
/* Table: MIEJSCOWOSCI                                          */
/*==============================================================*/
create table MIEJSCOWOSCI (
   MIE_KEY              int                  not null,
   MIE_Nazwa_Miejscow   varchar(30)          null,
   MIE_Województwo      varchar(30)          null,
   MIE_Powiat           varchar(30)          null,
   MIE_Gmina            varchar(30)          null,
   constraint PK_MIEJSCOWOSCI primary key nonclustered (MIE_KEY)
)
go

/*==============================================================*/
/* Table: PRZYSTANKI                                            */
/*==============================================================*/
create table PRZYSTANKI (
   PR_KEY               int                  not null,
   MIE_KEY              int                  null,
   PR_Ulica             varchar(30)          null,
   constraint PK_PRZYSTANKI primary key nonclustered (PR_KEY)
)
go

/*==============================================================*/
/* Index: przystanki_w_miejscowosci_FK                          */
/*==============================================================*/
create index przystanki_w_miejscowosci_FK on PRZYSTANKI (
MIE_KEY ASC
)
go

/*==============================================================*/
/* Table: REJESTR_PRZEJAZDOW                                    */
/*==============================================================*/
create table REJESTR_PRZEJAZDOW (
   REJ_KEY              int                  not null,
   KUR_KEY              int                  null,
   REJ_data             datetime             null,
   REJ_iloscOsob        int                  null,
   constraint PK_REJESTR_PRZEJAZDOW primary key nonclustered (REJ_KEY)
)
go

/*==============================================================*/
/* Index: Relationship_7_FK                                     */
/*==============================================================*/
create index Relationship_7_FK on REJESTR_PRZEJAZDOW (
KUR_KEY ASC
)
go

/*==============================================================*/
/* Table: TRASA                                                 */
/*==============================================================*/
create table TRASA (
   TR_KEY               int                  not null,
   KUR_KEY              int                  null,
   PR_KEY               int                  null,
   TR_Dzieñ_tyg         varchar(20)          null,
   TR_Godzina           time                 null,
   TR_Uwagi             varchar(60)          null,
   constraint PK_TRASA primary key nonclustered (TR_KEY)
)
go

/*==============================================================*/
/* Index: trasa_przystanki_FK                                   */
/*==============================================================*/
create index trasa_przystanki_FK on TRASA (
PR_KEY ASC
)
go

/*==============================================================*/
/* Index: Relationship_6_FK                                     */
/*==============================================================*/
create index Relationship_6_FK on TRASA (
KUR_KEY ASC
)
go

alter table KURSY
   add constraint FK_KURSY_AUTOKAR_W_AUTOKARY foreign key (AUT_KEY)
      references AUTOKARY (AUT_KEY)
go

alter table KURSY
   add constraint FK_KURSY_KIEROWCA__KIEROWCY foreign key (KIE_KEY)
      references KIEROWCY (KIE_KEY)
go

alter table PRZYSTANKI
   add constraint FK_PRZYSTAN_PRZYSTANK_MIEJSCOW foreign key (MIE_KEY)
      references MIEJSCOWOSCI (MIE_KEY)
go

alter table REJESTR_PRZEJAZDOW
   add constraint FK_REJESTR__RELATIONS_KURSY foreign key (KUR_KEY)
      references KURSY (KUR_KEY)
go

alter table TRASA
   add constraint FK_TRASA_RELATIONS_KURSY foreign key (KUR_KEY)
      references KURSY (KUR_KEY)
go

alter table TRASA
   add constraint FK_TRASA_TRASA_PRZ_PRZYSTAN foreign key (PR_KEY)
      references PRZYSTANKI (PR_KEY)
go

