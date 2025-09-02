grammar Calcpru;

stat: expr NEWLINE                # printExpr
    | NEWLINE                     # blank
    ;

expr
    : expr op=('*'|'/') expr      # MulDiv
    | expr op=('+'|'-') expr      # AddSub
    | expr '!'                    # Factorial
    | func '(' expr ')'           # FunctionCall
    | INT                         # Int
    | '(' expr ')'                # Parens
    ;

func: 'sin' | 'cos' | 'tan' | 'sqrt' | 'log' | 'ln';

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
WS      : [ \t]+ -> skip ;
