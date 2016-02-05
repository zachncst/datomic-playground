# Datomic Playground

This is my datomic playground, it's a means of easily getting datomic up and running on your computer. It provides a springboard for nrepl and other means of experimenting with your datomic instance.

## Installation

## Install Datomic

### Prerequistes
 - [Leinengen](http://leiningen.org/)
```
brew install lein
```

### Install Datomic Pro
1. Go to [my.datomic](https://my.datomic.com/account), create a free account.
2. Create a credentials.clj.gpg file found [here](https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md#authentication).
  1. TLDR: create a credentials.clj file that looks like this and place it in .lein folder under your home folder:
  ```
    {#"my\.datomic\.com"
      {:username "user-name"
       :password "pword"}
     }
  ```
  2. Run the following command:
  ```
  gpg --default-recipient-self -e \
    ~/.lein/credentials.clj > ~/.lein/credentials.clj.gpg
  ```
3. Select download tab, select latest datomic and download zip.
4. Unzip in desired folder (ex. ~/.datomic/installs/ )
5. Run bin/maven-install from the install root
6. Create profiles.clj in ~/.lein with the following format:
```
{:user {:plugins [[cider/cider-nrepl "0.10.0-SNAPSHOT"]
                  [refactor-nrepl "1.2.0-SNAPSHOT"]
                  [lein-datomic "0.2.0"]]
        :dependencies [[alembic "0.3.2"]
                       [org.clojure/tools.nrepl "0.2.10"]]
        :datomic {:install-location "/Users/zachncst/Datomic/datomic-pro-0.9.5327"}
        :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                         :creds :gpg}}}}
```
7. Set DATOMIC_HOME to the install directory.


### Install Datomic Playground
1. Run git clone the [datomic playground repo](https://github.com/zachncst/datomic-playground)
2. Update the datomic version inside of the project.clj file inside datomic-playground
3. cd to the bin directory under datomic-playground and create symlinks for datomic commands
```
find . -type f -print -exec ln -sf `eval pwd`/{} /usr/local/bin/{} \;
```
4. To start datomic, run the following command from inside the root directory of the repo
``` sh
lein datomic start
```

### Load Datomic Data
*Note:* you must create symlinks for these commands to work without file path

 - Create backup
```
datomic -Xmx4g backup-db datomic:ddb://... file:/folder/and/backup/file
```
 - Restore backup
```
datomic -Xmx4g restore-db file:/folder/and/backup/file datomic:dev://localhost:4334/db-name
```

## Usage

Once installed run following command to start datomic:
```
    lein datomic start
```

## License

Copyright © 2015 Zachary Taylor

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
