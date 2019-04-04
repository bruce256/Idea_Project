
grammar El2;

// 语句必须以分号结尾
program: ( statement ';') +;

// 普通算术运算表达式或者逻辑语句
statement: stat | logicStat;

// 数学运算
stat:  stat '*' stat        # Multiply
        | stat '/' stat     # Divide
        | stat '+' stat     # Add
        | stat '-' stat     # Subtract
        | '(' stat ')'      # parenthesis
        | ID '=' stat       # assign
        | ID                # id
        | NUM               # num
        ;

// 逻辑表达式
logicStat: logicStat '&&' logicStat     # And
        | logicStat '||' logicStat      # Or
        | '(' logicStat ')'             # logicParenthesis
        | relStat                       # relation
        ;

// 关系表达式
relStat : relStat '>' relStat   # gt
        | relStat '>=' relStat  # gte
        | relStat '<' relStat   # lt
        | relStat '<=' relStat  # lte
        | relStat '==' relStat  # equal
        | NUM                   # relNum
        | ID # relId
        ;

ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
ID : [a-zA-Z]+[0-9]* ;
NUM : [0-9]+ ;
SEMICOLON : ';';
WS : [ \t]+ -> skip;