            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar LenguajeQ;

start       :
                dcl*  TK_BEGIN sent+ TK_END
            ;
dcl         :
                tipo TK_ID ('=' constante)? ';'
            ;

sent        :
                sentVarLocalDec
                |sentAsig
                |sentSalida
                |sentEntrada
                |sentIf
                |sentTimes
                |bloque
            ;
sentVarLocalDec:   
                tipo TK_ID ('=' exp)? ';'
            ;
sentAsig    :
                TK_ID '=' exp ';'
            ;
sentEntrada :   
                TK_READ '('TK_ID')' ';'
            ;
sentSalida  :
                (TK_PRINT|TK_PRINTLN) '('exp(',' exp)*')' ';'
            ;
sentIf      :   
                TK_IF '('exp')' sent (TK_ELSE sent)?
            ;
bloque      :   
                '{' sent+ '}'
            ;
sentTimes   :
                TK_TIMES '('exp')' sent 
            ;
sentMean    :
                TK_MEAN '('exp (','exp)*')'
            ;
exp         :    
                op=('+'|'-')exp                             #ExpSigno
                |'!' exp                                    #ExpNeg
                |exp op=('*'|'/') exp                       #ExpMulDiv
                |exp op=('+'|'-') exp                       #ExpAddSub
                |'(' exp ')'                                #ExpParent
                |constante                                  #ExpCte
                |TK_ID                                      #ExpID
                |sentMean                                   #ExpMean
            ;
constante   :
                TK_CTE_INT                                  #CteInt
                |TK_CTE_HEX                                 #CteHex
                |TK_CTE_FLOAT                               #CteFloat
                |TK_CTE_STRING                              #CteString
            ;
tipo        :   TK_TIPO_INT                                 #TipoInt
                |TK_TIPO_FLOAT                              #TipoFloat
                |TK_TIPO_STRING                             #TipoString
            ;
                
//Lexer
//Palabras reservadas
TK_BEGIN    :  'BEGIN'  | 'begin'
            ;
TK_END      :  'END' | 'end'
            ;
TK_PRINT    :  'PRINT' | 'print'
            ;
TK_PRINTLN  :  'PRINTLN' | 'println'
            ;
TK_READ     :  'READ' | 'read'
            ;
TK_TIPO_INT :  'INT' | 'int'
            ;
TK_TIPO_FLOAT: 'FLOAT' | 'float'
            ;
TK_TIPO_STRING: 'STRING' | 'string'
            ;  
TK_IF       :  'IF' | 'if'
            ;
TK_ELSE     :  'ELSE' | 'else'
            ;
TK_TIMES    :  'TIMES' | 'times'
            ;
TK_MEAN     :  'MEAN'  |  'mean'
            ;

//Constantes
TK_CTE_INT  :  DIGITO+
            ;
TK_CTE_HEX  :  '0x'('A'..'F'|'a'..'f'|DIGITO)+
            ;
TK_CTE_FLOAT:   (TK_CTE_INT)'.'TK_CTE_INT
            ;
TK_CTE_STRING:	'"' (ESC|.)*? '"'  
            ;
fragment	
ESC         : 	'\\' [btnr"\\] 
            ; 
TK_ID       :  ('_'|LETRA)('_'|LETRA|DIGITO)*
            ;
fragment
LETRA       :  ('a'..'z'|'A'..'Z')
            ;
fragment
DIGITO      :  '0'..'9'
            ;
LINE_COMMENT:	'//' .*? '\r'? '\n' -> skip;
COMMENT     :    '/*' .*? '*/' -> skip;

WS          :   (' '
                |'\t'
                |'\r'
                |'\n'
                ) -> skip;