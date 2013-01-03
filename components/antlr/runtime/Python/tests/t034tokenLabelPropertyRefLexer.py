# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g 2013-01-03 10:52:10

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
A=4
WS=5


class t034tokenLabelPropertyRefLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t034tokenLabelPropertyRefLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "A"
    def mA(self, ):
        try:
            _type = A
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:18:2: ( 'a' .. 'z' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:
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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:20:5: ( ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:21:9: ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:21:9: ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+
            cnt2 = 0
            while True: #loop2
                alt2 = 4
                LA2 = self.input.LA(1)
                if LA2 == 32:
                    alt2 = 1
                elif LA2 == 9:
                    alt2 = 2
                elif LA2 == 10 or LA2 == 13:
                    alt2 = 3

                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:21:13: ' '
                    pass 
                    self.match(32)


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:22:13: '\\t'
                    pass 
                    self.match(9)


                elif alt2 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:23:12: ( '\\n' | '\\r\\n' | '\\r' )
                    pass 
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:23:12: ( '\\n' | '\\r\\n' | '\\r' )
                    alt1 = 3
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 10) :
                        alt1 = 1
                    elif (LA1_0 == 13) :
                        LA1_2 = self.input.LA(2)

                        if (LA1_2 == 10) :
                            alt1 = 2
                        else:
                            alt1 = 3

                    else:
                        nvae = NoViableAltException("", 1, 0, self.input)

                        raise nvae


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:23:14: '\\n'
                        pass 
                        self.match(10)


                    elif alt1 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:24:15: '\\r\\n'
                        pass 
                        self.match("\r\n")



                    elif alt1 == 3:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:25:15: '\\r'
                        pass 
                        self.match(13)





                else:
                    if cnt2 >= 1:
                        break #loop2

                    eee = EarlyExitException(2, self.input)
                    raise eee

                cnt2 += 1


            #action start
            _channel = HIDDEN 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:1:8: ( A | WS )
        alt3 = 2
        LA3_0 = self.input.LA(1)

        if ((97 <= LA3_0 <= 122)) :
            alt3 = 1
        elif ((9 <= LA3_0 <= 10) or LA3_0 == 13 or LA3_0 == 32) :
            alt3 = 2
        else:
            nvae = NoViableAltException("", 3, 0, self.input)

            raise nvae


        if alt3 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:1:10: A
            pass 
            self.mA()



        elif alt3 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:1:12: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t034tokenLabelPropertyRefLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
