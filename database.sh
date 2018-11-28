#!/bin/bash
clear

git_url=https://github.com/Vighi88/HPSE-Assessment.git
clone_path=/root/HPSE
cfgfile_path=/root/HPSE/HPSE-Assessment/Vagrant
mongod_path=/etc

echo 'Going to install MongoDB for vagrant'

echo '[10gen]' >> /etc/yum.repos.d/10gen.repo
echo 'name=10gen Repository' >> /etc/yum.repos.d/10gen.repo
echo 'baseurl=http://downloads-distro.mongodb.org/repo/redhat/os/x86_64' >> /etc/yum.repos.d/10gen.repo
echo 'gpgcheck=0' >> /etc/yum.repos.d/10gen.repo
echo 'enabled=1' >> /etc/yum.repos.d/10gen.repo

yum install -y mongo-10gen mongo-10gen-server



yum -y install git

echo "installed git"

sleep 5

cd /etc

sudo rm -rf mongod.conf

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

cd $cfgfile_path

sleep 5

cp *.conf $mongod_path

echo  "downloaded the mongod config file inside etc folder"

service mongod start
chkconfig mongod on
clear
echo 'MongoDB is installed, running and set to auto-start on reboots'
