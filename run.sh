#!/bin/bash
jar -cf  libs/PrimePalindrom.jar test
java  -cp libs/* src/org/rodias/jl/Entry.java