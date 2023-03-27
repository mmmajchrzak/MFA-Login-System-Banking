# MFA mobile banking app

## 1. Charakterystyka oprogramowowania 
* Nazwa pełna: **System bezpiecznej bankowości mobilnej na urządzenia z systemem Android**
* Krótki opis: Aplikacja mobilna na urządzenia z systemem operacyjnym Android, umożliwiająca użytkownikom bezpieczną bankowość mobilną. Aplikacja wykorzytuje MFA - Multi-factor authentication w celu zabezpieczenia aplikacji przed dostępem osób nieporządanych.
#### Cele: 
* System umożliwia klientom rejestrację konta i logowanie,
* Wymagane pola do rejestracji obejmują imię, nazwisko, numer ID klienta, adres e-mail oraz hasło,
* Klienci posiadają możliwość zmiany swojego hasła i innych danych profilu,
* Obsługa blędów - w przypadku nieprawidłowego wprowadzenia danych logowania, użytkownik otrzymuje stosowny komunikat,
* Hasła są przechowywane w bezpieczny sposób oraz są szyfrowane z poziomu w bazy danych,
* Aplikacja zawiera mechanizm uwierzytelniania wielopoziomowego (MFA), aby zwiększyć bezpieczeństwo logowania,
* Po zalogowaniu klient ma dostęp do panelu użytkownika, który zawiera informacje o saldzie, historii transakcji i innych funkcjach związanych z bankowością mobilną,
* Interfejs użytkownika jest prosty i łatwy w obsłudze,
* 

## 2. Prawa autorskie
* Autor: Michał Majchrzak
* Warunki licencyjne: **Licencja MIT**, Licencja MIT (ang. MIT License) to jedna z najpopularniejszych otwartych licencji oprogramowania. Jest to prosty dokument opisujący zasady korzystania, modyfikowania i rozpowszechniania kodu źródłowego w projekcie open source.

Zgodnie z tą licencją, użytkownik może korzystać, kopiować, modyfikować, publikować, dystrybuować, sprzedawać i/lub sub-licencjonować kod źródłowy bez ograniczeń, pod warunkiem, że każda kopia lub zmodyfikowana wersja zawiera odpowiednie powiadomienia o prawach autorskich i o tym, że użyto licencji MIT.

Licencja MIT jest uważana za bardzo liberalną, co oznacza, że pozwala na swobodne wykorzystywanie kodu źródłowego bez większych ograniczeń, co z kolei sprawia, że jest ona bardzo popularna wśród deweloperów i projektów open source.

## 3. Specyfikacja wymagań
1) **Wymagania funkcjonalne** 

|**Identyfikator**|**Nazwa krótka**|**Opis**|**Priorytet**|
| :-: | :-: | :-: | :-: |
|W\_FUN\_1|Wyświetlanie listy|Wymagane jest, aby aplikacja wyświetlała liste wiadomości. Lista ta powinna być skonstruowana z ostatnich 50 informacji dla konkretnej kategorii oraz strony internetowej. Aby umożliwić użytkownikowi szybkie odnalezienie najnowszych informacji, lista powinna być posortowana według daty ich dodania do aplikacji. Jako użytkownik systemu otrzymam dostęp do aktualnych informacji.|1 (wymagane)|
|W\_FUN\_2|Webscrapping danych| Wymagane jest, aby serwer był w stanie na żądanie klienta wykonać Web Scraping, czyli pozyskiwać informacje z stron internetowych, w celu zaktualizowania listy wiadomości. Dzięki temu, użytkownik będzie miał możliwość monitorowania listy informacji na bieżąco, a także ręcznego odświeżania jej za pomocą dedykowanego przycisku. |1 (wymagane)|
|W\_FUN\_3|Lista ulubionych informacji| Wymagane jest, aby aplikacja umożliwiała użytkownikowi dodawanie wiadomości do ulubionych w celu zapisania ich i dostępu do nich w późniejszym czasie. Dzięki temu funkcjonalności, użytkownik będzie miał możliwość zapisania interesujących go informacji i późniejszego wygodnego dostępu do nich. Zapisane informację będą dostępne w dedykowanym miejscu w aplikacji, co umożliwi użytkownikowi szybkie ich przeglądanie w każdej chwili. |2 (oczekiwana)|
|W\_FUN\_4|Filtrowanie informacji| Dzięki tej funkcjonalności, użytkownik będzie miał dostęp do filtrów, które pozwolą mu na precyzyjne określenie kategorii informacji oraz czasu publikacji oraz źródlowej strony internetowej. Opcje te umożliwią użytkownikowi łatwe i szybkie dostosowanie wyświetlanych wyników do swoich potrzeb. |2 (oczekiwana)|
|W\_FUN\_5|Podgląd wiadomości| Wymagane jest, aby aplikacja umożliwiała użytkownikowi podgląd wiadomości, a także dostęp do przycisku, który pozwoli mu na wyświetlenie pełnego artykułu z informacjami. Dzięki tej funkcjonalności, użytkownik będzie miał możliwość wglądu w interesujące go ogłoszenia w sposób bardziej szczegółowy, co pozwoli mu na dokładniejsze zapoznanie się z informacjami. Przycisk wyświetlający cały artykuł umożliwi użytkownikowi szybkie i łatwe uzyskanie dostępu do pełnych treści wiadomości.|2 (oczekiwana)|
|W\_FUN\_6|Przejście do wiadomości oryginalnej|Wymagane jest, aby aplikacja umożliwiała użytkownikowi przejście z wyświetlanej w niej wiadomości do oryginalnego artykułu na stronie źródłowej.Dzięki tej funkcjonalności, użytkownik będzie miał możliwość uzyskania pełnych informacji dotyczących danego ogłoszenia, przechodząc bezpośrednio do źródłowej strony internetowej. Przejście to będzie możliwe poprzez dedykowany przycisk lub link, co pozwoli na szybkie i łatwe uzyskanie dostępu do pełnych treści artykułu. |3 (dodatkowa)|
|W\_FUN\_7|Kontrola blędów dotycząca pobierania danych z serwera.|Wymagane jest, aby aplikacja zawierała mechanizm kontroli błędów dotyczący pobierania danych z serwera. Jeśli wystąpią problemy z połączeniem z serwerem, aplikacja powinna wyświetlić odpowiedni komunikat informujący użytkownika o problemie oraz udostępnić przycisk "Spróbuj ponownie", który umożliwi ponowienie próby pobrania danych. Dzięki temu użytkownik będzie miał możliwość łatwego i szybkiego rozwiązania problemu i uzyskania dostępu do pożądanych informacji.|2 (oczekiwana)|
|W\_FUN\_8|Konfiguracja |Wymagane jest, aby aplikacja umożliwiała użytkownikowi konfigurowanie opcji wyświetlania newsów oraz zapisywanie tej konfiguracji w pliku JSON.|3 (dodatkowa)|

2) **Wymagania niefuncjonalne**

|**Identyfikator**|**Podkategoria**|**Nazwa krótka**|**Opis**|**Priorytet**|
| :- | :- | :- | :- | :- |
|W\_NIEFUN\_1|3 - wydajność|Zapewnienie wydajności|Wymagane jest, aby aplikacja zapewniała wysoką wydajność oraz niezawodność działania, a także krótki czas ładowania danych.|1 (wymagane)|
|W\_NIEFUN\_2|2 - bezpieczeństwo|Poufność danych|Wymagane jest, aby wszystkie dane w aplikacji były odpowiednio zabezpieczone i chronione przed wyciekiem na zewnątrz.|1 (wymagane)|
|W\_NIEFUN\_3|1 - projektowe|Wolność oprogramowania|Oprogramowanie jest dostarczane na zasadach wolnego oprogramowania, co oznacza, że jest ono ogólnodostępne dla wszystkich użytkowników i kod jest otwarty.|1 (wymagane)|
|W\_NIEFUN\_4|1 - projektowe|Kompatybilność |Oprogramowanie klienckie dostępne i działające na konkurencyjnych systemach operacyjnych|2 (oczekiwane)|
|W\_NIEFUN\_5|4 – ergonomia UI |Design|Wymagane jest by UI był estetyczny oraz atrakcyjny dla użytkownika. Umożliwi to intuicyjne korzystanie z funkcji, które oferuję aplikacja.|3 (dodatkowa)|

## 3. Architektura oprogramowania
### Architektura rozwoju - stack technologiczny
#### Client-side
- electron.js
- angular 11,
- tailwind css,
- node.js
- jest

#### Server-side
- node.js 
- crawler 
- jest

#### Architektura rozwoju
- Visual Studio Code jako edytor kodu,
- Leapwork (do testów Klienta)

#### Architektura uruchomieniowa
- Serwer uruchomiony na wieloplatformowym środowisku uruchomieniowym Node.js,
- Aplikacja klienta dostępna na systemy operacyjne: macOS, Windows oraz Linux uruchioma na otwartym silniku Chrominium 
(otwarty projekt przeglądarki internetowej, z którego kod źródłowy czerpią między innymi Google Chrome, sluży do do wyświetlania treści internetowych),
