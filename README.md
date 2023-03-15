# Ticketmaster
University Project, Create, View and work on User submitted Tickets

To run first get a Docker Container with Postgres like this:

sudo docker pull postgres

after that run the container with the following options:

sudo docker run --name ticketmaster-postgres -e POSTGRES_PASSWORD=test -p 5432:5432 -d ticketmaster

now that the container is running you can extract the DB dump to the container with the following command:

sudo gunzip < .gz | docker exec -i ticketmaster-postgres psql -U postgres -d ticketmaster

with that the DB should be ready and pre-populated with a few entries


# How to run the Program

java -jar [placeholder]





To (wrongly) quote Marcus Porcius Cato:

Ceterum autem censeo Web Development esse delendam

Furthermore, I consider that Web Development must be destroyed
