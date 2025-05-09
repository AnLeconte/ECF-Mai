
## Prérequis

- Docker et Docker Compose installés sur votre machine

## Structure des Services

- `search-service`: Service de suggestions de recherche (port 8083)
- `authentication-service`: Service d'authentification (port 8081)
- `common-data-service`: Service de données communes (port 8080)
- `payment-service`: Service de paiement (port 8082)
- `client`: Interface utilisateur React (port 3000)

## Construction et Démarrage

1. Construire et démarrer tous les services :
```bash
docker-compose up --build
```

2. Accéder à l'interface utilisateur :
- Ouvrir votre navigateur à l'adresse : http://localhost:3000

3. Arrêter les services :
```bash
docker-compose down
```

## Variables d'Environnement

Les services utilisent le profil `dev` par défaut. Vous pouvez modifier les variables d'environnement dans le fichier `.env` si nécessaire.

## Accès aux Services

- Interface utilisateur : http://localhost:3000
- Search Service : http://localhost:8083
- Authentication Service : http://localhost:8081
- Common Data Service : http://localhost:8080
- Payment Service : http://localhost:8082
