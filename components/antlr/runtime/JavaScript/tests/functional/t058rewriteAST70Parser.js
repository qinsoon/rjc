// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g 2013-01-03 10:57:31

var t058rewriteAST70Parser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST70Parser.superclass.constructor.call(this, input, state);



    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(t058rewriteAST70Parser, {
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
org.antlr.lang.extend(t058rewriteAST70Parser, org.antlr.runtime.Parser, {
setTreeAdaptor: function(adaptor) {
    this.adaptor = adaptor;
},
getTreeAdaptor: function() {
    return this.adaptor;
},

    getTokenNames: function() { return t058rewriteAST70Parser.tokenNames; },
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST70Parser.prototype, {

    // inline static return class
    _return: (function() {
        t058rewriteAST70Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST70Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:4:1: modulo : 'modulo' ID ( '(' ( parms )+ ')' )? -> ^( 'modulo' ID ( ^( PARMS ( parms )+ ) )? ) ;
    // $ANTLR start "modulo"
    modulo: function() {
        var retval = new 
        t058rewriteAST70Parser._return
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
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule ");
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:5:2: ( 'modulo' ID ( '(' ( parms )+ ')' )? -> ^( 'modulo' ID ( ^( PARMS ( parms )+ ) )? ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:5:4: 'modulo' ID ( '(' ( parms )+ ')' )?






            // AST REWRITE
            // elements: parms, ID, 10
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token ",!=null?.tree:null);

            root_0 = this.adaptor.nil();
            // 5:34: -> ^( 'modulo' ID ( ^( PARMS ( parms )+ ) )? )
            {
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:5:37: ^( 'modulo' ID ( ^( PARMS ( parms )+ ) )? )
                {
                var root_1 = this.adaptor.nil();
                root_1 = this.adaptor.becomeRoot(
                stream_10.nextNode()
                , root_1);

                this.adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:5:51: ( ^( PARMS ( parms )+ ) )?
                if ( stream_parms.hasNext() ) {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:5:51: ^( PARMS ( parms )+ )
                    {
                    var root_2 = this.adaptor.nil();
                    root_2 = this.adaptor.becomeRoot(
                    this.adaptor.create(PARMS, "PARMS")
                    , root_2);

                    if ( !(stream_parms.hasNext()) ) {
                        throw new org.antlr.runtime.tree.RewriteEarlyExitException();
                    }
                    while ( stream_parms.hasNext() ) {
                        this.adaptor.addChild(root_2, stream_parms.nextTree());

                    }
                    stream_parms.reset();

                    this.adaptor.addChild(root_1, root_2);
                    }

                }
                stream_parms.reset();

                this.adaptor.addChild(root_0, root_1);
                }

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
        t058rewriteAST70Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST70Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:7:1: parms : ( '#' | ID );
    // $ANTLR start "parms"
    parms: function() {
        var retval = new 
        t058rewriteAST70Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;

        var _tree=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:7:7: ( '#' | ID )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST70.g:
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
org.antlr.lang.augmentObject(t058rewriteAST70Parser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "PARMS", "WS", "'#'", "'('", "')'", "'modulo'"],

});

})();