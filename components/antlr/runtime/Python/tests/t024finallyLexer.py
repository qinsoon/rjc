# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g 2013-01-03 10:52:31

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
ID=4
WS=5


class t024finallyLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t024finallyLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "ID"
    def mID(self, ):
        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:15:5: ( ( 'a' .. 'z' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:15:9: ( 'a' .. 'z' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:15:9: ( 'a' .. 'z' )+
            cnt1 = 0
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:
                    pass 
                    if (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt1 >= 1:
                        break #loop1

                    eee = EarlyExitException(1, self.input)
                    raise eee

                cnt1 += 1




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "ID"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:18:5: ( ( ' ' | '\\n' | '\\r' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:18:9: ( ' ' | '\\n' | '\\r' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:18:9: ( ' ' | '\\n' | '\\r' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == 10 or LA2_0 == 13 or LA2_0 == 32) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:
                    pass 
                    if self.input.LA(1) == 10 or self.input.LA(1) == 13 or self.input.LA(1) == 32:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt2 >= 1:
                        break #loop2

                    eee = EarlyExitException(2, self.input)
                    raise eee

                cnt2 += 1


            #action start
            _channel=HIDDEN
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:1:8: ( ID | WS )
        alt3 = 2
        LA3_0 = self.input.LA(1)

        if ((97 <= LA3_0 <= 122)) :
            alt3 = 1
        elif (LA3_0 == 10 or LA3_0 == 13 or LA3_0 == 32) :
            alt3 = 2
        else:
            nvae = NoViableAltException("", 3, 0, self.input)

            raise nvae


        if alt3 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:1:10: ID
            pass 
            self.mID()



        elif alt3 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:1:13: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t024finallyLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
