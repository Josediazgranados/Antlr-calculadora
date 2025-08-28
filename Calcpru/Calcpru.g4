grammar Calcpru;

prog:   stat+ ;

stat
    : expr NEWLINE                # PrintExpr
    | ID '=' expr NEWLINE         # Assign
    | NEWLINE                     # Blank
    ;


expr
    : expr op=('*'|'/') expr        # MulDiv
    | expr op=('+'|'-') expr        # AddSub
    | expr '!'                      # Factorial
    | func '(' expr ')'             # FunctionCall
    | INT                           # Int
    | ID                            # Id
    | '(' expr ')'                  # Parens
    ;


func:   'sin'
      | 'cos'
      | 'tan'
      | 'sqrt'
      | 'fact'
      | 'ln'
      | 'log'
      ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID  : [a-zA-Z]+ ;
INT : [0-9]+ ;

NEWLINE : [\r\n]+ ;
WS : [ \t]+ -> skip ;

