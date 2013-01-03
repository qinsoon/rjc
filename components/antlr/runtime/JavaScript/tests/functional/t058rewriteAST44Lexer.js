// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g 2013-01-03 11:00:49

var t058rewriteAST44Lexer = function(input, state) {
// alternate constructor @todo
// public t058rewriteAST44Lexer(CharStream input)
// public t058rewriteAST44Lexer(CharStream input, RecognizerSharedState state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST44Lexer.superclass.constructor.call(this, input, state);

};

org.antlr.lang.augmentObject(t058rewriteAST44Lexer, {
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : 
});

(function(){
var HIDDEN = org.antlr.runtime.Token.HIDDEN_CHANNEL,
    EOF = org.antlr.runtime.Token.EOF;
org.antlr.lang.extend(t058rewriteAST44Lexer, org.antlr.runtime.Lexer, {
     : ,
     : ,
     : ,
     : ,
     : ,
     : ,
     : ,
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST44Lexer.prototype, {
    // $ANTLR start T__6
    mT__6: function()  {
        try {
            var _type = this.T__6;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:7:6: ( ',' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:7:8: ','




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__6",

    // $ANTLR start T__7
    mT__7: function()  {
        try {
            var _type = this.T__7;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:8:6: ( ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:8:8: ';'




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__7",

    // $ANTLR start T__8
    mT__8: function()  {
        try {
            var _type = this.T__8;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:9:6: ( 'int' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:9:8: 'int'




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__8",

    // $ANTLR start T__9
    mT__9: function()  {
        try {
            var _type = this.T__9;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:10:6: ( 'public' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:10:8: 'public'




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__9",

    // $ANTLR start ID
    mID: function()  {
        try {
            var _type = this.ID;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:7:4: ( ( 'a' .. 'z' )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:7:6: ( 'a' .. 'z' )+




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "ID",

    // $ANTLR start WS
    mWS: function()  {
        try {
            var _type = this.WS;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:8:4: ( ( ' ' | '\\n' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:8:6: ( ' ' | '\\n' )






            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "WS",

    mTokens: function() {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST44.g:1:8: ( T__6 | T__7 | T__8 | T__9 | ID | WS )
        var alt2=6;
        switch ( this.input.LA(1) ) {
        case :
            alt2=1;
            break;
        case :
            alt2=2;
            break;
        case :
            var LA2_3 = this.input.LA(2);

            if ( (LA2_3=='n') ) {
                var LA2_7 = this.input.LA(3);

                if ( (LA2_7=='t') ) {
                    var LA2_9 = this.input.LA(4);

                    if ( ((LA2_9>='a' && LA2_9<='z')) ) {
                        alt2=5;
                    }
                    else {
                        alt2=3;
                    }
                }
                else {
                    alt2=5;
                }
            }
            else {
                alt2=5;
            }
            break;
        case :
            var LA2_4 = this.input.LA(2);

            if ( (LA2_4=='u') ) {
                var LA2_8 = this.input.LA(3);

                if ( (LA2_8=='b') ) {
                    var LA2_10 = this.input.LA(4);

                    if ( (LA2_10=='l') ) {
                        var LA2_12 = this.input.LA(5);

                        if ( (LA2_12=='i') ) {
                            var LA2_13 = this.input.LA(6);

                            if ( (LA2_13=='c') ) {
                                var LA2_14 = this.input.LA(7);

                                if ( ((LA2_14>='a' && LA2_14<='z')) ) {
                                    alt2=5;
                                }
                                else {
                                    alt2=4;
                                }
                            }
                            else {
                                alt2=5;
                            }
                        }
                        else {
                            alt2=5;
                        }
                    }
                    else {
                        alt2=5;
                    }
                }
                else {
                    alt2=5;
                }
            }
            else {
                alt2=5;
            }
            break;
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
            alt2=5;
            break;
        case :
        case :
            alt2=6;
            break;
        default:
            var nvae =
                new org.antlr.runtime.NoViableAltException("", 2, 0, this.input);

            throw nvae;

        }

        switch (alt2) {
            case  :
                break;
            case  :
                break;
            case  :
                break;
            case  :
                break;
            case  :
                break;
            case  :
                break;

        }

    }

}, true); // important to pass true to overwrite default implementations

 
})();