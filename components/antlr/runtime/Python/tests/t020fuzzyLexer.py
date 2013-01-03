# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g 2013-01-03 10:52:43

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
from cStringIO import StringIO



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
ARG=4
CALL=5
CHAR=6
CLASS=7
COMMENT=8
ESC=9
FIELD=10
ID=11
IMPORT=12
METHOD=13
QID=14
QIDStar=15
RETURN=16
SL_COMMENT=17
STAT=18
STRING=19
TYPE=20
WS=21


class t020fuzzyLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t020fuzzyLexer, self).__init__(input, state)

        self.delegates = []


              
        self.output = StringIO()





    def nextToken(self):
        while True:
            if self.input.LA(1) == EOF:
                return self.makeEOFToken()

            self._state.token = None
            self._state.channel = DEFAULT_CHANNEL
            self._state.tokenStartCharIndex = self.input.index()
            self._state.tokenStartCharPositionInLine = self.input.charPositionInLine
            self._state.tokenStartLine = self.input.line
            self._state._text = None
            try:
                m = self.input.mark()
                try:
                    # means we won't throw slow exception
                    self._state.backtracking = 1
                    try:
                        self.mTokens()
                    finally:
                        self._state.backtracking = 0

                except BacktrackingFailed:
                    # mTokens backtracks with synpred at backtracking==2
                    # and we set the synpredgate to allow actions at level 1.
                    self.input.rewind(m)
                    self.input.consume() # advance one char and try again

                else:
                    self.emit()
                    return self._state.token

            except RecognitionException, re:
                # shouldn't happen in backtracking mode, but...
                self.reportError(re)
                self.recover(re)


    def memoize(self, input, ruleIndex, ruleStartIndex, success):
        if self._state.backtracking > 1:
            # is Lexer always superclass?
            super(t020fuzzyLexer, self).memoize(input, ruleIndex, ruleStartIndex, success)


    def alreadyParsedRule(self, input, ruleIndex):
        if self._state.backtracking > 1:
            return super(t020fuzzyLexer, self).alreadyParsedRule(input, ruleIndex)
        return False


    # $ANTLR start "IMPORT"
    def mIMPORT(self, ):
        try:
            _type = IMPORT
            _channel = DEFAULT_CHANNEL

            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:16:2: ( 'import' WS name= QIDStar ( WS )? ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:16:4: 'import' WS name= QIDStar ( WS )? ';'
            pass 
            self.match("import")


            self.mWS()


            nameStart53 = self.getCharIndex()
            self.mQIDStar()
            nameStartLine53 = self.getLine()
            nameStartCharPos53 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart53,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine53)
            name.setCharPositionInLine(nameStartCharPos53)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:16:29: ( WS )?
            alt1 = 2
            LA1_0 = self.input.LA(1)

            if ((9 <= LA1_0 <= 10) or LA1_0 == 32) :
                alt1 = 1
            if alt1 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:16:29: WS
                pass 
                self.mWS()





            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "IMPORT"



    # $ANTLR start "RETURN"
    def mRETURN(self, ):
        try:
            _type = RETURN
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:21:2: ( 'return' ( options {greedy=false; } : . )* ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:21:4: 'return' ( options {greedy=false; } : . )* ';'
            pass 
            self.match("return")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:21:13: ( options {greedy=false; } : . )*
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == 59) :
                    alt2 = 2
                elif ((0 <= LA2_0 <= 58) or (60 <= LA2_0 <= 65535)) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:21:38: .
                    pass 
                    self.matchAny()


                else:
                    break #loop2


            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "RETURN"



    # $ANTLR start "CLASS"
    def mCLASS(self, ):
        try:
            _type = CLASS
            _channel = DEFAULT_CHANNEL

            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:2: ( 'class' WS name= ID ( WS )? ( 'extends' WS QID ( WS )? )? ( 'implements' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )? '{' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:4: 'class' WS name= ID ( WS )? ( 'extends' WS QID ( WS )? )? ( 'implements' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )? '{'
            pass 
            self.match("class")


            self.mWS()


            nameStart103 = self.getCharIndex()
            self.mID()
            nameStartLine103 = self.getLine()
            nameStartCharPos103 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart103,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine103)
            name.setCharPositionInLine(nameStartCharPos103)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:23: ( WS )?
            alt3 = 2
            LA3_0 = self.input.LA(1)

            if ((9 <= LA3_0 <= 10) or LA3_0 == 32) :
                alt3 = 1
            if alt3 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:23: WS
                pass 
                self.mWS()





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:27: ( 'extends' WS QID ( WS )? )?
            alt5 = 2
            LA5_0 = self.input.LA(1)

            if (LA5_0 == 101) :
                alt5 = 1
            if alt5 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:28: 'extends' WS QID ( WS )?
                pass 
                self.match("extends")


                self.mWS()


                self.mQID()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:45: ( WS )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if ((9 <= LA4_0 <= 10) or LA4_0 == 32) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:25:45: WS
                    pass 
                    self.mWS()








            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:3: ( 'implements' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )?
            alt10 = 2
            LA10_0 = self.input.LA(1)

            if (LA10_0 == 105) :
                alt10 = 1
            if alt10 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:4: 'implements' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )*
                pass 
                self.match("implements")


                self.mWS()


                self.mQID()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:24: ( WS )?
                alt6 = 2
                LA6_0 = self.input.LA(1)

                if ((9 <= LA6_0 <= 10) or LA6_0 == 32) :
                    alt6 = 1
                if alt6 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:24: WS
                    pass 
                    self.mWS()





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:28: ( ',' ( WS )? QID ( WS )? )*
                while True: #loop9
                    alt9 = 2
                    LA9_0 = self.input.LA(1)

                    if (LA9_0 == 44) :
                        alt9 = 1


                    if alt9 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:29: ',' ( WS )? QID ( WS )?
                        pass 
                        self.match(44)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:33: ( WS )?
                        alt7 = 2
                        LA7_0 = self.input.LA(1)

                        if ((9 <= LA7_0 <= 10) or LA7_0 == 32) :
                            alt7 = 1
                        if alt7 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:33: WS
                            pass 
                            self.mWS()





                        self.mQID()


                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:41: ( WS )?
                        alt8 = 2
                        LA8_0 = self.input.LA(1)

                        if ((9 <= LA8_0 <= 10) or LA8_0 == 32) :
                            alt8 = 1
                        if alt8 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:26:41: WS
                            pass 
                            self.mWS()






                    else:
                        break #loop9





            self.match(123)

            if self._state.backtracking == 1:
                pass
                self.output.write("found class "+name.text+"\n")





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "CLASS"



    # $ANTLR start "METHOD"
    def mMETHOD(self, ):
        try:
            _type = METHOD
            _channel = DEFAULT_CHANNEL

            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:5: ( TYPE WS name= ID ( WS )? '(' ( ARG ( WS )? ( ',' ( WS )? ARG ( WS )? )* )? ')' ( WS )? ( 'throws' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )? '{' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:9: TYPE WS name= ID ( WS )? '(' ( ARG ( WS )? ( ',' ( WS )? ARG ( WS )? )* )? ')' ( WS )? ( 'throws' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )? '{'
            pass 
            self.mTYPE()


            self.mWS()


            nameStart180 = self.getCharIndex()
            self.mID()
            nameStartLine180 = self.getLine()
            nameStartCharPos180 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart180,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine180)
            name.setCharPositionInLine(nameStartCharPos180)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:25: ( WS )?
            alt11 = 2
            LA11_0 = self.input.LA(1)

            if ((9 <= LA11_0 <= 10) or LA11_0 == 32) :
                alt11 = 1
            if alt11 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:25: WS
                pass 
                self.mWS()





            self.match(40)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:33: ( ARG ( WS )? ( ',' ( WS )? ARG ( WS )? )* )?
            alt16 = 2
            LA16_0 = self.input.LA(1)

            if ((65 <= LA16_0 <= 90) or LA16_0 == 95 or (97 <= LA16_0 <= 122)) :
                alt16 = 1
            if alt16 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:35: ARG ( WS )? ( ',' ( WS )? ARG ( WS )? )*
                pass 
                self.mARG()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:39: ( WS )?
                alt12 = 2
                LA12_0 = self.input.LA(1)

                if ((9 <= LA12_0 <= 10) or LA12_0 == 32) :
                    alt12 = 1
                if alt12 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:39: WS
                    pass 
                    self.mWS()





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:43: ( ',' ( WS )? ARG ( WS )? )*
                while True: #loop15
                    alt15 = 2
                    LA15_0 = self.input.LA(1)

                    if (LA15_0 == 44) :
                        alt15 = 1


                    if alt15 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:44: ',' ( WS )? ARG ( WS )?
                        pass 
                        self.match(44)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:48: ( WS )?
                        alt13 = 2
                        LA13_0 = self.input.LA(1)

                        if ((9 <= LA13_0 <= 10) or LA13_0 == 32) :
                            alt13 = 1
                        if alt13 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:48: WS
                            pass 
                            self.mWS()





                        self.mARG()


                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:56: ( WS )?
                        alt14 = 2
                        LA14_0 = self.input.LA(1)

                        if ((9 <= LA14_0 <= 10) or LA14_0 == 32) :
                            alt14 = 1
                        if alt14 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:56: WS
                            pass 
                            self.mWS()






                    else:
                        break #loop15





            self.match(41)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:69: ( WS )?
            alt17 = 2
            LA17_0 = self.input.LA(1)

            if ((9 <= LA17_0 <= 10) or LA17_0 == 32) :
                alt17 = 1
            if alt17 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:31:69: WS
                pass 
                self.mWS()





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:8: ( 'throws' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )* )?
            alt22 = 2
            LA22_0 = self.input.LA(1)

            if (LA22_0 == 116) :
                alt22 = 1
            if alt22 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:9: 'throws' WS QID ( WS )? ( ',' ( WS )? QID ( WS )? )*
                pass 
                self.match("throws")


                self.mWS()


                self.mQID()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:25: ( WS )?
                alt18 = 2
                LA18_0 = self.input.LA(1)

                if ((9 <= LA18_0 <= 10) or LA18_0 == 32) :
                    alt18 = 1
                if alt18 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:25: WS
                    pass 
                    self.mWS()





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:29: ( ',' ( WS )? QID ( WS )? )*
                while True: #loop21
                    alt21 = 2
                    LA21_0 = self.input.LA(1)

                    if (LA21_0 == 44) :
                        alt21 = 1


                    if alt21 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:30: ',' ( WS )? QID ( WS )?
                        pass 
                        self.match(44)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:34: ( WS )?
                        alt19 = 2
                        LA19_0 = self.input.LA(1)

                        if ((9 <= LA19_0 <= 10) or LA19_0 == 32) :
                            alt19 = 1
                        if alt19 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:34: WS
                            pass 
                            self.mWS()





                        self.mQID()


                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:42: ( WS )?
                        alt20 = 2
                        LA20_0 = self.input.LA(1)

                        if ((9 <= LA20_0 <= 10) or LA20_0 == 32) :
                            alt20 = 1
                        if alt20 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:32:42: WS
                            pass 
                            self.mWS()






                    else:
                        break #loop21





            self.match(123)

            if self._state.backtracking == 1:
                pass
                self.output.write("found method "+name.text+"\n");





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "METHOD"



    # $ANTLR start "FIELD"
    def mFIELD(self, ):
        try:
            _type = FIELD
            _channel = DEFAULT_CHANNEL

            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:5: ( TYPE WS name= ID ( '[]' )? ( WS )? ( ';' | '=' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:9: TYPE WS name= ID ( '[]' )? ( WS )? ( ';' | '=' )
            pass 
            self.mTYPE()


            self.mWS()


            nameStart283 = self.getCharIndex()
            self.mID()
            nameStartLine283 = self.getLine()
            nameStartCharPos283 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart283,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine283)
            name.setCharPositionInLine(nameStartCharPos283)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:25: ( '[]' )?
            alt23 = 2
            LA23_0 = self.input.LA(1)

            if (LA23_0 == 91) :
                alt23 = 1
            if alt23 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:25: '[]'
                pass 
                self.match("[]")





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:31: ( WS )?
            alt24 = 2
            LA24_0 = self.input.LA(1)

            if ((9 <= LA24_0 <= 10) or LA24_0 == 32) :
                alt24 = 1
            if alt24 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:37:31: WS
                pass 
                self.mWS()





            if self.input.LA(1) == 59 or self.input.LA(1) == 61:
                self.input.consume()
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            if self._state.backtracking == 1:
                pass
                self.output.write("found var "+name.text+"\n");





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "FIELD"



    # $ANTLR start "STAT"
    def mSTAT(self, ):
        try:
            _type = STAT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:5: ( ( 'if' | 'while' | 'switch' | 'for' ) ( WS )? '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:7: ( 'if' | 'while' | 'switch' | 'for' ) ( WS )? '('
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:7: ( 'if' | 'while' | 'switch' | 'for' )
            alt25 = 4
            LA25 = self.input.LA(1)
            if LA25 == 105:
                alt25 = 1
            elif LA25 == 119:
                alt25 = 2
            elif LA25 == 115:
                alt25 = 3
            elif LA25 == 102:
                alt25 = 4
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 25, 0, self.input)

                raise nvae


            if alt25 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:8: 'if'
                pass 
                self.match("if")



            elif alt25 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:13: 'while'
                pass 
                self.match("while")



            elif alt25 == 3:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:21: 'switch'
                pass 
                self.match("switch")



            elif alt25 == 4:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:30: 'for'
                pass 
                self.match("for")





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:37: ( WS )?
            alt26 = 2
            LA26_0 = self.input.LA(1)

            if ((9 <= LA26_0 <= 10) or LA26_0 == 32) :
                alt26 = 1
            if alt26 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:41:37: WS
                pass 
                self.mWS()





            self.match(40)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "STAT"



    # $ANTLR start "CALL"
    def mCALL(self, ):
        try:
            _type = CALL
            _channel = DEFAULT_CHANNEL

            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:44:5: (name= QID ( WS )? '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:44:9: name= QID ( WS )? '('
            pass 
            nameStart348 = self.getCharIndex()
            self.mQID()
            nameStartLine348 = self.getLine()
            nameStartCharPos348 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart348,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine348)
            name.setCharPositionInLine(nameStartCharPos348)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:44:18: ( WS )?
            alt27 = 2
            LA27_0 = self.input.LA(1)

            if ((9 <= LA27_0 <= 10) or LA27_0 == 32) :
                alt27 = 1
            if alt27 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:44:18: WS
                pass 
                self.mWS()





            self.match(40)

            if self._state.backtracking == 1:
                pass
                self.output.write("found call "+name.text+"\n");





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "CALL"



    # $ANTLR start "COMMENT"
    def mCOMMENT(self, ):
        try:
            _type = COMMENT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:49:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:49:9: '/*' ( options {greedy=false; } : . )* '*/'
            pass 
            self.match("/*")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:49:14: ( options {greedy=false; } : . )*
            while True: #loop28
                alt28 = 2
                LA28_0 = self.input.LA(1)

                if (LA28_0 == 42) :
                    LA28_1 = self.input.LA(2)

                    if (LA28_1 == 47) :
                        alt28 = 2
                    elif ((0 <= LA28_1 <= 46) or (48 <= LA28_1 <= 65535)) :
                        alt28 = 1


                elif ((0 <= LA28_0 <= 41) or (43 <= LA28_0 <= 65535)) :
                    alt28 = 1


                if alt28 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:49:41: .
                    pass 
                    self.matchAny()


                else:
                    break #loop28


            self.match("*/")


            if self._state.backtracking == 1:
                pass
                self.output.write("found comment "+self.getText()+"\n");





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "COMMENT"



    # $ANTLR start "SL_COMMENT"
    def mSL_COMMENT(self, ):
        try:
            _type = SL_COMMENT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:54:5: ( '//' ( options {greedy=false; } : . )* '\\n' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:54:9: '//' ( options {greedy=false; } : . )* '\\n'
            pass 
            self.match("//")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:54:14: ( options {greedy=false; } : . )*
            while True: #loop29
                alt29 = 2
                LA29_0 = self.input.LA(1)

                if (LA29_0 == 10) :
                    alt29 = 2
                elif ((0 <= LA29_0 <= 9) or (11 <= LA29_0 <= 65535)) :
                    alt29 = 1


                if alt29 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:54:41: .
                    pass 
                    self.matchAny()


                else:
                    break #loop29


            self.match(10)

            if self._state.backtracking == 1:
                pass
                self.output.write("found // comment "+self.getText()+"\n");





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "SL_COMMENT"



    # $ANTLR start "STRING"
    def mSTRING(self, ):
        try:
            _type = STRING
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:59:2: ( '\"' ( options {greedy=false; } : ESC | . )* '\"' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:59:4: '\"' ( options {greedy=false; } : ESC | . )* '\"'
            pass 
            self.match(34)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:59:8: ( options {greedy=false; } : ESC | . )*
            while True: #loop30
                alt30 = 3
                LA30_0 = self.input.LA(1)

                if (LA30_0 == 34) :
                    alt30 = 3
                elif (LA30_0 == 92) :
                    LA30_2 = self.input.LA(2)

                    if (LA30_2 == 34) :
                        alt30 = 1
                    elif (LA30_2 == 92) :
                        alt30 = 1
                    elif (LA30_2 == 39) :
                        alt30 = 1
                    elif ((0 <= LA30_2 <= 33) or (35 <= LA30_2 <= 38) or (40 <= LA30_2 <= 91) or (93 <= LA30_2 <= 65535)) :
                        alt30 = 2


                elif ((0 <= LA30_0 <= 33) or (35 <= LA30_0 <= 91) or (93 <= LA30_0 <= 65535)) :
                    alt30 = 2


                if alt30 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:59:34: ESC
                    pass 
                    self.mESC()



                elif alt30 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:59:40: .
                    pass 
                    self.matchAny()


                else:
                    break #loop30


            self.match(34)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "STRING"



    # $ANTLR start "CHAR"
    def mCHAR(self, ):
        try:
            _type = CHAR
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:63:2: ( '\\'' ( options {greedy=false; } : ESC | . )* '\\'' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:63:4: '\\'' ( options {greedy=false; } : ESC | . )* '\\''
            pass 
            self.match(39)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:63:9: ( options {greedy=false; } : ESC | . )*
            while True: #loop31
                alt31 = 3
                LA31_0 = self.input.LA(1)

                if (LA31_0 == 39) :
                    alt31 = 3
                elif (LA31_0 == 92) :
                    LA31_2 = self.input.LA(2)

                    if (LA31_2 == 39) :
                        alt31 = 1
                    elif (LA31_2 == 92) :
                        alt31 = 1
                    elif (LA31_2 == 34) :
                        alt31 = 1
                    elif ((0 <= LA31_2 <= 33) or (35 <= LA31_2 <= 38) or (40 <= LA31_2 <= 91) or (93 <= LA31_2 <= 65535)) :
                        alt31 = 2


                elif ((0 <= LA31_0 <= 38) or (40 <= LA31_0 <= 91) or (93 <= LA31_0 <= 65535)) :
                    alt31 = 2


                if alt31 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:63:35: ESC
                    pass 
                    self.mESC()



                elif alt31 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:63:41: .
                    pass 
                    self.matchAny()


                else:
                    break #loop31


            self.match(39)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "CHAR"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:66:5: ( ( ' ' | '\\t' | '\\n' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:66:9: ( ' ' | '\\t' | '\\n' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:66:9: ( ' ' | '\\t' | '\\n' )+
            cnt32 = 0
            while True: #loop32
                alt32 = 2
                LA32_0 = self.input.LA(1)

                if ((9 <= LA32_0 <= 10) or LA32_0 == 32) :
                    alt32 = 1


                if alt32 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:
                    pass 
                    if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 32:
                        self.input.consume()
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt32 >= 1:
                        break #loop32

                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    eee = EarlyExitException(32, self.input)
                    raise eee

                cnt32 += 1




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    # $ANTLR start "QID"
    def mQID(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:70:5: ( ID ( '.' ID )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:70:7: ID ( '.' ID )*
            pass 
            self.mID()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:70:10: ( '.' ID )*
            while True: #loop33
                alt33 = 2
                LA33_0 = self.input.LA(1)

                if (LA33_0 == 46) :
                    alt33 = 1


                if alt33 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:70:11: '.' ID
                    pass 
                    self.match(46)

                    self.mID()



                else:
                    break #loop33





        finally:
            pass

    # $ANTLR end "QID"



    # $ANTLR start "QIDStar"
    def mQIDStar(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:2: ( ID ( '.' ID )* ( '.*' )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:4: ID ( '.' ID )* ( '.*' )?
            pass 
            self.mID()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:7: ( '.' ID )*
            while True: #loop34
                alt34 = 2
                LA34_0 = self.input.LA(1)

                if (LA34_0 == 46) :
                    LA34_1 = self.input.LA(2)

                    if ((65 <= LA34_1 <= 90) or LA34_1 == 95 or (97 <= LA34_1 <= 122)) :
                        alt34 = 1




                if alt34 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:8: '.' ID
                    pass 
                    self.match(46)

                    self.mID()



                else:
                    break #loop34


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:17: ( '.*' )?
            alt35 = 2
            LA35_0 = self.input.LA(1)

            if (LA35_0 == 46) :
                alt35 = 1
            if alt35 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:79:17: '.*'
                pass 
                self.match(".*")








        finally:
            pass

    # $ANTLR end "QIDStar"



    # $ANTLR start "TYPE"
    def mTYPE(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:83:5: ( QID ( '[]' )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:83:9: QID ( '[]' )?
            pass 
            self.mQID()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:83:13: ( '[]' )?
            alt36 = 2
            LA36_0 = self.input.LA(1)

            if (LA36_0 == 91) :
                alt36 = 1
            if alt36 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:83:13: '[]'
                pass 
                self.match("[]")








        finally:
            pass

    # $ANTLR end "TYPE"



    # $ANTLR start "ARG"
    def mARG(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:87:5: ( TYPE WS ID )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:87:9: TYPE WS ID
            pass 
            self.mTYPE()


            self.mWS()


            self.mID()





        finally:
            pass

    # $ANTLR end "ARG"



    # $ANTLR start "ID"
    def mID(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:91:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:91:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            pass 
            if (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:91:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            while True: #loop37
                alt37 = 2
                LA37_0 = self.input.LA(1)

                if ((48 <= LA37_0 <= 57) or (65 <= LA37_0 <= 90) or LA37_0 == 95 or (97 <= LA37_0 <= 122)) :
                    alt37 = 1


                if alt37 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop37





        finally:
            pass

    # $ANTLR end "ID"



    # $ANTLR start "ESC"
    def mESC(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:95:5: ( '\\\\' ( '\"' | '\\'' | '\\\\' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:95:7: '\\\\' ( '\"' | '\\'' | '\\\\' )
            pass 
            self.match(92)

            if self.input.LA(1) == 34 or self.input.LA(1) == 39 or self.input.LA(1) == 92:
                self.input.consume()
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse






        finally:
            pass

    # $ANTLR end "ESC"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:39: ( IMPORT | RETURN | CLASS | METHOD | FIELD | STAT | CALL | COMMENT | SL_COMMENT | STRING | CHAR | WS )
        alt38 = 12
        LA38 = self.input.LA(1)
        if LA38 == 105:
            LA38_1 = self.input.LA(2)

            if (self.synpred1_t020fuzzyLexer()) :
                alt38 = 1
            elif (self.synpred4_t020fuzzyLexer()) :
                alt38 = 4
            elif (self.synpred5_t020fuzzyLexer()) :
                alt38 = 5
            elif (self.synpred6_t020fuzzyLexer()) :
                alt38 = 6
            elif (self.synpred7_t020fuzzyLexer()) :
                alt38 = 7
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 1, self.input)

                raise nvae


        elif LA38 == 114:
            LA38_7 = self.input.LA(2)

            if (self.synpred2_t020fuzzyLexer()) :
                alt38 = 2
            elif (self.synpred4_t020fuzzyLexer()) :
                alt38 = 4
            elif (self.synpred5_t020fuzzyLexer()) :
                alt38 = 5
            elif (self.synpred7_t020fuzzyLexer()) :
                alt38 = 7
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 7, self.input)

                raise nvae


        elif LA38 == 99:
            LA38_9 = self.input.LA(2)

            if (self.synpred3_t020fuzzyLexer()) :
                alt38 = 3
            elif (self.synpred4_t020fuzzyLexer()) :
                alt38 = 4
            elif (self.synpred5_t020fuzzyLexer()) :
                alt38 = 5
            elif (self.synpred7_t020fuzzyLexer()) :
                alt38 = 7
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 9, self.input)

                raise nvae


        elif LA38 == 102 or LA38 == 115 or LA38 == 119:
            LA38_11 = self.input.LA(2)

            if (self.synpred4_t020fuzzyLexer()) :
                alt38 = 4
            elif (self.synpred5_t020fuzzyLexer()) :
                alt38 = 5
            elif (self.synpred6_t020fuzzyLexer()) :
                alt38 = 6
            elif (self.synpred7_t020fuzzyLexer()) :
                alt38 = 7
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 11, self.input)

                raise nvae


        elif LA38 == 65 or LA38 == 66 or LA38 == 67 or LA38 == 68 or LA38 == 69 or LA38 == 70 or LA38 == 71 or LA38 == 72 or LA38 == 73 or LA38 == 74 or LA38 == 75 or LA38 == 76 or LA38 == 77 or LA38 == 78 or LA38 == 79 or LA38 == 80 or LA38 == 81 or LA38 == 82 or LA38 == 83 or LA38 == 84 or LA38 == 85 or LA38 == 86 or LA38 == 87 or LA38 == 88 or LA38 == 89 or LA38 == 90 or LA38 == 95 or LA38 == 97 or LA38 == 98 or LA38 == 100 or LA38 == 101 or LA38 == 103 or LA38 == 104 or LA38 == 106 or LA38 == 107 or LA38 == 108 or LA38 == 109 or LA38 == 110 or LA38 == 111 or LA38 == 112 or LA38 == 113 or LA38 == 116 or LA38 == 117 or LA38 == 118 or LA38 == 120 or LA38 == 121 or LA38 == 122:
            LA38_12 = self.input.LA(2)

            if (self.synpred4_t020fuzzyLexer()) :
                alt38 = 4
            elif (self.synpred5_t020fuzzyLexer()) :
                alt38 = 5
            elif (self.synpred7_t020fuzzyLexer()) :
                alt38 = 7
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 12, self.input)

                raise nvae


        elif LA38 == 47:
            LA38_13 = self.input.LA(2)

            if (self.synpred8_t020fuzzyLexer()) :
                alt38 = 8
            elif (self.synpred9_t020fuzzyLexer()) :
                alt38 = 9
            else:
                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                nvae = NoViableAltException("", 38, 13, self.input)

                raise nvae


        elif LA38 == 34:
            alt38 = 10
        elif LA38 == 39:
            alt38 = 11
        elif LA38 == 9 or LA38 == 10 or LA38 == 32:
            alt38 = 12
        else:
            if self._state.backtracking > 0:
                raise BacktrackingFailed


            nvae = NoViableAltException("", 38, 0, self.input)

            raise nvae


        if alt38 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:41: IMPORT
            pass 
            self.mIMPORT()



        elif alt38 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:48: RETURN
            pass 
            self.mRETURN()



        elif alt38 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:55: CLASS
            pass 
            self.mCLASS()



        elif alt38 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:61: METHOD
            pass 
            self.mMETHOD()



        elif alt38 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:68: FIELD
            pass 
            self.mFIELD()



        elif alt38 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:74: STAT
            pass 
            self.mSTAT()



        elif alt38 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:79: CALL
            pass 
            self.mCALL()



        elif alt38 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:84: COMMENT
            pass 
            self.mCOMMENT()



        elif alt38 == 9:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:92: SL_COMMENT
            pass 
            self.mSL_COMMENT()



        elif alt38 == 10:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:103: STRING
            pass 
            self.mSTRING()



        elif alt38 == 11:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:110: CHAR
            pass 
            self.mCHAR()



        elif alt38 == 12:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:115: WS
            pass 
            self.mWS()







    # $ANTLR start "synpred1_t020fuzzyLexer"
    def synpred1_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:41: ( IMPORT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:41: IMPORT
        pass 
        self.mIMPORT()




    # $ANTLR end "synpred1_t020fuzzyLexer"



    # $ANTLR start "synpred2_t020fuzzyLexer"
    def synpred2_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:48: ( RETURN )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:48: RETURN
        pass 
        self.mRETURN()




    # $ANTLR end "synpred2_t020fuzzyLexer"



    # $ANTLR start "synpred3_t020fuzzyLexer"
    def synpred3_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:55: ( CLASS )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:55: CLASS
        pass 
        self.mCLASS()




    # $ANTLR end "synpred3_t020fuzzyLexer"



    # $ANTLR start "synpred4_t020fuzzyLexer"
    def synpred4_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:61: ( METHOD )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:61: METHOD
        pass 
        self.mMETHOD()




    # $ANTLR end "synpred4_t020fuzzyLexer"



    # $ANTLR start "synpred5_t020fuzzyLexer"
    def synpred5_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:68: ( FIELD )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:68: FIELD
        pass 
        self.mFIELD()




    # $ANTLR end "synpred5_t020fuzzyLexer"



    # $ANTLR start "synpred6_t020fuzzyLexer"
    def synpred6_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:74: ( STAT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:74: STAT
        pass 
        self.mSTAT()




    # $ANTLR end "synpred6_t020fuzzyLexer"



    # $ANTLR start "synpred7_t020fuzzyLexer"
    def synpred7_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:79: ( CALL )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:79: CALL
        pass 
        self.mCALL()




    # $ANTLR end "synpred7_t020fuzzyLexer"



    # $ANTLR start "synpred8_t020fuzzyLexer"
    def synpred8_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:84: ( COMMENT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:84: COMMENT
        pass 
        self.mCOMMENT()




    # $ANTLR end "synpred8_t020fuzzyLexer"



    # $ANTLR start "synpred9_t020fuzzyLexer"
    def synpred9_t020fuzzyLexer_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:92: ( SL_COMMENT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t020fuzzyLexer.g:1:92: SL_COMMENT
        pass 
        self.mSL_COMMENT()




    # $ANTLR end "synpred9_t020fuzzyLexer"



    def synpred4_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred4_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred8_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred8_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred6_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred6_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred9_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred9_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred7_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred7_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred1_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred1_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred5_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred5_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred3_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred3_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred2_t020fuzzyLexer(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred2_t020fuzzyLexer_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t020fuzzyLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
