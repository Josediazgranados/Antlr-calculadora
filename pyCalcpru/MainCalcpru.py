import sys
from antlr4 import *
from CalcpruLexer import CalcpruLexer
from CalcpruParser import CalcpruParser
from EvalVisitor import EvalVisitor

def main():
    print("=== Mini Calculadora en Python con ANTLR ===")
    print("Ejemplos: 2+3*4, sin(90), sqrt(25)7divicion, 5!, log(100)")
    print("Enter vacío para salir.\n")

    while True:
        try:
            line = input("> ")
            if not line.strip():
                print("Saliendo...")
                break

            input_stream = InputStream(line + "\n")
            lexer = CalcpruLexer(input_stream)
            tokens = CommonTokenStream(lexer)
            parser = CalcpruParser(tokens)
            tree = parser.stat()

            visitor = EvalVisitor()
            result = visitor.visit(tree)

            if result is not None:
                print("= ", result)

        except Exception as e:
            print("Error:", e)

if _name_ == '_main_':
    main()
