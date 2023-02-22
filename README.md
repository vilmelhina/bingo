# Bingo
Snabbt ihopslängt bingo, just nu fills dessa filer:
* `Bingo.java`: main, skapar bingobrickor med `BoardGenerator` och skapar tabeller av dem med `BingoBoard`, lägger dem på en PDF
* `BingoBoard.java`: Behöver kanske byta namn, klass som gör en tabell på PDF-en med en bingobricka
* `BingoCell.java`: Tänkt att representera en ruta som _kan_ finnas med på en bingobricka, innehåller text-strängen + information som kan användas när bingobricka genereras (på vilkas bricka den inte ska vara, vilka som måste vara närvarande för att den ska få vara med på en bricka)
* `BoardGenerator.java`: klass för att skapa en bingobricka. Just nu ges bara arrayer med strängar. Den ser till att en bricka inte har repeterade rutor, men inte mer avancerad än så
* `Players.java`: enum av spelare
* `bingorutor.json`: alla möjliga bingo-celler som man kan välja mellan när en bingobricka görs

`BingoCell` lagrar information som kan användas för att välja ut mer specifikt vilka celler som får vara på vilkas brickor, men det används inte

I `bingorutor.json` finns ett fält som heter "disabled", så det går att lägga in brickor som temporärt inte används