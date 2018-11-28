#!/bin/bash
git_url=https://github.com/Vighi88/HPSE-Assessment.git
clone_path=/root/HPSE
cfgfile_path=/root/HPSE/HPSE-Assessment/Vagrant
haproxy_path=/etc/haproxy

echo "Inside haproxy start"

yum -y install git

echo "installed git"

sleep 5

cd /etc/haproxy

sudo rm -rf haproxy.cfg


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

cp *.cfg $haproxy_path

echo  "downloaded the haproxy config file inside haproxy folder"

sleep 2

service haproxy start

sleep 2

service haproxy status

echo "Started"

exit
