# Datenbank
Ich habe mich für eine PostgreSQL Instanz entschieden, da ich in letzter Zeit viel damit gearbeitet habe. Zuerst habe ich ein Docker-Compose-File erstellt um diese Instanz starten zu können. Hier ein Codeausschnitt der Docker-Compose-File um eine PostgreSQL-Instanz zu erstellen:
```
database:

	image: postgres

	ports:

		- 54321:5432

	restart: always

	environment:

		POSTGRES_USER: carshop

		POSTGRES_PASSWORD: carshop

	volumes:

		- carshop-volume:/home/volumes

	networks:

		- carshop-net

	container_name: carshop-database 
```
# Backend
Als Erstes habe ich ein neues Quarkus Projekt mit den notwendigen Extensions erstellt. Im Anschluss habe ich die nötigen Properties in der ```application.properties``` gesetzt, um eine Datenbankverbindung herstellen zu können. Als Nächstes habe ich mich an die DB-Models gesetzt und hier Car, Make und ShopUser erstellt. Im späteren Verlauf sind noch 2 Models hinzugekommen (Login, Register), welche jedoch keine Entitäten sind und somit nicht in der DB persistiert werden.

Im Repository werden verschiedenste Hilfsmethoden implementiert, welche anschließend in den API-Endpoints verwendet werden.

API-Endpoints habe ich folgende implementiert:
- Init (um Beispieldaten in der DB zu generieren)
- Login (hier werden Login-Requests behandelt)
- Register (dieser Endpoint wird aufgerufen, wenn sich ein neuer Benutzer registriert)
- Info (dieser Endpoint dient als Auskunft, welcher User gerade eingeloggt ist)

Um einen sicheren Login zu ermöglichen, wurden JWTs und ein Hash-Algorithmus verwendet.

# Frontend
Im Frontend habe ich eine neue Angular-App erstellt und zuerst die notwendigen node_modules installiert. Anschließend habe ich noch ein paar Angular Material Komponenten installiert bzw. importiert, welche ich im späteren Verlauf noch benützen möchte.

Um auf der Webseite etwas einkaufen zu können, muss man sich zu Begin einloggen. 

![[CarShopLogin.png]]

Wenn man noch keinen Account besitzt, kann man sich unten rechts einen neuen Account anlegen. Dieses Fenster sieht wie folgt aus:

![[CarShopRegister.png]]

Nach einem erfolgreichen Login, sollte man eine ähnliche Liste wie diese erhalten:
![[CarShopList.png]]

# Containerisierung
Datenbank und Frontend wurden in Docker containerisiert. Das Frontend kann noch keine Requests senden, da sich das Frontend (im Container) nicht auf das Backend (am PC) verbinden kann.