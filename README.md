# MFA mobile banking app

## 1. Charakterystyka oprogramowowania

* Nazwa: **System bezpiecznej bankowości mobilnej na urządzenia z systemem operacyjnym Android**
* Opis: Aplikacja mobilna na urządzenia z systemem operacyjnym Android, umożliwiająca użytkownikom bezpieczną bankowość mobilną. Aplikacja wykorzytuje MFA - Multi-factor authentication w celu zabezpieczenia aplikacji przed dostępem osób nieporządanych. System wykorzystuje jedynie Fingerprint Authentication, uniemożliwia MFA za pomocą Face Recognition.


* Face ID wykorzystuje specjalistyczny sprzęt zwany kamerą TrueDepth, który obejmuje projektor punktowy, kamerę na podczerwień i oświetlacz, aby uchwycić i przeanalizować twarz użytkownika. Ten sprzęt zapewnia dodatkowe funkcje bezpieczeństwa, takie jak mapowanie głębi i rozpoznawanie twarzy 3D, co utrudnia atakującym sfałszowanie systemu. W przeciwieństwie do tego, wiele urządzeń z systemem Android polega wyłącznie na przedniej kamerze do przechwytywania i analizowania twarzy użytkownika.

* Face ID wykorzystuje zaawansowane algorytmy do mapowania i analizowania twarzy użytkownika, w tym sieci neuronowe i techniki uczenia maszynowego. Algorytmy te są stale aktualizowane i udoskonalane, co utrudnia napastnikom obejście systemu. W przeciwieństwie do tego, niektóre urządzenia z systemem Android mogą używać prostszych algorytmów, które mogą być łatwiejsze do zmanipulowania.


#### Cele: 
* System umożliwia klientom rejestrację konta i logowanie,
* Wymagane pola do rejestracji obejmują imię, nazwisko, numer ID klienta, numer telefonu, adres e-mail oraz hasło,
* Wymagane pola do logowania ID + hasło,
* Klienci posiadają możliwość zmiany swojego hasła i innych danych profilu,
* Obsługa blędów - w przypadku nieprawidłowego wprowadzenia danych logowania, użytkownik otrzymuje stosowny komunikat,
* Hasła są przechowywane w bezpieczny sposób oraz są szyfrowane z poziomu w bazy danych,
* Aplikacja zawiera mechanizm uwierzytelniania wielopoziomowego (MFA), aby zwiększyć bezpieczeństwo logowania,
* Po zalogowaniu klient ma dostęp do panelu użytkownika, który zawiera informacje o saldzie, historii transakcji i innych funkcjach związanych z bankowością mobilną,
* Interfejs użytkownika jest prosty i łatwy w obsłudze.

## 2. Prawa autorskie

Autor: Michał Majchrzak

Warunki licencyjne: **Licencja MIT**, Licencja MIT (ang. MIT License) to jedna z najpopularniejszych otwartych licencji oprogramowania. Jest to prosty dokument opisujący zasady korzystania, modyfikowania i rozpowszechniania kodu źródłowego w projekcie open source.

Zgodnie z tą licencją, użytkownik może korzystać, kopiować, modyfikować, publikować, dystrybuować, sprzedawać i/lub sub-licencjonować kod źródłowy bez ograniczeń, pod warunkiem, że każda kopia lub zmodyfikowana wersja zawiera odpowiednie powiadomienia o prawach autorskich i o tym, że użyto licencji MIT.

Licencja MIT jest uważana za bardzo liberalną, co oznacza, że pozwala na swobodne wykorzystywanie kodu źródłowego bez większych ograniczeń, co z kolei sprawia, że jest ona bardzo popularna wśród deweloperów i projektów open source.

## 3. Specyfikacja wymagań
1) **Wymagania funkcjonalne** 

|**ID**|**Nazwa**|**Opis**|**Priorytet**|
| :-: | :-: | :-: | :-: |
|1|Wyświetlenie ekranu autoryzacji| Wymagane jest, aby aplikacja wyświetlała ekran, na którym klient będzie w stanie dostrzec jakie dane są wymagane do zautoryzowania urządzenia oraz do weryfikacji tożsamosci. Wymagane 5 textboxów z obsługą błędów.|1 - Wymagane|
|2|Uwierzytelnianie| Wymagane jest aby aplikacja zapewniała uwierzytelnienie użytkownika przed udzieleniem mu dostępu do aplikacji. Może to obejmować uwierzytelnianie za pomocą hasła oraz odcisku palca. |1 - Wymagane|
|3|Zmiana hasła| Wymagane jest, aby aplikacja umożliwiała użytkownikowi możliwość zmiany hasła (do 3 zmian na 24h). Do procedury zmiany hasła wymagana będzie weryfikacja biometryczna (Touch ID). Wymagane jest aby hasła były przechowywane w bezpieczny sposób oraz były szyfrowane z poziomu w bazy danych. |1 - Wymagane|
|4|Zarządzanie kontami| Użytkownik powinien mieć możliwość przeglądania stanu swoich kont, historii transakcji oraz dokonywania przelewów. |1 - Wymagane|
|5|Kokpit| Wymagane jest, aby klient miał wgląd w stan konta/kont. |2 - Oczekiwane|
|6|Auto logout| Wymagane jest, aby aplikacja automatycznie wylogowywała klienta po minucie bezczynności. |2 - Oczekiwane|
|7|Multikonta| Wymagane jest, aby aplikacja umożliwiała użytkownikowi korzystanie z kont wielowalutowych. |3 - Dodatkowa|
|8|Synchronizacja z GCP| Wymagane jest, aby aplikacja posiadała synchronizację z GCP |3 - Dodatkowa|

2) **Wymagania niefuncjonalne**

|**ID**|**Nazwa**|**Opis**|**Priorytet**|
| :-: | :-: | :-: | :-: |
|1|Design|Wymagane jest by UI był estetyczny oraz łatwy w obsłudze. Umożliwi to intuicyjne korzystanie z funkcji oferowanych przez aplikację. |1 - Wymagane|
|2|Brute force| Wymagane jest aby aplikacja posiadała zabezpieczenia przed atakami. Aplikacja powinna mieć mechanizmy zabezpieczające przed atakami typu brute-force, tj. wielokrotne próby logowania z błędnym hasłem. |1 - Wymagane|
|3|Łatwość użycia| Wymagane jest, aby aplikacja powinna być intuicyjna i łatwa w obsłudze. |2 - Oczekiwane|
|4|Wydajność| Wymagane jest, aby aplikacja działała sprawnie i szybko, bez opóźnień lub przestojów. |2 - Oczekiwane|
|5|Polityka prywatności| Wymagane jest, aby aplikacja przestrzegała odpowiednich przepisów i standardów dotyczących ochrony prywatności użytkowników i danych. |2 - Oczekiwane|


## 3. Architektura oprogramowania
### Architektura rozwoju - stack technologiczny
- Języki programowania - Java (logika), XML (layout, UI)
- Platforma programistyczna: Android SDK
- Biblioteka do uwierzytelniania: Firebase Authentication
- Biblioteka do MFA: Google Authenticator
- Biblioteka do obsługi testów: Espresso
- Baza danych: Google Firebase

#### Architektura rozwoju
- Android Studio jako środowisko deweloperskie
- Architektura Model-View-ViewModel (MVVM) czyli wzorzec projektowy, w którym oddzielone są trzy warstwy: Model (warstwa danych), View (warstwa interfejsu użytkownika) i ViewModel (pośrednik między View a Modelem).
- Continuous Integration / Continuous Deployment (CI/CD) do automatycznego wdrażania i testowania zmian w kodzie

#### Architektura uruchomieniowa:
- Aplikacja kliencka uruchamiana na urządzeniach mobilnych z systemem Android
- Serwer uruchamiany jest we własnej infrastrukturze
- Wymagana konfiguracja bazy danych i serwera uwierzytelniania w celu przechowywania danych użytkowników i kluczy MFA
- Android device emulator (PROD)

