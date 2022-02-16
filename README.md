# SpielDesLebens
Das ist einen Java Implementation von "Conways Spiel des Lebens" siehe [hier](https://de.wikipedia.org/wiki/Conways_Spiel_des_Lebens). <br>
Das Spiel ist in einem 25x25 Raster aufgebaut.
## Regeln
1. Jede Zelle die weniger als 2 lebende Nachbarn hat, stirbt an Vereinsamung
2. Jede Zelle die mehr als 3 lebende Nachbarn hat, stirbt an Überbefölkerung
3. Jede Zelle die 2 lebende Nachbarn hat, überlebt die nächste Generation
4. Jede Zelle die 3 lebende Nachbarn hat, bekommt ein Kind und erzeugt eine neue Zelle um sich.

## Infos
Das Makefile ist für Linux gemacht. Um das Makefile unter Windows zu nutzen muss Make und 
das JDK vorinstalliert sein, hierbei genügt der Befehl "make run".
* "make install" erzeugt eine jar-Datei
* "make compile" um zu kompilieren
* "make run" um auszuführen
* "make prepare" benötigte Pakete installieren (Linux)
* "make clean" Alles weg was du nicht mehr brauchst
* "make all" = prepare compile & run
