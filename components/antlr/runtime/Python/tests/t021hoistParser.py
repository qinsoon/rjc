# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g 2013-01-03 10:52:40

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
ID=4
INT=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "INT", "WS", "'enum'"
]




class t021hoistParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t021hoistParser, self).__init__(input, state, *args, **kwargs)



                      
        self.enableEnum = False


        self.delegates = []






    # $ANTLR start "stat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:11:1: stat returns [enumIs] : ( identifier | enumAsKeyword );
    def stat(self, ):
        enumIs = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:12:5: ( identifier | enumAsKeyword )
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if (LA1_0 == ID) :
                    alt1 = 1
                elif (LA1_0 == 7) :
                    LA1_2 = self.input.LA(2)

                    if ((not self.enableEnum)) :
                        alt1 = 1
                    elif ((self.enableEnum)) :
                        alt1 = 2
                    else:
                        nvae = NoViableAltException("", 1, 2, self.input)

                        raise nvae


                else:
                    nvae = NoViableAltException("", 1, 0, self.input)

                    raise nvae


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:12:7: identifier
                    pass 
                    self._state.following.append(self.FOLLOW_identifier_in_stat42)
                    self.identifier()

                    self._state.following.pop()

                    #action start
                    enumIs = "ID"
                    #action end



                elif alt1 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:13:7: enumAsKeyword
                    pass 
                    self._state.following.append(self.FOLLOW_enumAsKeyword_in_stat55)
                    self.enumAsKeyword()

                    self._state.following.pop()

                    #action start
                    enumIs = "keyword"
                    #action end




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return enumIs

    # $ANTLR end "stat"



    # $ANTLR start "identifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:16:1: identifier : ( ID | enumAsID );
    def identifier(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:17:5: ( ID | enumAsID )
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == ID) :
                    alt2 = 1
                elif (LA2_0 == 7) :
                    alt2 = 2
                else:
                    nvae = NoViableAltException("", 2, 0, self.input)

                    raise nvae


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:17:7: ID
                    pass 
                    self.match(self.input, ID, self.FOLLOW_ID_in_identifier74)


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:18:7: enumAsID
                    pass 
                    self._state.following.append(self.FOLLOW_enumAsID_in_identifier82)
                    self.enumAsID()

                    self._state.following.pop()



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "identifier"



    # $ANTLR start "enumAsKeyword"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:21:1: enumAsKeyword :{...}? 'enum' ;
    def enumAsKeyword(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:21:15: ({...}? 'enum' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:21:17: {...}? 'enum'
                pass 
                if not ((self.enableEnum)):
                    raise FailedPredicateException(self.input, "enumAsKeyword", "self.enableEnum")


                self.match(self.input, 7, self.FOLLOW_7_in_enumAsKeyword97)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "enumAsKeyword"



    # $ANTLR start "enumAsID"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:23:1: enumAsID :{...}? 'enum' ;
    def enumAsID(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:23:10: ({...}? 'enum' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t021hoist.g:23:12: {...}? 'enum'
                pass 
                if not ((not self.enableEnum)):
                    raise FailedPredicateException(self.input, "enumAsID", "not self.enableEnum")


                self.match(self.input, 7, self.FOLLOW_7_in_enumAsID108)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "enumAsID"



 

    FOLLOW_identifier_in_stat42 = frozenset([1])
    FOLLOW_enumAsKeyword_in_stat55 = frozenset([1])
    FOLLOW_ID_in_identifier74 = frozenset([1])
    FOLLOW_enumAsID_in_identifier82 = frozenset([1])
    FOLLOW_7_in_enumAsKeyword97 = frozenset([1])
    FOLLOW_7_in_enumAsID108 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t021hoistLexer", t021hoistParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
