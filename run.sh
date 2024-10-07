docker-compose -f docker-compose.yml kill
docker-compose -f docker-compose.yml rm -f

export DBHOST=localhost
export DBPASSWORD=ugulino10
export DBSOURCE=test_MedFutura
export DBUSER=postgres
export DBPORT=5432

./mvnw clean package
docker-compose -f docker-compose.yml build
docker-compose -f docker-compose.yml up -d