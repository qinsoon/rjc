# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g 2013-01-03 10:51:41

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
T__8=8
T__9=9
T__10=10
T__11=11
T__12=12
T__13=13
T__14=14
T__15=15
ID=4
INT=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "INT", "WS", "'('", "')'", "'*'", "'+'", "';'", "'='", "'method'", 
    "'{'", "'}'"
]



class body_scope(object):
    def __init__(self):
        self.decls = None



class t046rewriteParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t046rewriteParser, self).__init__(input, state, *args, **kwargs)


	self.body_stack = []




        self.delegates = []






    # $ANTLR start "program"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:6:1: program : ( method )+ ;
    def program(self, ):
        method1 = None


              
        start = self.input.LT(1)

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:5: ( ( method )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:9: ( method )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:9: ( method )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 13) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:9: method
                        pass 
                        self._state.following.append(self.FOLLOW_method_in_program34)
                        method1 = self.method()

                        self._state.following.pop()


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1


                #action start
                        
                self.input.insertBefore(start,"public class Wrapper {\n")
                self.input.insertAfter(method1.stop, "\n}\n")
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "program"


    class method_return(ParserRuleReturnScope):
        def __init__(self):
            super(t046rewriteParser.method_return, self).__init__()






    # $ANTLR start "method"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:17:1: method : m= 'method' ID '(' ')' body ;
    def method(self, ):
        retval = self.method_return()
        retval.start = self.input.LT(1)


        m = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:18:5: (m= 'method' ID '(' ')' body )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:18:9: m= 'method' ID '(' ')' body
                pass 
                m = self.match(self.input, 13, self.FOLLOW_13_in_method66)

                self.match(self.input, ID, self.FOLLOW_ID_in_method68)

                self.match(self.input, 7, self.FOLLOW_7_in_method70)

                self.match(self.input, 8, self.FOLLOW_8_in_method72)

                self._state.following.append(self.FOLLOW_body_in_method74)
                self.body()

                self._state.following.pop()

                #action start
                self.input.replace(m, "public void");
                #action end




                retval.stop = self.input.LT(-1)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return retval

    # $ANTLR end "method"



    # $ANTLR start "body"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:22:1: body : lcurly= '{' ( stat )* '}' ;
    def body(self, ):
        self.body_stack.append(body_scope())
        lcurly = None

              
        self.body_stack[-1].decls = set()

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:29:5: (lcurly= '{' ( stat )* '}' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:29:9: lcurly= '{' ( stat )* '}'
                pass 
                lcurly = self.match(self.input, 14, self.FOLLOW_14_in_body115)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:29:20: ( stat )*
                while True: #loop2
                    alt2 = 2
                    LA2_0 = self.input.LA(1)

                    if (LA2_0 == ID) :
                        alt2 = 1


                    if alt2 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:29:20: stat
                        pass 
                        self._state.following.append(self.FOLLOW_stat_in_body117)
                        self.stat()

                        self._state.following.pop()


                    else:
                        break #loop2


                self.match(self.input, 15, self.FOLLOW_15_in_body120)

                #action start
                        
                for it in self.body_stack[-1].decls:
                    self.input.insertAfter(lcurly, "\nint "+it+";")
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.body_stack.pop()
            pass
        return 

    # $ANTLR end "body"



    # $ANTLR start "stat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:36:1: stat : ID '=' expr ';' ;
    def stat(self, ):
        ID2 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:36:5: ( ID '=' expr ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:36:9: ID '=' expr ';'
                pass 
                ID2 = self.match(self.input, ID, self.FOLLOW_ID_in_stat144)

                self.match(self.input, 12, self.FOLLOW_12_in_stat146)

                self._state.following.append(self.FOLLOW_expr_in_stat148)
                self.expr()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_stat150)

                #action start
                self.body_stack[-1].decls.add(ID2.text);
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "stat"



    # $ANTLR start "expr"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:39:1: expr : mul ( '+' mul )* ;
    def expr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:39:5: ( mul ( '+' mul )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:39:9: mul ( '+' mul )*
                pass 
                self._state.following.append(self.FOLLOW_mul_in_expr166)
                self.mul()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:39:13: ( '+' mul )*
                while True: #loop3
                    alt3 = 2
                    LA3_0 = self.input.LA(1)

                    if (LA3_0 == 10) :
                        alt3 = 1


                    if alt3 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:39:14: '+' mul
                        pass 
                        self.match(self.input, 10, self.FOLLOW_10_in_expr169)

                        self._state.following.append(self.FOLLOW_mul_in_expr171)
                        self.mul()

                        self._state.following.pop()


                    else:
                        break #loop3





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "expr"



    # $ANTLR start "mul"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:42:1: mul : atom ( '*' atom )* ;
    def mul(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:42:5: ( atom ( '*' atom )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:42:9: atom ( '*' atom )*
                pass 
                self._state.following.append(self.FOLLOW_atom_in_mul189)
                self.atom()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:42:14: ( '*' atom )*
                while True: #loop4
                    alt4 = 2
                    LA4_0 = self.input.LA(1)

                    if (LA4_0 == 9) :
                        alt4 = 1


                    if alt4 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:42:15: '*' atom
                        pass 
                        self.match(self.input, 9, self.FOLLOW_9_in_mul192)

                        self._state.following.append(self.FOLLOW_atom_in_mul194)
                        self.atom()

                        self._state.following.pop()


                    else:
                        break #loop4





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "mul"



    # $ANTLR start "atom"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:45:1: atom : ( ID | INT );
    def atom(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:45:5: ( ID | INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:
                pass 
                if (ID <= self.input.LA(1) <= INT):
                    self.input.consume()
                    self._state.errorRecovery = False


                else:
                    mse = MismatchedSetException(None, self.input)
                    raise mse






            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "atom"



 

    FOLLOW_method_in_program34 = frozenset([1, 13])
    FOLLOW_13_in_method66 = frozenset([4])
    FOLLOW_ID_in_method68 = frozenset([7])
    FOLLOW_7_in_method70 = frozenset([8])
    FOLLOW_8_in_method72 = frozenset([14])
    FOLLOW_body_in_method74 = frozenset([1])
    FOLLOW_14_in_body115 = frozenset([4, 15])
    FOLLOW_stat_in_body117 = frozenset([4, 15])
    FOLLOW_15_in_body120 = frozenset([1])
    FOLLOW_ID_in_stat144 = frozenset([12])
    FOLLOW_12_in_stat146 = frozenset([4, 5])
    FOLLOW_expr_in_stat148 = frozenset([11])
    FOLLOW_11_in_stat150 = frozenset([1])
    FOLLOW_mul_in_expr166 = frozenset([1, 10])
    FOLLOW_10_in_expr169 = frozenset([4, 5])
    FOLLOW_mul_in_expr171 = frozenset([1, 10])
    FOLLOW_atom_in_mul189 = frozenset([1, 9])
    FOLLOW_9_in_mul192 = frozenset([4, 5])
    FOLLOW_atom_in_mul194 = frozenset([1, 9])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t046rewriteLexer", t046rewriteParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
