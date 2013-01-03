# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g 2013-01-03 10:52:56

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
import math



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__8=8
T__9=9
T__10=10
T__11=11
T__12=12
T__13=13
T__14=14
T__15=15
T__16=16
T__17=17
DECIMAL=4
DIGIT=5
INTEGER=6
WS=7

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "DECIMAL", "DIGIT", "INTEGER", "WS", "'('", "')'", "'*'", "'+'", "'-'", 
    "'/'", "'E'", "'PI'", "'^'", "'ln'"
]




class t015calcParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t015calcParser, self).__init__(input, state, *args, **kwargs)



                      
        self.reportedErrors = []


        self.delegates = []




                     
    def emitErrorMessage(self, msg):
        self.reportedErrors.append(msg)



    # $ANTLR start "evaluate"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:19:1: evaluate returns [result] : r= expression ;
    def evaluate(self, ):
        result = None


        r = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:19:26: (r= expression )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:19:28: r= expression
                pass 
                self._state.following.append(self.FOLLOW_expression_in_evaluate52)
                r = self.expression()

                self._state.following.pop()

                #action start
                result = r
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "evaluate"



    # $ANTLR start "expression"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:21:1: expression returns [result] : r= mult ( '+' r2= mult | '-' r2= mult )* ;
    def expression(self, ):
        result = None


        r = None

        r2 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:21:28: (r= mult ( '+' r2= mult | '-' r2= mult )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:21:30: r= mult ( '+' r2= mult | '-' r2= mult )*
                pass 
                self._state.following.append(self.FOLLOW_mult_in_expression67)
                r = self.mult()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:21:37: ( '+' r2= mult | '-' r2= mult )*
                while True: #loop1
                    alt1 = 3
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 11) :
                        alt1 = 1
                    elif (LA1_0 == 12) :
                        alt1 = 2


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:22:5: '+' r2= mult
                        pass 
                        self.match(self.input, 11, self.FOLLOW_11_in_expression75)

                        self._state.following.append(self.FOLLOW_mult_in_expression79)
                        r2 = self.mult()

                        self._state.following.pop()

                        #action start
                        r += r2
                        #action end



                    elif alt1 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:23:5: '-' r2= mult
                        pass 
                        self.match(self.input, 12, self.FOLLOW_12_in_expression87)

                        self._state.following.append(self.FOLLOW_mult_in_expression91)
                        r2 = self.mult()

                        self._state.following.pop()

                        #action start
                        r -= r2
                        #action end



                    else:
                        break #loop1


                #action start
                result = r
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "expression"



    # $ANTLR start "mult"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:26:1: mult returns [result] : r= log ( '*' r2= log | '/' r2= log )* ;
    def mult(self, ):
        result = None


        r = None

        r2 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:26:22: (r= log ( '*' r2= log | '/' r2= log )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:26:24: r= log ( '*' r2= log | '/' r2= log )*
                pass 
                self._state.following.append(self.FOLLOW_log_in_mult113)
                r = self.log()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:26:30: ( '*' r2= log | '/' r2= log )*
                while True: #loop2
                    alt2 = 3
                    LA2_0 = self.input.LA(1)

                    if (LA2_0 == 10) :
                        alt2 = 1
                    elif (LA2_0 == 13) :
                        alt2 = 2


                    if alt2 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:27:5: '*' r2= log
                        pass 
                        self.match(self.input, 10, self.FOLLOW_10_in_mult121)

                        self._state.following.append(self.FOLLOW_log_in_mult125)
                        r2 = self.log()

                        self._state.following.pop()

                        #action start
                        r *= r2
                        #action end



                    elif alt2 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:28:5: '/' r2= log
                        pass 
                        self.match(self.input, 13, self.FOLLOW_13_in_mult133)

                        self._state.following.append(self.FOLLOW_log_in_mult137)
                        r2 = self.log()

                        self._state.following.pop()

                        #action start
                        r /= r2
                        #action end



                    else:
                        break #loop2


                #action start
                result = r
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "mult"



    # $ANTLR start "log"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:32:1: log returns [result] : ( 'ln' r= exp |r= exp );
    def log(self, ):
        result = None


        r = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:32:21: ( 'ln' r= exp |r= exp )
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if (LA3_0 == 17) :
                    alt3 = 1
                elif (LA3_0 == DECIMAL or LA3_0 == INTEGER or LA3_0 == 8 or (14 <= LA3_0 <= 15)) :
                    alt3 = 2
                else:
                    nvae = NoViableAltException("", 3, 0, self.input)

                    raise nvae


                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:32:23: 'ln' r= exp
                    pass 
                    self.match(self.input, 17, self.FOLLOW_17_in_log158)

                    self._state.following.append(self.FOLLOW_exp_in_log162)
                    r = self.exp()

                    self._state.following.pop()

                    #action start
                    result = math.log(r)
                    #action end



                elif alt3 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:33:7: r= exp
                    pass 
                    self._state.following.append(self.FOLLOW_exp_in_log174)
                    r = self.exp()

                    self._state.following.pop()

                    #action start
                    result = r
                    #action end




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "log"



    # $ANTLR start "exp"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:36:1: exp returns [result] : r= atom ( '^' r2= atom )? ;
    def exp(self, ):
        result = None


        r = None

        r2 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:36:21: (r= atom ( '^' r2= atom )? )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:36:23: r= atom ( '^' r2= atom )?
                pass 
                self._state.following.append(self.FOLLOW_atom_in_exp194)
                r = self.atom()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:36:30: ( '^' r2= atom )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if (LA4_0 == 16) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:36:31: '^' r2= atom
                    pass 
                    self.match(self.input, 16, self.FOLLOW_16_in_exp197)

                    self._state.following.append(self.FOLLOW_atom_in_exp201)
                    r2 = self.atom()

                    self._state.following.pop()

                    #action start
                    r = math.pow(r,r2)
                    #action end





                #action start
                result = r
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "exp"



    # $ANTLR start "atom"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:39:1: atom returns [result] : (n= INTEGER |n= DECIMAL | '(' r= expression ')' | 'PI' | 'E' );
    def atom(self, ):
        result = None


        n = None
        r = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:39:22: (n= INTEGER |n= DECIMAL | '(' r= expression ')' | 'PI' | 'E' )
                alt5 = 5
                LA5 = self.input.LA(1)
                if LA5 == INTEGER:
                    alt5 = 1
                elif LA5 == DECIMAL:
                    alt5 = 2
                elif LA5 == 8:
                    alt5 = 3
                elif LA5 == 15:
                    alt5 = 4
                elif LA5 == 14:
                    alt5 = 5
                else:
                    nvae = NoViableAltException("", 5, 0, self.input)

                    raise nvae


                if alt5 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:40:5: n= INTEGER
                    pass 
                    n = self.match(self.input, INTEGER, self.FOLLOW_INTEGER_in_atom230)

                    #action start
                    result = int(n.text)
                    #action end



                elif alt5 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:41:5: n= DECIMAL
                    pass 
                    n = self.match(self.input, DECIMAL, self.FOLLOW_DECIMAL_in_atom240)

                    #action start
                    result = float(n.text)
                    #action end



                elif alt5 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:42:5: '(' r= expression ')'
                    pass 
                    self.match(self.input, 8, self.FOLLOW_8_in_atom249)

                    self._state.following.append(self.FOLLOW_expression_in_atom253)
                    r = self.expression()

                    self._state.following.pop()

                    #action start
                    result = r
                    #action end


                    self.match(self.input, 9, self.FOLLOW_9_in_atom257)


                elif alt5 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:43:5: 'PI'
                    pass 
                    self.match(self.input, 15, self.FOLLOW_15_in_atom263)

                    #action start
                    result = math.pi
                    #action end



                elif alt5 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t015calc.g:44:5: 'E'
                    pass 
                    self.match(self.input, 14, self.FOLLOW_14_in_atom271)

                    #action start
                    result = math.e
                    #action end




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return result

    # $ANTLR end "atom"



 

    FOLLOW_expression_in_evaluate52 = frozenset([1])
    FOLLOW_mult_in_expression67 = frozenset([1, 11, 12])
    FOLLOW_11_in_expression75 = frozenset([4, 6, 8, 14, 15, 17])
    FOLLOW_mult_in_expression79 = frozenset([1, 11, 12])
    FOLLOW_12_in_expression87 = frozenset([4, 6, 8, 14, 15, 17])
    FOLLOW_mult_in_expression91 = frozenset([1, 11, 12])
    FOLLOW_log_in_mult113 = frozenset([1, 10, 13])
    FOLLOW_10_in_mult121 = frozenset([4, 6, 8, 14, 15, 17])
    FOLLOW_log_in_mult125 = frozenset([1, 10, 13])
    FOLLOW_13_in_mult133 = frozenset([4, 6, 8, 14, 15, 17])
    FOLLOW_log_in_mult137 = frozenset([1, 10, 13])
    FOLLOW_17_in_log158 = frozenset([4, 6, 8, 14, 15])
    FOLLOW_exp_in_log162 = frozenset([1])
    FOLLOW_exp_in_log174 = frozenset([1])
    FOLLOW_atom_in_exp194 = frozenset([1, 16])
    FOLLOW_16_in_exp197 = frozenset([4, 6, 8, 14, 15])
    FOLLOW_atom_in_exp201 = frozenset([1])
    FOLLOW_INTEGER_in_atom230 = frozenset([1])
    FOLLOW_DECIMAL_in_atom240 = frozenset([1])
    FOLLOW_8_in_atom249 = frozenset([4, 6, 8, 14, 15, 17])
    FOLLOW_expression_in_atom253 = frozenset([9])
    FOLLOW_9_in_atom257 = frozenset([1])
    FOLLOW_15_in_atom263 = frozenset([1])
    FOLLOW_14_in_atom271 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t015calcLexer", t015calcParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
