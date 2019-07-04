
# README

[Get started with Docker](https://docs.docker.com/get-started)

<u>NB:</u> The Redis database is not launched with Part 2 and 3.





--------------------------------------------
## Part 2: Containers
    > docker build --tag=hello_friend_python_application .
    > docker run -p 4000:80 hello_friend_python_application

    > docker login
    > docker tag hello_friend_python_application nicolasdupouy/get-started:part2
    > docker push nicolasdupouy/get-started:part2
    > docker run -p 4000:80 nicolasdupouy/get-started:part2





--------------------------------------------
## Part 3: Services (Local swarm)
### Start and deploy
    > docker swarm init
    > docker stack deploy -c docker-compose-services.yml getstartedlab

If necessary remove the VirtualBox network interface *vboxnet0*: `VBoxManage hostonlyif remove vboxnet0`

### Test
Use `http://127.0.0.1:4000/` to connect with a browser or `curl -4 http://localhost:4000` at the command line.

### Monitor
    > docker service ls
    > docker stack services getstartedlab
    > docker service ps getstartedlab_web
    > docker stack ps getstartedlab

### Stop
    > docker stack rm getstartedlab
    > docker swarm leave --force





--------------------------------------------
## Part 4: Swarms (Swarm cluster)
The goal is to use multiple machines to create a swarm cluster and not only your local machine like in the Part 3 section.

### Create and list virtual machines
    docker-machine create --driver virtualbox myvm1
    docker-machine create --driver virtualbox myvm2

`docker-machine start myvm1` and `docker-machine start myvm2` if they are existing but not started.
Get the myvm1 and myvm2 IPs with `docker-machine ls`.

### Join the swarm cluster
#### Step 1: myvm1
Instruct myvm1 to become a swarm manager:

    > docker-machine ssh myvm1 "docker swarm init --advertise-addr <myvm1 ip>"
    Swarm initialized: current node (sk0i890gxepfztmd2u26g8f3f) is now a manager.

    To add a worker to this swarm, run the following command:

         docker swarm join --token SWMTKN-1-0yfg0m9mzwrrk3x4234qw4ftr142oksx4dncxoxnyzg86jttuk-bez90g66jmu8p208izglv3qd3 192.168.99.100:2377
    
    To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.

The command to execute on another machines to join this cluster will be `docker swarm join --token <Token> <myvm1 ip>:2377`.

#### Step 2: myvm2
Instruct the second VM to join the swarm manager myvm1
`docker-machine ssh myvm2 "docker swarm join --token <token> <myvm1 ip>:2377"`

For the previous exemple:

    > docker-machine ssh myvm2 "docker swarm join --token SWMTKN-1-0yfg0m9mzwrrk3x4234qw4ftr142oksx4dncxoxnyzg86jttuk-bez90g66jmu8p208izglv3qd3 192.168.99.100:2377"
    This node joined a swarm as a worker.

#### Configure a docker-machine shell to the swarm manager
Now that the virtual machines are up and running we have the following situation

    > docker-machine ls
    NAME    ACTIVE   DRIVER       STATE     URL                         SWARM   DOCKER        ERRORS
    myvm1   -        virtualbox   Running   tcp://192.168.99.100:2376           v18.03.0-ce
    myvm2   -        virtualbox   Running   tcp://192.168.99.101:2376           v18.03.0-ce

Define myvm1 as the active machine

    > eval $(docker-machine env myvm1)

The swarm leader is now active

    > docker-machine ls
    NAME    ACTIVE   DRIVER       STATE     URL                         SWARM   DOCKER        ERRORS
    myvm1   *        virtualbox   Running   tcp://192.168.99.100:2376           v18.03.0-ce
    myvm2   -        virtualbox   Running   tcp://192.168.99.101:2376           v18.03.0-ce

### Deploy

    > docker stack deploy -c docker-compose.yml clusterStack

Use the same command to redeploy changes.

### Test
The services are available on the VM of the cluster. myvm1 (192.168.99.100) and myvm2 (192.168.99.101) in the previous exemple.

### Undeploy
    > docker stack rm clusterStack

### Unset the shell variable settings
    > eval $(docker-machine env -u)

### Leave the swarm
    > docker-machine ssh myvm2 "docker swarm leave"
    > docker-machine ssh myvm1 "docker swarm leave --force"`
    > docker-machine stop myvm1
    > docker-machine stop myvm2