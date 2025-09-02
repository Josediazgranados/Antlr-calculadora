# Calculadora con ANTLR4 JAVA

Este proyecto es una calculadora escrita en **Java** usando **ANTLR4**.  
Lee expresiones matemáticas desde un archivo de texto (`Calcpru.txt`) y muestra el resultado en consola.

## Archivos principales

- `Calcpru.g4` → Gramática de la calculadora  
- `MainCalcpru.java` → Programa principal  
- `EvalVisitor.java` → Lógica para evaluar expresiones  
- `Calcpru.txt` → Archivo con las expresiones a resolver  

## Como usarlo

1. Coloca las expresiones que quieras resolver en `Calcpru.txt` (una por línea).  
2. Compila y ejecuta el proyecto con los siguientes comandos:
3. java -jar antlr-4.13.2-complete.jar -visitor -no-listener Calcpru.g4
4. javac -cp .:antlr-4.13.2-complete.jar *.java
5. java -cp .:antlr-4.13.2-complete.jar MainCalcpru

# CALCULADORA CON ANTLR PYTHON
Este proyecto es una calculadora escrita en **Python** usando **ANTLR4**.  
en la cual se manejara por medio de la terminal

## Archivosd principales

- `Calcpru.g4` → Gramática de la calculadora  
- `MainCalcpru.py → Programa principal  
- `EvalVisitor.py` → Lógica para evaluar expresiones 

## Como usarlo
1. java -jar antlr-4.13.2-complete.jar -Dlanguage=Python3 -visitor -no-listener Calcpru.g4
2. python3 MainCalcpru.py

