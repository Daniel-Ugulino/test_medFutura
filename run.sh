docker-compose -f docker-compose.yml kill
docker-compose -f docker-compose.yml rm -f
./mvnw clean package -DskipTests
docker-compose -f docker-compose.yml build
docker-compose -f docker-compose.yml up -d