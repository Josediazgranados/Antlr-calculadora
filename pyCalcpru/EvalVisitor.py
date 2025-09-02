import math
from CalcpruVisitor import CalcpruVisitor
from CalcpruParser import CalcpruParser

class EvalVisitor(CalcpruVisitor):
    def visitPrintExpr(self, ctx:CalcpruParser.PrintExprContext):
        return self.visit(ctx.expr())

    def visitBlank(self, ctx:CalcpruParser.BlankContext):
        return None

    def visitMulDiv(self, ctx:CalcpruParser.MulDivContext):
        left = self.visit(ctx.expr(0))
        right = self.visit(ctx.expr(1))
        if ctx.op.text == '*':
            return left * right
        else:
            return left / right

    def visitAddSub(self, ctx:CalcpruParser.AddSubContext):
        left = self.visit(ctx.expr(0))
        right = self.visit(ctx.expr(1))
        if ctx.op.text == '+':
            return left + right
        else:
            return left - right

    def visitFactorial(self, ctx:CalcpruParser.FactorialContext):
        value = self.visit(ctx.expr())
        return math.factorial(int(value))

    def visitFunctionCall(self, ctx:CalcpruParser.FunctionCallContext):
        func = ctx.func().getText()
        value = self.visit(ctx.expr())

        if func == "sin":
            return math.sin(math.radians(value))   # usa grados
        elif func == "cos":
            return math.cos(math.radians(value))
        elif func == "tan":
            return math.tan(math.radians(value))
        elif func == "sqrt":
            return math.sqrt(value)
        elif func == "log":
            return math.log10(value)
        elif func == "ln":
            return math.log(value)
        else:
            raise Exception(f"Función desconocida: {func}")

    def visitInt(self, ctx:CalcpruParser.IntContext):
        return int(ctx.INT().getText())

    def visitParens(self, ctx:CalcpruParser.ParensContext):
        return self.visit(ctx.expr())
