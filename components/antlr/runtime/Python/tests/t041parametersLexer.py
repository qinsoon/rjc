# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g 2013-01-03 10:51:55

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
A=4
WS=5


class t041parametersLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t041parametersLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "A"
    def mA(self, ):
        try:
            _type = A
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:14:2: ( 'a' .. 'z' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:
            pass 
            if (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "A"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:16:3: ( ( ' ' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:16:5: ( ' ' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:16:5: ( ' ' )+
            cnt1 = 0
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if (LA1_0 == 32) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:16:5: ' '
                    pass 
                    self.match(32)


                else:
                    if cnt1 >= 1:
                        break #loop1

                    eee = EarlyExitException(1, self.input)
                    raise eee

                cnt1 += 1


            #action start
            _channel = HIDDEN 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:1:8: ( A | WS )
        alt2 = 2
        LA2_0 = self.input.LA(1)

        if ((97 <= LA2_0 <= 122)) :
            alt2 = 1
        elif (LA2_0 == 32) :
            alt2 = 2
        else:
            nvae = NoViableAltException("", 2, 0, self.input)

            raise nvae


        if alt2 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:1:10: A
            pass 
            self.mA()



        elif alt2 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:1:12: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t041parametersLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
