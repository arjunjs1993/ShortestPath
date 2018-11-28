#!/bin/bash

git_url=https://github.com/Vighi88/HPSE-Assessment.git
clone_path=/root/VigneshHPSE
sourcefile_path=/root/VigneshHPSE/HPSE-Assessment/Vagrant

#Ensure to clear the existing files from the Clone Path
echo "Clear the existing files from the VigneshHPSE"
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


#Navigate to the source folder to copy the files to desired file path
cd $sourcefile_path

cp Vagrantfile $clone_path

sleep 2

cp *.sh $clone_path

sleep 2

cp *.cfg $clone_path

sleep 2

cp *.conf $clone_path

echo "Copied all source file for Vagrant Spin Up - Here we go !!!!!!!!!!"
cd $clone_path

sleep 5

echo "Bringing Up VR Vagrant Setup in one Click !!!! YO YO !!!!!"

vagrant up

exit
