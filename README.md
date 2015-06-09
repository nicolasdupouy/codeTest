### README

The goal of this repository is to store all the codes I want to test (from books, web courses, etc.).


## SSH Configuration
* Generate your private key:

    `ssh-keygen -t rsa -b 4096`

* Locally register the key:

    `ssh-add ~/.ssh/id_rsa`

* lish SSH added keys:

    `ssh-add -l`


## Git Configuration
* Username:

    `git config --global user.name "Nicolas Dupouy (Debian SID @Edward)"`

* Mail:

    `git config --global user.email "nicolasdupouy@gmail.com"`

* Enable color highlighting in the console:

    `git config --global color.ui auto`

* Pretty log:

    `git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"`

* Config view:

    `git config --list`
