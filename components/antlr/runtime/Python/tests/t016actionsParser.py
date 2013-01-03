# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g 2013-01-03 10:52:54

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__6=6
T__7=7
T__8=8
T__9=9
ID=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "WS", "';'", "'char'", "'int'", "'void'"
]




class t016actionsParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t016actionsParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "declaration"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:6:1: declaration returns [name] : functionHeader ';' ;
    def declaration(self, ):
        name = None


        functionHeader1 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:7:5: ( functionHeader ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:7:9: functionHeader ';'
                pass 
                self._state.following.append(self.FOLLOW_functionHeader_in_declaration33)
                functionHeader1 = self.functionHeader()

                self._state.following.pop()

                self.match(self.input, 6, self.FOLLOW_6_in_declaration35)

                #action start
                name = functionHeader1
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return name

    # $ANTLR end "declaration"



    # $ANTLR start "functionHeader"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:11:1: functionHeader returns [name] : type ID ;
    def functionHeader(self, ):
        name = None


        ID2 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:12:5: ( type ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:12:9: type ID
                pass 
                self._state.following.append(self.FOLLOW_type_in_functionHeader68)
                self.type()

                self._state.following.pop()

                ID2 = self.match(self.input, ID, self.FOLLOW_ID_in_functionHeader70)

                #action start
                name = ID2.text
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return name

    # $ANTLR end "functionHeader"



    # $ANTLR start "type"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:16:1: type : ( 'int' | 'char' | 'void' );
    def type(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:17:5: ( 'int' | 'char' | 'void' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:
                pass 
                if (7 <= self.input.LA(1) <= 9):
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

    # $ANTLR end "type"



 

    FOLLOW_functionHeader_in_declaration33 = frozenset([6])
    FOLLOW_6_in_declaration35 = frozenset([1])
    FOLLOW_type_in_functionHeader68 = frozenset([4])
    FOLLOW_ID_in_functionHeader70 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t016actionsLexer", t016actionsParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
