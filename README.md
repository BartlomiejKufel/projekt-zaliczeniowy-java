<div align="center">
    <h1>Projekt Zaliczeniowy</h1>
    <h3>
        Przedmiot: programowanie obiektowe 1<br> 
        Język Java💻
    <h3>
    <h4>Temat: System quizowy</h4>
</div>


<picture align="center">
  <source srcset="/assets/crowdle_baner_white.jpg" media="(prefers-color-scheme: dark)">
  <img src="/assets/crowdle_baner_black.jpg" alt="baner crowdle">
</picture>

## 📝 Zarys projektu
    
Crowdle to gra quizowa, której tematyka nawiązuje do kruków – jednych z najmądrzejszych ptaków na naszej planecie.
Rozgrywka jest prosta: gracz rozwiązuje quiz z pytaniami przypisanymi do jednej z sześciu kategorii:
Historia, Nauka i Technologia, Kultura i Sztuka, Mitologia i Legendy, Geografia, Popkultura.

Za poprawne odpowiedzi i uzyskanie odpowiedniego procentu punktów gracz zdobywa punkty rankingowe i może wspinać się po szczeblach systemu rang.
W przypadku niepowodzenia w quizie, gracz traci punkty i spada w rankingu.

### 🏆 Tabela Rang

| Ranga                   | Od ilu punktów | Punkty za wygraną | Punkty za przegraną |
|-------------------------|:--------------:|:-----------------:|:-------------------:|
| **Pisklę Cienia**       | 0              | +10               | 0                   |
| **Młody Kruk**          | 100            | +12               | -2                  |
| **Obserwator Gałęzi**   | 250            | +14               | -4                  |
| **Szept Lasu**          | 400            | +16               | -6                  |
| **Strażnik Ksiąg**      | 600            | +18               | -8                  |
| **Kruk Zagadek**        | 850            | +20               | -10                 |
| **Cień Proroctwa**      | 1100           | +22               | -12                 |
| **Wiedzący Kruk**       | 1400           | +24               | -14                 |
| **Mistrz Czarnych Piór**| 1750           | +26               | -16                 |
| **Król Kruków**         | 2150           | +28               | -18                 |



W grze dostępna będzie tabela rankingowa, która pozwoli graczom poczuć nutę rywalizacji.

### 🎧 dodatkowo gracz będzie mógł:
* przeglądać swoje statystyki,
* odczytywać powiadomienia,
* uruchamiać gry różnym poziomem trudności pytań,
* a także zmieniać nazwę użytkownika i hasło.

### 🛠️ administrator, oprócz funkcji dostępnych dla zwykłych graczy, będzie mógł dodatkowo:
* zmieniać nazwę użytkownika lub hasło dowolnego gracza,
* wysyłać powiadomienia do graczy,
* dodawać nowe pytania do bazy danych,
* eksportować listę najlepszych graczy w całej grze.

<br>

## 💻 Jak uruchomić aplikację?

### Dodanie bazy danych
1. Uruchom program <b>pgadmin4</b>.
2. Stwórz nową bazę danych o nazwie <b>crowdle</b>.
3. Następnie naciśnij prawym przyciskiem na myszce na bazę danych i z listy wybierz opcję <b>Restore</b>.
4. W oknie <b>Restore</b> wybierz format <b>Custom or tar</b> i plik backup z folderu <b>DBstructure</b> z rozszerzeniem <b>sql</b>.
5. Następnie naciśnij przycisk <b>Restore</b>.

### Uruchomienie aplikacji
1. Uruchom folder <b>crowdle</b> w programie <b>IntelliJ IDEA Community Edition 2024.3.3</b>.
2. Sprawdź plik `./src/main/resources/hibernate.cfg.xml` w razie potrzeby zmień dane do bazy danych login, hasło lub url do bazy danych.
3. Na końcu wejdź w plik `./src/main/java/com/crowdle/MainApplication.java` i uruchom program.

### Aby korzystać z aplikacji
Możesz zalogować się na stworzone już konto w bazie danych:
* Administrator - login: <b>admin</b>, hasło: <b>admin</b>.  
* Użytkownik - login: <b>user</b>, hasło: <b>user</b>.

Lub stworzyć nowe konto na stronie rejestracji. Pamiętaj że konta stworzone w aplikacji zawsze będą kontami użytkowników. 
