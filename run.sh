#!/bin/bash
jar -cf  libs/PrimesPalindromChecker.jar test
java  -p libs/* src/org/rodias/jl/Entry.java