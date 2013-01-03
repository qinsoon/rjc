# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g 2013-01-03 10:52:18

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
NAME=4
NUMBER=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "NAME", "NUMBER", "WS"
]




class t031emptyAltParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t031emptyAltParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "r"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:6:1: r : NAME ({...}? => ( WS )+ NAME |) EOF ;
    def r(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:7:5: ( NAME ({...}? => ( WS )+ NAME |) EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:7:7: NAME ({...}? => ( WS )+ NAME |) EOF
                pass 
                self.match(self.input, NAME, self.FOLLOW_NAME_in_r27)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:8:9: ({...}? => ( WS )+ NAME |)
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == WS) and ((self.cond)):
                    alt2 = 1
                elif (LA2_0 == EOF) :
                    alt2 = 2
                else:
                    nvae = NoViableAltException("", 2, 0, self.input)

                    raise nvae


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:8:11: {...}? => ( WS )+ NAME
                    pass 
                    if not ((self.cond)):
                        raise FailedPredicateException(self.input, "r", "self.cond")


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:8:26: ( WS )+
                    cnt1 = 0
                    while True: #loop1
                        alt1 = 2
                        LA1_0 = self.input.LA(1)

                        if (LA1_0 == WS) :
                            alt1 = 1


                        if alt1 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:8:26: WS
                            pass 
                            self.match(self.input, WS, self.FOLLOW_WS_in_r43)


                        else:
                            if cnt1 >= 1:
                                break #loop1

                            eee = EarlyExitException(1, self.input)
                            raise eee

                        cnt1 += 1


                    self.match(self.input, NAME, self.FOLLOW_NAME_in_r46)


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t031emptyAlt.g:10:9: 
                    pass 



                self.match(self.input, EOF, self.FOLLOW_EOF_in_r77)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "r"



 

    FOLLOW_NAME_in_r27 = frozenset([6])
    FOLLOW_WS_in_r43 = frozenset([4, 6])
    FOLLOW_NAME_in_r46 = frozenset([])
    FOLLOW_EOF_in_r77 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t031emptyAltLexer", t031emptyAltParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
