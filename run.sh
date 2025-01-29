#!/bin/bash
jar -cf out PrimePalindrom.jar -p src/libs
java src/Entry.java src/Entry.java -cp src/libs