// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g 2013-01-03 11:00:41

var t058rewriteAST45Parser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST45Parser.superclass.constructor.call(this, input, state);



    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(t058rewriteAST45Parser, {
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : 
});

(function(){
// public class variables
var = ,
    = ,
    = ,
    = ,
    = ,
    = ,
    = ,
    = ;

// public instance methods/vars
org.antlr.lang.extend(t058rewriteAST45Parser, org.antlr.runtime.Parser, {
setTreeAdaptor: function(adaptor) {
    this.adaptor = adaptor;
},
getTreeAdaptor: function() {
    return this.adaptor;
},

    getTokenNames: function() { return t058rewriteAST45Parser.tokenNames; },
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST45Parser.prototype, {

    // inline static return class
    _return: (function() {
        t058rewriteAST45Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST45Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:1: a : ( modifier )? type ID ( ',' ID )* ';' -> ( ^( type ( ^( MOD modifier ) )? ID ) )+ ;
    // $ANTLR start "a"
    a: function() {
        var retval = new 
        t058rewriteAST45Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;
        var  = null;
        var  = null;
        var  = null;

        var _tree=null;
        var _tree=null;
        var _tree=null;
        var _tree=null;
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule ");
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:3: ( ( modifier )? type ID ( ',' ID )* ';' -> ( ^( type ( ^( MOD modifier ) )? ID ) )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:5: ( modifier )? type ID ( ',' ID )* ';'










            // AST REWRITE
            // elements: modifier, type, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token ",!=null?.tree:null);

            root_0 = this.adaptor.nil();
            // 5:37: -> ( ^( type ( ^( MOD modifier ) )? ID ) )+
            {
                if ( !(stream_type.hasNext()||stream_ID.hasNext()) ) {
                    throw new org.antlr.runtime.tree.RewriteEarlyExitException();
                }
                while ( stream_type.hasNext()||stream_ID.hasNext() ) {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:40: ^( type ( ^( MOD modifier ) )? ID )
                    {
                    var root_1 = this.adaptor.nil();
                    root_1 = this.adaptor.becomeRoot(stream_type.nextNode(), root_1);

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:47: ( ^( MOD modifier ) )?
                    if ( stream_modifier.hasNext() ) {
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:5:47: ^( MOD modifier )
                        {
                        var root_2 = this.adaptor.nil();
                        root_2 = this.adaptor.becomeRoot(
                        this.adaptor.create(MOD, "MOD")
                        , root_2);

                        this.adaptor.addChild(root_2, stream_modifier.nextTree());

                        this.adaptor.addChild(root_1, root_2);
                        }

                    }
                    stream_modifier.reset();

                    this.adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    );

                    this.adaptor.addChild(root_0, root_1);
                    }

                }
                stream_type.reset();
                stream_ID.reset();

            }


            retval.tree = root_0;



            retval.stop = this.input.LT(-1);


            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }

        finally {
        }
        return 
    retval
    ;
    },


    // inline static return class
    _return: (function() {
        t058rewriteAST45Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST45Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:6:1: type : 'int' ;
    // $ANTLR start "type"
    type: function() {
        var retval = new 
        t058rewriteAST45Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;

        var _tree=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:6:6: ( 'int' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:6:8: 'int'
            root_0 = this.adaptor.nil();






            retval.stop = this.input.LT(-1);


            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }

        finally {
        }
        return 
    retval
    ;
    },


    // inline static return class
    _return: (function() {
        t058rewriteAST45Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST45Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:7:1: modifier : 'public' ;
    // $ANTLR start "modifier"
    modifier: function() {
        var retval = new 
        t058rewriteAST45Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;

        var _tree=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:7:10: ( 'public' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST45.g:7:12: 'public'
            root_0 = this.adaptor.nil();






            retval.stop = this.input.LT(-1);


            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }

        finally {
        }
        return 
    retval
    ;
    }

    // Delegated rules




}, true); // important to pass true to overwrite default implementations

 

// public class variables
org.antlr.lang.augmentObject(t058rewriteAST45Parser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "MOD", "WS", "','", "';'", "'int'", "'public'"],

});

})();