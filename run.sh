#!/bin/bash
jar -cf  libs/PrimesPalindromChecker.jar test
java  -cp libs/* src/org/rodias/jl/Entry.java"