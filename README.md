# interactive-flashcards
The game  "SuperZapamiętywanka" - the interactive flashcards app in Java

Gra SuperZapamiętywanka polega na wyświetlaniu słów/wyrażeń na ekranie i wymaga od użytkownika skojarzenia ich z innymi odpowiednimi słowami/wyrażeniami w różnych trybach nauki wybieranych przez użytkownika. Gra może być więc używana jako standardowe fiszki do nauki języków, ale także jako program do nauki między innymi wzorów matematycznych, pierwiastków chemicznych, różnego rodzaju pojęć
naukowych, może być pomocna także przy nauce na teoretyczny egzamin prawa jazdy.

Gra wykorzystuje specjalny algorytm pozwalający na opanowanie wybranego przez użytkownika słownictwa w przeciągu kilku dni. Po uruchomieniu gry użytkownik wybiera odpowiedni tryb pracy (w zależności od swoich możliwości) – test na czas, zwykłe ćwiczenie bądź tryb dla dwóch użytkowników gdy nauka jest już ukończona – w ramach konkursu. Następnie jest on poddawany testowi – na przykład musi wpisać odpowiednie tłumaczenie słówka bądź skojarzyć odpowiedni wzór matematyczny z opisem – wszystko zależy od tego z jakiej bazy danych korzysta. Po podaniu odpowiedzi program sprawdza poprawność i podaje kolejny przykład, aż do ukończenia zestawu – chyba że użytkownik przerwie test. Na podstawie uzyskanych wyników generowany jest nowy zestaw, który wykorzystany będzie podczas kolejnej sesji egzaminacyjnej – o ile nauka danego zestawu nie zostaje ukończona. Jeśli użytkownik ukończył cały kurs wyświetlona zostaje informacja o efektach przebytego szkolenia. Odpowiednia szata graficzna – między innymi wyświetlanie kolorowego tekstu, animacje – pozwalają na wzrokowe zapamiętanie wiadomości.

PRZEBIEG GRY:

- Użytkownik uruchamia grę oraz wybiera bazę danych, z której będzie korzystał. Jeśli zaczął już kurs zobowiązany jest do kontynuowania go, w innym wypadku może wybrać tutorial, nową własną bądź jedną z zawartych w programie. 
- Tutorial to krótki test zawierający podpowiedzi oraz uczący obsługi gry.
- Własną bazę danych będzie można stworzyć w pliku tekstowym, sformatowanym w odpowiedni sposób (wszystkie parametry będą zawarte w tutorialu).
- Następnie wybierany jest tryb pracy. Użytkownik ma 3 możliwości – gra normalna, na czas lub dla dwóch graczy.
- Wówczas rozpoczyna się test – gracz ma za zadanie wpisać odpowiednie tłumaczenie wyświetlającego się słowa, odpowiedni wzór do opisu bądź wymagane wyrażenie – wszystko w zależności od tego jaką bazę danych wybrał lub stworzył. Po upływie czasu (w przypadku gry na czas) lub naciśnięcia odpowiedniego przycisku sprawdzana jest poprawność i wyświetlane jest kolejne zadanie, tak aż do wyczerpania bazy danych lub do przerwania gry przez użytkownika.
- Po zakończeniu gry generowana zostaje nowa baza danych (poprzez algorytm opisany powyżej) oraz plik zawierający statystyki.
- W celu optymalnego przyswajania wiadomości zaleca się korzystać z gry codziennie oraz tworzyć odpowiednie – nie za duże lecz też nie za małe – bazy danych.


Jako że program operuje na plikach tekstowych, użytkownik bardzo łatwo może nieświadomie usunąć istotne dla przebiegu rozgrywki pliki. Gra jest jednak odporna na przypadkowe usunięcie bądź niedozwolone próby ingerencji w treść bazy bądź statystyk -  wówczas generowane są nowe pliki oraz odblokowywana opcja wyboru nowej bazy do nauki.

W katalogu dist znajduje się plij jpwp.jar - skompilowana aplikacja oraz wszystkie potrzebne ilustracje i pliki tekstowe.

W katalogu src/jpwp znajdują się kody żródłowe programu.
