cd backend
docker build -t switch-backend:latest . --no-cache
cd ..

docker image tag switch-backend 127.0.0.1:5000/switch-backend:latest
docker image push --all-tags 127.0.0.1:5000/switch-backend

docker stack deploy --compose-file prod-compose.yml swit-ch
