#!/bin/bash
find . -regex '\./datomic.*' -type f -print -exec ln -sf `eval pwd`/{} /usr/local/bin/{} \;
