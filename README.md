#Expression Evaluator

###Steps to install
1) Extract the zip folder(can have different names depending on version).
2) Create environment variable `EVALUATOR_HOME`
3) Set path of your folder in this variable.
4) Use shell file to run expression-evaluator.    


###Steps to use
1) Give `sh evaluator.sh [Expression]`    
2) Example `sh evaluator.sh 2 + 3`

##Release notes for Version 0.8
1) Nested round bracket are allowed.
2) Expression must have space between operator & operands.

Ex. `(2+(3+3)-3)` = 5

##Release notes for Version 0.7
1) Nested round bracket are allowed.
2) Space will not be allowed between sign & value of negative operand.
3) Expression must have space between operator & operands.

Ex. `( 2 + ( 3  +  3 ) - 3 )` = 5

##Release notes for Version 0.6
1) Multiple round bracket are allowed.
2) Space will not be allowed between sign & value of negative operand.
3) Expression must have space between operator & operands.

Ex. `( 2 + 3 ) + ( 3 - 3 )` = 5

##Release notes for Version 0.5
1) One pair of round bracket are allowed.
2) Space will not be allowed between sign & value of negative operand.
3) Expression must have space between operator & operands.

Ex. `( 2 + 3 ) + 3` = 8

##Release notes for Version 0.4
1) Decimal operands supported.
1) Space will not be allowed between sign & value of negative operand.
2) Expression must have space between operator & operands.
3) Brackets are not allowed.

Ex. `5.0 + 5 * 2.0 - 10 / 2 ^ 2 ` = 25

##Release notes for Version 0.3
1) Multiple operands & multiple operators supported.     
2) Supported opeartors are `+ - * / ^`.    
2) Space will not be allowed between sign & value of negative operand.    
3) Expression must have space between operator & operands.       
4) Brackets are not allowed.     

Ex. `5 + 5 * 2 - 10 / 2 ^ 2 ` = 25

##Release notes for Version 0.2
1) Only multiple operands & addition operator supported.    
2) Space will not be allowed between sign & value of negative operand.    
3) Expression must have space between operator & operands.    
4) Brackets are not allowed.     

Ex. `5 + 5 + 2 + 1` = 13

##Release notes for Version 0.1
1) Supports only positive & negative integers.    
2) Only two operands & addition operator supported.    
3) Expression must have space between operator & operands.    
4) Brackets are not allowed.     

Ex. `5 + 5` = 10