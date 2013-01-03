# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g 2013-01-03 10:51:53

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__16=16
T__17=17
T__18=18
T__19=19
T__20=20
T__21=21
T__22=22
T__23=23
T__24=24
T__25=25
T__26=26
T__27=27
T__28=28
T__29=29
T__30=30
T__31=31
T__32=32
T__33=33
T__34=34
T__35=35
T__36=36
T__37=37
T__38=38
T__39=39
T__40=40
T__41=41
T__42=42
T__43=43
T__44=44
T__45=45
BLOCK=4
CALL=5
EXPR=6
FIELD=7
FIELDACCESS=8
FLOAT=9
ID=10
INDEX=11
INT=12
VARDEF=13
VARIABLE=14
WS=15


class t042astLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t042astLexer, self).__init__(input, state)

        self.delegates = []

        self.dfa4 = self.DFA4(
            self, 4,
            eot = self.DFA4_eot,
            eof = self.DFA4_eof,
            min = self.DFA4_min,
            max = self.DFA4_max,
            accept = self.DFA4_accept,
            special = self.DFA4_special,
            transition = self.DFA4_transition
            )






    # $ANTLR start "T__16"
    def mT__16(self, ):
        try:
            _type = T__16
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:7:7: ( '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:7:9: '('
            pass 
            self.match(40)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__16"



    # $ANTLR start "T__17"
    def mT__17(self, ):
        try:
            _type = T__17
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:8:7: ( ')' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:8:9: ')'
            pass 
            self.match(41)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__17"



    # $ANTLR start "T__18"
    def mT__18(self, ):
        try:
            _type = T__18
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:9:7: ( '+' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:9:9: '+'
            pass 
            self.match(43)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__18"



    # $ANTLR start "T__19"
    def mT__19(self, ):
        try:
            _type = T__19
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:10:7: ( ',' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:10:9: ','
            pass 
            self.match(44)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__19"



    # $ANTLR start "T__20"
    def mT__20(self, ):
        try:
            _type = T__20
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:11:7: ( '.' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:11:9: '.'
            pass 
            self.match(46)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__20"



    # $ANTLR start "T__21"
    def mT__21(self, ):
        try:
            _type = T__21
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:12:7: ( ':' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:12:9: ':'
            pass 
            self.match(58)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__21"



    # $ANTLR start "T__22"
    def mT__22(self, ):
        try:
            _type = T__22
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:13:7: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:13:9: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__22"



    # $ANTLR start "T__23"
    def mT__23(self, ):
        try:
            _type = T__23
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:14:7: ( '=' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:14:9: '='
            pass 
            self.match(61)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__23"



    # $ANTLR start "T__24"
    def mT__24(self, ):
        try:
            _type = T__24
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:15:7: ( '[' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:15:9: '['
            pass 
            self.match(91)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__24"



    # $ANTLR start "T__25"
    def mT__25(self, ):
        try:
            _type = T__25
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:16:7: ( ']' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:16:9: ']'
            pass 
            self.match(93)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__25"



    # $ANTLR start "T__26"
    def mT__26(self, ):
        try:
            _type = T__26
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:17:7: ( 'assert' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:17:9: 'assert'
            pass 
            self.match("assert")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__26"



    # $ANTLR start "T__27"
    def mT__27(self, ):
        try:
            _type = T__27
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:18:7: ( 'bool' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:18:9: 'bool'
            pass 
            self.match("bool")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__27"



    # $ANTLR start "T__28"
    def mT__28(self, ):
        try:
            _type = T__28
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:19:7: ( 'class' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:19:9: 'class'
            pass 
            self.match("class")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__28"



    # $ANTLR start "T__29"
    def mT__29(self, ):
        try:
            _type = T__29
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:20:7: ( 'else' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:20:9: 'else'
            pass 
            self.match("else")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__29"



    # $ANTLR start "T__30"
    def mT__30(self, ):
        try:
            _type = T__30
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:21:7: ( 'extends' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:21:9: 'extends'
            pass 
            self.match("extends")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__30"



    # $ANTLR start "T__31"
    def mT__31(self, ):
        try:
            _type = T__31
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:22:7: ( 'foo28a' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:22:9: 'foo28a'
            pass 
            self.match("foo28a")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__31"



    # $ANTLR start "T__32"
    def mT__32(self, ):
        try:
            _type = T__32
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:23:7: ( 'foo28b' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:23:9: 'foo28b'
            pass 
            self.match("foo28b")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__32"



    # $ANTLR start "T__33"
    def mT__33(self, ):
        try:
            _type = T__33
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:7: ( 'fooze' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:9: 'fooze'
            pass 
            self.match("fooze")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__33"



    # $ANTLR start "T__34"
    def mT__34(self, ):
        try:
            _type = T__34
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:25:7: ( 'fooze2' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:25:9: 'fooze2'
            pass 
            self.match("fooze2")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__34"



    # $ANTLR start "T__35"
    def mT__35(self, ):
        try:
            _type = T__35
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:26:7: ( 'for' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:26:9: 'for'
            pass 
            self.match("for")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__35"



    # $ANTLR start "T__36"
    def mT__36(self, ):
        try:
            _type = T__36
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:27:7: ( 'if' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:27:9: 'if'
            pass 
            self.match("if")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__36"



    # $ANTLR start "T__37"
    def mT__37(self, ):
        try:
            _type = T__37
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:7: ( 'implements' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:9: 'implements'
            pass 
            self.match("implements")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__37"



    # $ANTLR start "T__38"
    def mT__38(self, ):
        try:
            _type = T__38
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:29:7: ( 'int' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:29:9: 'int'
            pass 
            self.match("int")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__38"



    # $ANTLR start "T__39"
    def mT__39(self, ):
        try:
            _type = T__39
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:30:7: ( 'private' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:30:9: 'private'
            pass 
            self.match("private")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__39"



    # $ANTLR start "T__40"
    def mT__40(self, ):
        try:
            _type = T__40
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:31:7: ( 'public' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:31:9: 'public'
            pass 
            self.match("public")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__40"



    # $ANTLR start "T__41"
    def mT__41(self, ):
        try:
            _type = T__41
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:7: ( 'return' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:9: 'return'
            pass 
            self.match("return")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__41"



    # $ANTLR start "T__42"
    def mT__42(self, ):
        try:
            _type = T__42
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:33:7: ( 'var' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:33:9: 'var'
            pass 
            self.match("var")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__42"



    # $ANTLR start "T__43"
    def mT__43(self, ):
        try:
            _type = T__43
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:34:7: ( 'while' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:34:9: 'while'
            pass 
            self.match("while")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__43"



    # $ANTLR start "T__44"
    def mT__44(self, ):
        try:
            _type = T__44
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:35:7: ( '{' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:35:9: '{'
            pass 
            self.match(123)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__44"



    # $ANTLR start "T__45"
    def mT__45(self, ):
        try:
            _type = T__45
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:36:7: ( '}' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:36:9: '}'
            pass 
            self.match(125)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__45"



    # $ANTLR start "ID"
    def mID(self, ):
        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:350:4: ( ( 'a' .. 'z' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:350:6: ( 'a' .. 'z' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:350:6: ( 'a' .. 'z' )+
            cnt1 = 0
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
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



    # $ANTLR start "INT"
    def mINT(self, ):
        try:
            _type = INT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:351:5: ( ( '0' .. '9' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:351:7: ( '0' .. '9' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:351:7: ( '0' .. '9' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if ((48 <= LA2_0 <= 57)) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57):
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




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "INT"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:352:3: ( ( ' ' | '\\n' | '\\t' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:352:5: ( ' ' | '\\n' | '\\t' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:352:5: ( ' ' | '\\n' | '\\t' )+
            cnt3 = 0
            while True: #loop3
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if ((9 <= LA3_0 <= 10) or LA3_0 == 32) :
                    alt3 = 1


                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                    pass 
                    if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 32:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt3 >= 1:
                        break #loop3

                    eee = EarlyExitException(3, self.input)
                    raise eee

                cnt3 += 1


            #action start
            _channel = HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | ID | INT | WS )
        alt4 = 33
        alt4 = self.dfa4.predict(self.input)
        if alt4 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:10: T__16
            pass 
            self.mT__16()



        elif alt4 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:16: T__17
            pass 
            self.mT__17()



        elif alt4 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:22: T__18
            pass 
            self.mT__18()



        elif alt4 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:28: T__19
            pass 
            self.mT__19()



        elif alt4 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:34: T__20
            pass 
            self.mT__20()



        elif alt4 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:40: T__21
            pass 
            self.mT__21()



        elif alt4 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:46: T__22
            pass 
            self.mT__22()



        elif alt4 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:52: T__23
            pass 
            self.mT__23()



        elif alt4 == 9:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:58: T__24
            pass 
            self.mT__24()



        elif alt4 == 10:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:64: T__25
            pass 
            self.mT__25()



        elif alt4 == 11:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:70: T__26
            pass 
            self.mT__26()



        elif alt4 == 12:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:76: T__27
            pass 
            self.mT__27()



        elif alt4 == 13:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:82: T__28
            pass 
            self.mT__28()



        elif alt4 == 14:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:88: T__29
            pass 
            self.mT__29()



        elif alt4 == 15:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:94: T__30
            pass 
            self.mT__30()



        elif alt4 == 16:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:100: T__31
            pass 
            self.mT__31()



        elif alt4 == 17:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:106: T__32
            pass 
            self.mT__32()



        elif alt4 == 18:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:112: T__33
            pass 
            self.mT__33()



        elif alt4 == 19:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:118: T__34
            pass 
            self.mT__34()



        elif alt4 == 20:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:124: T__35
            pass 
            self.mT__35()



        elif alt4 == 21:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:130: T__36
            pass 
            self.mT__36()



        elif alt4 == 22:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:136: T__37
            pass 
            self.mT__37()



        elif alt4 == 23:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:142: T__38
            pass 
            self.mT__38()



        elif alt4 == 24:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:148: T__39
            pass 
            self.mT__39()



        elif alt4 == 25:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:154: T__40
            pass 
            self.mT__40()



        elif alt4 == 26:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:160: T__41
            pass 
            self.mT__41()



        elif alt4 == 27:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:166: T__42
            pass 
            self.mT__42()



        elif alt4 == 28:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:172: T__43
            pass 
            self.mT__43()



        elif alt4 == 29:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:178: T__44
            pass 
            self.mT__44()



        elif alt4 == 30:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:184: T__45
            pass 
            self.mT__45()



        elif alt4 == 31:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:190: ID
            pass 
            self.mID()



        elif alt4 == 32:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:193: INT
            pass 
            self.mINT()



        elif alt4 == 33:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:1:197: WS
            pass 
            self.mWS()








    # lookup tables for DFA #4

    DFA4_eot = DFA.unpack(
        u"\13\uffff\12\27\5\uffff\6\27\1\57\15\27\1\76\1\uffff\1\27\1\100"
        u"\3\27\1\104\2\27\1\107\1\27\1\111\1\27\1\uffff\1\27\1\uffff\1\27"
        u"\1\uffff\3\27\1\uffff\2\27\1\uffff\1\123\1\uffff\1\27\1\uffff\1"
        u"\130\4\27\1\135\1\136\1\uffff\1\27\4\uffff\2\27\1\142\1\143\2\uffff"
        u"\1\144\1\27\1\146\3\uffff\1\27\1\uffff\1\27\1\151\1\uffff"
        )

    DFA4_eof = DFA.unpack(
        u"\152\uffff"
        )

    DFA4_min = DFA.unpack(
        u"\1\11\12\uffff\1\163\1\157\2\154\1\157\1\146\1\162\1\145\1\141"
        u"\1\150\5\uffff\1\163\1\157\1\141\1\163\1\164\1\157\1\141\1\160"
        u"\1\164\1\151\1\142\1\164\1\162\1\151\1\145\1\154\1\163\2\145\1"
        u"\62\1\141\1\uffff\1\154\1\141\1\166\1\154\1\165\1\141\1\154\1\162"
        u"\1\141\1\163\1\141\1\156\1\70\1\145\1\uffff\1\145\1\uffff\1\141"
        u"\1\151\1\162\1\uffff\1\145\1\164\1\uffff\1\141\1\uffff\1\144\1"
        u"\141\1\62\1\155\1\164\1\143\1\156\2\141\1\uffff\1\163\4\uffff\2"
        u"\145\2\141\2\uffff\1\141\1\156\1\141\3\uffff\1\164\1\uffff\1\163"
        u"\1\141\1\uffff"
        )

    DFA4_max = DFA.unpack(
        u"\1\175\12\uffff\1\163\1\157\1\154\1\170\1\157\1\156\1\165\1\145"
        u"\1\141\1\150\5\uffff\1\163\1\157\1\141\1\163\1\164\1\162\1\172"
        u"\1\160\1\164\1\151\1\142\1\164\1\162\1\151\1\145\1\154\1\163\2"
        u"\145\2\172\1\uffff\1\154\1\172\1\166\1\154\1\165\1\172\1\154\1"
        u"\162\1\172\1\163\1\172\1\156\1\70\1\145\1\uffff\1\145\1\uffff\1"
        u"\141\1\151\1\162\1\uffff\1\145\1\164\1\uffff\1\172\1\uffff\1\144"
        u"\1\142\1\172\1\155\1\164\1\143\1\156\2\172\1\uffff\1\163\4\uffff"
        u"\2\145\2\172\2\uffff\1\172\1\156\1\172\3\uffff\1\164\1\uffff\1"
        u"\163\1\172\1\uffff"
        )

    DFA4_accept = DFA.unpack(
        u"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\uffff\1"
        u"\35\1\36\1\37\1\40\1\41\25\uffff\1\25\16\uffff\1\24\1\uffff\1\27"
        u"\3\uffff\1\33\2\uffff\1\14\1\uffff\1\16\11\uffff\1\15\1\uffff\1"
        u"\20\1\21\1\23\1\22\4\uffff\1\34\1\13\3\uffff\1\31\1\32\1\17\1\uffff"
        u"\1\30\2\uffff\1\26"
        )

    DFA4_special = DFA.unpack(
        u"\152\uffff"
        )


    DFA4_transition = [
        DFA.unpack(u"\2\31\25\uffff\1\31\7\uffff\1\1\1\2\1\uffff\1\3\1\4"
        u"\1\uffff\1\5\1\uffff\12\30\1\6\1\7\1\uffff\1\10\35\uffff\1\11\1"
        u"\uffff\1\12\3\uffff\1\13\1\14\1\15\1\27\1\16\1\17\2\27\1\20\6\27"
        u"\1\21\1\27\1\22\3\27\1\23\1\24\3\27\1\25\1\uffff\1\26"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\32"),
        DFA.unpack(u"\1\33"),
        DFA.unpack(u"\1\34"),
        DFA.unpack(u"\1\35\13\uffff\1\36"),
        DFA.unpack(u"\1\37"),
        DFA.unpack(u"\1\40\6\uffff\1\41\1\42"),
        DFA.unpack(u"\1\43\2\uffff\1\44"),
        DFA.unpack(u"\1\45"),
        DFA.unpack(u"\1\46"),
        DFA.unpack(u"\1\47"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\50"),
        DFA.unpack(u"\1\51"),
        DFA.unpack(u"\1\52"),
        DFA.unpack(u"\1\53"),
        DFA.unpack(u"\1\54"),
        DFA.unpack(u"\1\55\2\uffff\1\56"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\60"),
        DFA.unpack(u"\1\61"),
        DFA.unpack(u"\1\62"),
        DFA.unpack(u"\1\63"),
        DFA.unpack(u"\1\64"),
        DFA.unpack(u"\1\65"),
        DFA.unpack(u"\1\66"),
        DFA.unpack(u"\1\67"),
        DFA.unpack(u"\1\70"),
        DFA.unpack(u"\1\71"),
        DFA.unpack(u"\1\72"),
        DFA.unpack(u"\1\73"),
        DFA.unpack(u"\1\74\107\uffff\1\75"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\77"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\101"),
        DFA.unpack(u"\1\102"),
        DFA.unpack(u"\1\103"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\105"),
        DFA.unpack(u"\1\106"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\110"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\112"),
        DFA.unpack(u"\1\113"),
        DFA.unpack(u"\1\114"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\115"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\116"),
        DFA.unpack(u"\1\117"),
        DFA.unpack(u"\1\120"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\121"),
        DFA.unpack(u"\1\122"),
        DFA.unpack(u""),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\124"),
        DFA.unpack(u"\1\125\1\126"),
        DFA.unpack(u"\1\127\56\uffff\32\27"),
        DFA.unpack(u"\1\131"),
        DFA.unpack(u"\1\132"),
        DFA.unpack(u"\1\133"),
        DFA.unpack(u"\1\134"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\137"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\140"),
        DFA.unpack(u"\1\141"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"\1\145"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\147"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\150"),
        DFA.unpack(u"\32\27"),
        DFA.unpack(u"")
    ]

    # class definition for DFA #4

    class DFA4(DFA):
        pass


 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t042astLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
