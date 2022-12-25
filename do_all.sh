#!/usr/bin/bash
cd ./Project
mvn clean package
mv ./ear/target/earness.ear ../Docker/companiesear
cd ../Docker/companiesear
docker build --tag=earness:one .
rm earness.ear
cd ../mysql_plus_data
docker build --tag=mysql-data:one .
cd ../..
docker-compose -f hoteliers.yml up & sleep 15; docker exec -it beaned-hoteliers_db_1 /usr/share/fill_db2.sh
echo "Patience..."
sleep 10
docker exec -it beaned-hoteliers_earness_1 /usr/share/deploy.sh
echo "All done."
echo "Please be patient, the deployment is very very slow."






