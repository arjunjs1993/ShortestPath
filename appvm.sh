#!/bin/bash

git_url=https://github.com/Vighi88/HPSE-Assessment.git
clone_path=/root/Vignesh_Assessment
pomxml_path=/root/Vignesh_Assessment/HPSE-Assessment/HPSE
dockerfile_path=/root/Vignesh_Assessment/HPSE-Assessment
dockerimage_name=vigneshhpse
version=:v1

echo "Inside App VM"

sleep 2

yum -y install java

echo "Installed Java"

sleep 10

yum -y install maven

echo "Installed Maven"

sleep 10

yum installÂ -yÂ yum-utilsÂ \device-mapper-persistent-dataÂ \lvm2

echo "Installed Utils for Docker"

sleep 10

yum-config-managerÂ \--add-repoÂ \https://download.docker.com/linux/centos/docker-ce.repo

echo "Installed config Manager"

sleep 10

yum install docker -y

echo "Installed docker"

sleep 10

service docker start

echo "Started with docker service"

sleep 10

yum -y install git

echo "Installed GIT"

sleep 10


yum -y install telnet

sleep 10

#Ensure to clear the existing files from the Clone Path
echo "Clear the existing files from the Vignesh_Assessment"
sleep 2

echo "Path in which the Master Branch will be Cloned is $clone_path"
rm -rf $clone_path

#Create a directory to which the Branch has to be cloned from GIT
echo "Make Directory for Clone"

mkdir -p $clone_path

sleep 2

#Clone the GIT Repo to your Clone Path
echo "Started git Clone with HPSE Assessment"

cd $clone_path
sleep 2
git clone $git_url

sleep 5

#Providing full permissions fir the Clone directory
echo "Giving full permissions to Clone Directory"

chmod -R 777 $clone_path

#Starting the Build for the Checked-Out file in Clone Path
echo "Starting Maven Build"

cd $pomxml_path

mvn clean install

sleep 10

#Navigate to the target folder to copy the war file to the docker file path
cd $pomxml_path/target

cp *.war $dockerfile_path

echo "Triggering the Docker build"
cd $dockerfile_path

docker build -t $dockerimage_name$version .

sleep 10

echo "Running the Docker Image and making Services Up - You can aceess the application with http://your_vm_ip:8888/HPSE"

sleep 2
nohup docker run -i --rm -p 8888:8080 $dockerimage_name$version &

exit