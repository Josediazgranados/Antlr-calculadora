# Calculadora con ANTLR4

Este proyecto es una calculadora escrita en **Java** usando **ANTLR4**.  
Lee expresiones matemáticas desde un archivo de texto (`Calcpru.txt`) y muestra el resultado en consola.

## Archivos principales

- `Calcpru.g4` → Gramática de la calculadora  
- `MainCalcpru.java` → Programa principal  
- `EvalVisitor.java` → Lógica para evaluar expresiones  
- `Calcpru.txt` → Archivo con las expresiones a resolver  

## Cómo usarlo

1. Coloca las expresiones que quieras resolver en `Calcpru.txt` (una por línea).  
2. Compila y ejecuta el proyecto con los siguientes comandos:
3. java -jar antlr-4.13.2-complete.jar -visitor -no-listener Calcpru.g4
4. javac -cp .:antlr-4.13.2-complete.jar *.java
5. java -cp .:antlr-4.13.2-complete.jar MainCalcpru

