#!/bin/bash

source /root/automation.properties

echo "Cleaning up Check-out path if it already exists"
sleep 2

echo "The Check out path is $checkout_path"
rm -rf $checkout_path

echo "Making Check-out Path Directory"

mkdir -p $checkout_path

sleep 2

echo "Starting git check-out"

cd $checkout_path
sleep 2
git clone $git_url

sleep 5

echo "Giving full permissions to Check-out Directory"

chmod -R 777 $checkout_path

echo "Starting Maven Build"

cd $pom_path

mvn clean install

sleep 10

cd $pom_path/target

cp *.jar $pom_path

echo "Starting Docker build"
cd $pom_path

docker build -t $docker_imagename .

sleep 10

echo "Making Docker Image Up"

sleep 2
nohup  docker run -it $docker_image $tag_value &

exit