#!/usr/bin/env bash

export JAVA_HOME=`/usr/libexec/java_home -v 1.11`

javac -d build/alumnos -p mods $(find src/alumnos -name "*.java")
jar -cvf mods/com.example.alumnos.jar -C build/alumnos/ .

javac -d build/alumnosByName -p mods $(find src/alumnosByName -name "*.java")
jar -cvf mods/com.example.alumnosByName.jar -C build/alumnosByName/ .


javac -d build/alumnosByEdad -p mods $(find src/alumnosByEdad -name "*.java")
jar -cvf mods/com.example.alumnosByEdad.jar -C build/alumnosByEdad/ .

javac -d build/gestorAlumnos -p mods $(find src/gestorAlumnos -name "*.java")
jar -cvf mods/com.example.gestorAlumnos.jar -C build/gestorAlumnos/ .
pause
java -p mods -m com.example.gestorAlumnos/com.example.Main

pause

