1. To Deploy the application execute following command.

docker-compose up -d

2. Create docker network

docker network create innovatehub-network --driver bridge
docker network inspect innovatehub-network

3. Connect network to database service

docker network connect innovatehub-network mysqldb

4. Verify network is correctly created.

docker ps -a
CONTAINER ID   IMAGE                           COMMAND                  CREATED          STATUS          PORTS                                         NAMES
d5c6cb9cd3e3   innovatehub-innovatehubwebapp   "java -jar /home/app…"   46 seconds ago   Up 10 seconds   0.0.0.0:8080->8080/tcp                        innovatehubwebapp
0867d972f248   mysql:8.4                       "docker-entrypoint.s…"   8 minutes ago    Up 13 seconds   3306/tcp, 33060/tcp, 0.0.0.0:3307->3307/tcp   mysqldb

mysqldb must appear in the container list.

docker network inspect innovatehub-network
[
{
"Name": "innovatehub-network",
"Id": "0f746e72e165e7970815e8170c7959aee8fd36da59fd0112bfebbf08c23fb835",
"Created": "2024-08-23T10:47:17.969944585Z",
"Scope": "local",
"Driver": "bridge",
"EnableIPv6": false,
"IPAM": {
"Driver": "default",
"Options": null,
"Config": [
{
"Subnet": "172.19.0.0/16",
"Gateway": "172.19.0.1"
}
]
},
"Internal": false,
"Attachable": false,
"Ingress": false,
"ConfigFrom": {
"Network": ""
},
"ConfigOnly": false,
"Containers": {
"0867d972f2486152204a85ff8a67462a36724890010f5234e8594c1d2b53b32d": {
"Name": "mysqldb",
"EndpointID": "b16a3c10ed09ad91739664616f267f1ffd09800237bc6ea587d76fa2f4d79163",
"MacAddress": "02:42:ac:13:00:02",
"IPv4Address": "172.19.0.2/16",
"IPv6Address": ""
}
},
"Options": {},
"Labels": {}
}
]


5. Create database and tables manually using scripts in the database docs.

6. Grant user with access.

GRANT ALL PRIVILEGES ON innovatehub.* TO 'dbUser'@'%';
use
GRANT ALL PRIVILEGES ON innovatehub TO 'dbUser'@'%';