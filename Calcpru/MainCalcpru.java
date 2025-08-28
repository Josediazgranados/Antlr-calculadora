import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MainCalcpru {
    public static void main(String[] args) throws Exception {
        String inputFile = "Calcpru.txt";

        // Leer todas las líneas del archivo
        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        System.out.println("=== Mini Calculadora con ANTLR ===");
        System.out.println("Procesando expresiones desde el archivo: " + inputFile + "\n");

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                procesarExpresion(line);
            }
        }
    }

    private static void procesarExpresion(String input) {
        try {
            CharStream cs = CharStreams.fromString(input + "\n");
            CalcpruLexer lexer = new CalcpruLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalcpruParser parser = new CalcpruParser(tokens);

            ParseTree tree = parser.stat();

            EvalVisitor eval = new EvalVisitor();
            Double result = eval.visit(tree);

            if (result != null) {
                System.out.println(input + " = " + result);
            }
        } catch (Exception e) {
            System.err.println("Error al procesar expresión \"" + input + "\": " + e.getMessage());
        }
    }
}

