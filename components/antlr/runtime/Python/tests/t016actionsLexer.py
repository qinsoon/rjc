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


class t016actionsLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t016actionsLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__6"
    def mT__6(self, ):
        try:
            _type = T__6
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:7:6: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:7:8: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__6"



    # $ANTLR start "T__7"
    def mT__7(self, ):
        try:
            _type = T__7
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:8:6: ( 'char' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:8:8: 'char'
            pass 
            self.match("char")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__7"



    # $ANTLR start "T__8"
    def mT__8(self, ):
        try:
            _type = T__8
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:9:6: ( 'int' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:9:8: 'int'
            pass 
            self.match("int")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__8"



    # $ANTLR start "T__9"
    def mT__9(self, ):
        try:
            _type = T__9
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:10:6: ( 'void' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:10:8: 'void'
            pass 
            self.match("void")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__9"



    # $ANTLR start "ID"
    def mID(self, ):
        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:22:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:22:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            pass 
            if (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:22:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((48 <= LA1_0 <= 57) or (65 <= LA1_0 <= 90) or LA1_0 == 95 or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop1




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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:25:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:25:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:25:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if ((9 <= LA2_0 <= 10) or LA2_0 == 13 or LA2_0 == 32) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:
                    pass 
                    if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 13 or self.input.LA(1) == 32:
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
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:8: ( T__6 | T__7 | T__8 | T__9 | ID | WS )
        alt3 = 6
        LA3 = self.input.LA(1)
        if LA3 == 59:
            alt3 = 1
        elif LA3 == 99:
            LA3_2 = self.input.LA(2)

            if (LA3_2 == 104) :
                LA3_7 = self.input.LA(3)

                if (LA3_7 == 97) :
                    LA3_10 = self.input.LA(4)

                    if (LA3_10 == 114) :
                        LA3_13 = self.input.LA(5)

                        if ((48 <= LA3_13 <= 57) or (65 <= LA3_13 <= 90) or LA3_13 == 95 or (97 <= LA3_13 <= 122)) :
                            alt3 = 5
                        else:
                            alt3 = 2

                    else:
                        alt3 = 5

                else:
                    alt3 = 5

            else:
                alt3 = 5

        elif LA3 == 105:
            LA3_3 = self.input.LA(2)

            if (LA3_3 == 110) :
                LA3_8 = self.input.LA(3)

                if (LA3_8 == 116) :
                    LA3_11 = self.input.LA(4)

                    if ((48 <= LA3_11 <= 57) or (65 <= LA3_11 <= 90) or LA3_11 == 95 or (97 <= LA3_11 <= 122)) :
                        alt3 = 5
                    else:
                        alt3 = 3

                else:
                    alt3 = 5

            else:
                alt3 = 5

        elif LA3 == 118:
            LA3_4 = self.input.LA(2)

            if (LA3_4 == 111) :
                LA3_9 = self.input.LA(3)

                if (LA3_9 == 105) :
                    LA3_12 = self.input.LA(4)

                    if (LA3_12 == 100) :
                        LA3_15 = self.input.LA(5)

                        if ((48 <= LA3_15 <= 57) or (65 <= LA3_15 <= 90) or LA3_15 == 95 or (97 <= LA3_15 <= 122)) :
                            alt3 = 5
                        else:
                            alt3 = 4

                    else:
                        alt3 = 5

                else:
                    alt3 = 5

            else:
                alt3 = 5

        elif LA3 == 65 or LA3 == 66 or LA3 == 67 or LA3 == 68 or LA3 == 69 or LA3 == 70 or LA3 == 71 or LA3 == 72 or LA3 == 73 or LA3 == 74 or LA3 == 75 or LA3 == 76 or LA3 == 77 or LA3 == 78 or LA3 == 79 or LA3 == 80 or LA3 == 81 or LA3 == 82 or LA3 == 83 or LA3 == 84 or LA3 == 85 or LA3 == 86 or LA3 == 87 or LA3 == 88 or LA3 == 89 or LA3 == 90 or LA3 == 95 or LA3 == 97 or LA3 == 98 or LA3 == 100 or LA3 == 101 or LA3 == 102 or LA3 == 103 or LA3 == 104 or LA3 == 106 or LA3 == 107 or LA3 == 108 or LA3 == 109 or LA3 == 110 or LA3 == 111 or LA3 == 112 or LA3 == 113 or LA3 == 114 or LA3 == 115 or LA3 == 116 or LA3 == 117 or LA3 == 119 or LA3 == 120 or LA3 == 121 or LA3 == 122:
            alt3 = 5
        elif LA3 == 9 or LA3 == 10 or LA3 == 13 or LA3 == 32:
            alt3 = 6
        else:
            nvae = NoViableAltException("", 3, 0, self.input)

            raise nvae


        if alt3 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:10: T__6
            pass 
            self.mT__6()



        elif alt3 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:15: T__7
            pass 
            self.mT__7()



        elif alt3 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:20: T__8
            pass 
            self.mT__8()



        elif alt3 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:25: T__9
            pass 
            self.mT__9()



        elif alt3 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:30: ID
            pass 
            self.mID()



        elif alt3 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t016actions.g:1:33: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t016actionsLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
