# Ghost Net Fishing

Dieses Projekt ist ein Prototyp einer Webanwendung zur Meldung und Bergung von Geisternetzen. Es wurde im Rahmen der Fallstudie im Kurs IPWA02-01 entwickelt.

## Ziel der Anwendung

Die Anwendung ermöglicht es, Geisternetze zu erfassen, bergenden Personen zuzuordnen und den Status der Geisternetze zu verwalten. Zusätzlich können Geisternetze als geborgen oder verschollen markiert werden.

## Umgesetzte Anforderungen

Im Prototyp wurden folgende Anforderungen umgesetzt:

1. Geisternetze können durch meldende Personen erfasst werden.
2. Eine bergende Person kann sich für die Bergung eines Geisternetzes eintragen.
3. Offene beziehungsweise noch zu bergende Geisternetze können angezeigt werden.
4. Eine bergende Person kann ein Geisternetz als geborgen markieren.
5. Eine beliebige Person kann ein Geisternetz als verschollen melden.

## Verwendete Technologien

- Java
- Spring Boot
- Spring Web
- Thymeleaf
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

## Datenhaltung

Die Anwendung verwendet eine dateibasierte H2-Datenbank. Die Daten werden lokal im Ordner `data` gespeichert. Dieser Ordner ist nicht Teil des Git-Repositorys, da er nur lokale Testdaten enthält.

## Anwendung starten

Die Anwendung kann mit dem Maven Wrapper gestartet werden:

```powershell
.\mvnw.cmd spring-boot:run
```

Anschließend ist die Anwendung im Browser erreichbar unter:

http://localhost:8080

## H2-Konsole

Die H2-Konsole ist erreichbar unter:

http://localhost:8080/h2-console

Verbindungsdaten:

JDBC URL: jdbc:h2:file:./data/ghostnetdb  
User Name: sa  
Password:

## Wichtige Seiten

/                      Startseite  
/ghostnets             Übersicht aller Geisternetze  
/ghostnets/open        Noch zu bergende Geisternetze  
/ghostnets/new         Neues Geisternetz melden

## Hinweis

Die Anwendung ist als funktionaler Prototyp umgesetzt. Der Schwerpunkt liegt auf der Umsetzung der ausgewählten Anforderungen, der persistenten Datenhaltung und einer nachvollziehbaren Schichtenstruktur.
