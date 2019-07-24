create database Cleaning

use Cleaning

DROP TABLE VOTOS
DROP TABLE USUARIO
DROP TABLE CONSERJE

create table votos(
idVoto int primary key identity,
tipo varchar(10) not null, 
voto int not null,
fecha datetime,
)

CREATE TABLE Usuario(
id int primary key identity,
nombre varchar(20),
password varchar(20))

CREATE TABLE conserje(
id int primary key identity,
nombre varchar(40),
cedula varchar(15),
telefono varchar(15),
inicioTurno time,
finTurno time)

---INSERT VOTOS--
insert into votos values ('Regular',1,GETDATE())
insert into votos values ('Regular',1,GETDATE())

insert into votos values ('Normal',1,GETDATE())
insert into votos values ('Normal',1,GETDATE()+1)

insert into votos values ('Bueno',1,GETDATE())
insert into votos values ('Bueno',1,GETDATE()-1)

insert into votos values ('Bueno',1,'2019-04-20')

select * from votos
select tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de votos', fecha from votos group by tipo, fecha

----INSERT USUARIOS---
INSERT INTO usuario VALUES('Admin','admin');
SELECT * FROM usuario

----INSERT CONSERJE----
INSERT INTO Conserje VALUES('Juan Perez','402-1523640-9','809-536-6547','22:00','08:00')
SELECT * FROM Conserje



select tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos', fecha from votos group by tipo, fecha


---------REPORTES ANUALES---------
SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',DATENAME(month,fecha) +', 2019' as Meses
FROM votos WHERE YEAR(fecha) = 2019
GROUP BY DATEPART(month, Fecha),DATENAME(month,fecha), tipo
ORDER BY DATEPART(month, Fecha) ASC


---------REPORTE MENSUAL (MES ACTUAL)-------------
SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',DATENAME(month,fecha) +', 2019' as Mes
FROM votos WHERE MONTH(fecha) = MONTH(GETDATE())
GROUP BY DATEPART(month, Fecha),DATENAME(month,fecha), tipo
ORDER BY DATEPART(month, Fecha) ASC



-------REPORTE DIARIO (DIA DE HOY)-----------------
SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',CONVERT(VARCHAR(10),fecha, 105) as "Fecha Actual"
FROM votos WHERE DAY(fecha) = DAY(GETDATE())
GROUP BY DATEPART(day, Fecha),DATENAME(day,fecha), tipo, CONVERT(VARCHAR(10),fecha, 105)
ORDER BY DATEPART(day, Fecha) ASC


