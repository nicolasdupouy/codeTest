
# README

[Get started with Docker](https://docs.docker.com/get-started)

<u>NB:</u> The Redis database is not launched with Part 2 and 3.

--------------------------------------------
## Part 2: Containers
docker build --tag=hello_friend_python_application .
docker run -p 4000:80 hello_friend_python_application

docker login
docker tag hello_friend_python_application nicolasdupouy/get-started:part2
docker push nicolasdupouy/get-started:part2
docker run -p 4000:80 nicolasdupouy/get-started:part2

--------------------------------------------
## Part 3: Services
### Start and deploy
docker swarm init
docker stack deploy -c docker-compose-services.yml getstartedlab

### Test
Use "http://127.0.0.1:4000/" to connect thru 
curl -4 http://localhost:4000

### Monitor
docker service ls
docker stack services getstartedlab
docker service ps getstartedlab_web
docker stack ps getstartedlab

### Stop
docker stack rm getstartedlab
docker swarm leave --force
