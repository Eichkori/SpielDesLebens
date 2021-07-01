# klassen.SpielDesLebens
Das ist einen Java Implementation von "Conways Spiel des Lebens" siehe [hier](https://de.wikipedia.org/wiki/Conways_Spiel_des_Lebens). <br>
Das Spiel ist in einem 25x25 Raster aufgebaut.
## Regeln
1. Jede klassen.Zelle die weniger als 2 lebende Nachbarn hat, stirbt an Vereinsamung
2. Jede klassen.Zelle die mehr als 3 lebende Nachbarn hat, stirbt an Überbefölkerung
3. Jede klassen.Zelle die 2 lebende Nachbarn hat, überlebt die nächste Generation
4. Jede Jelle die 3 lebende Nachbarn hat, bekommt ein Kind und erzeugt eine neue klassen.Zelle um sich.

## Infos
Das Makefile ist für Linux gemacht.