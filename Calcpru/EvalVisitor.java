import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends CalcpruBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<>();
    boolean useDegrees = true; // por defecto trabaja en grados

    @Override
    public Double visitAssign(CalcpruParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Double visitPrintExpr(CalcpruParser.PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        return value;
    }

    @Override
    public Double visitInt(CalcpruParser.IntContext ctx) {
        return Double.valueOf(ctx.INT().getText());
    }

    @Override
    public Double visitId(CalcpruParser.IdContext ctx) {
        String id = ctx.ID().getText();

        // cambio de modo
        if (id.equalsIgnoreCase("mode=deg")) {
            useDegrees = true;
            System.out.println("Modo cambiado a DEGREES");
            return 0.0;
        } else if (id.equalsIgnoreCase("mode=rad")) {
            useDegrees = false;
            System.out.println("Modo cambiado a RADIANS");
            return 0.0;
        }

        return memory.getOrDefault(id, 0.0);
    }
    @Override
    public Double visitFactorial(CalcpruParser.FactorialContext ctx) {
        double value = visit(ctx.expr());
        return (double) factorial((int) value);
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }


    @Override
    public Double visitMulDiv(CalcpruParser.MulDivContext ctx) {
        Double left = visit(ctx.expr(0));
        Double right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalcpruParser.MUL) return left * right;
        else return left / right;
    }

    @Override
    public Double visitAddSub(CalcpruParser.AddSubContext ctx) {
        Double left = visit(ctx.expr(0));
        Double right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalcpruParser.ADD) return left + right;
        else return left - right;
    }

    @Override
    public Double visitParens(CalcpruParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitFunctionCall(CalcpruParser.FunctionCallContext ctx) {
        String func = ctx.func().getText();
        Double value = visit(ctx.expr());

        // convertir a radianes si estamos en modo DEGREES
        double arg = useDegrees ? Math.toRadians(value) : value;

        switch (func) {
            case "sin": return Math.sin(arg);
            case "cos": return Math.cos(arg);
            case "tan": return Math.tan(arg);
            case "sqrt": return Math.sqrt(value);
            case "ln": return Math.log(value);
            case "log": return Math.log10(value);
            case "fact": return factorial(value);
            default: throw new RuntimeException("Función no soportada: " + func);
        }
    }

    private double factorial(double n) {
        if (n < 0) throw new RuntimeException("Factorial indefinido para negativos");
        int num = (int) n;
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

