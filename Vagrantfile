Vagrant.require_version ">= 1.7.0"

Vagrant.configure(2) do |config|

  config.vm.box = "centos/7"


  config.ssh.insert_key = false


  config.vm.define :database do |cfg|
        cfg.vm.network :private_network, ip: "10.0.0.11"
        cfg.vm.provider :virtualbox do |v|
            v.name = "database"
        cfg.vm.provision :shell, :path => "database.sh"
        end
    end

  config.vm.define :appvm do |cfg|
        cfg.vm.network :private_network, ip: "10.0.0.12"
        cfg.vm.provider :virtualbox do |v|
            v.name = "appvm"
        cfg.vm.provision :shell, :path => "appvm.sh"
        end
    end

  config.vm.define :haproxy do |cfg|
        cfg.vm.network "forwarded_port", guest: 80, host: 9898
        cfg.vm.network :private_network, ip: "10.0.0.13"
        cfg.vm.provider :virtualbox do |v|
            v.name = "haproxy"
        cfg.vm.provision :shell, :path => "haproxy.sh"
        cfg.vm.provision :shell, :path => "haproxystart.sh"
        end
    end
end
