# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g 2013-01-03 10:53:46

/** Convert the simple input to be java code; wrap in a class,
 *  convert method with "public void", add decls.  This shows how to insert
 *  extra text into a stream of tokens and how to replace a token
 *  with some text.  Calling toString() on the TokenRewriteStream
 *  in Main will print out the original input stream.
 *
 *  Note that you can do the instructions in any order as the
 *  rewrite instructions just get queued up and executed upon toString().
 */
package TParser;

use English qw( -no_match_vars ) ;
use Readonly;
use Switch;
use Carp;
use ANTLR::Runtime::BitSet;

use Moose;

extends 'ANTLR::Runtime::Parser';

Readonly my $token_names => [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'('", "')'", "'*'", "'+'", "';'", "'='", "'method'", "'{'", "'}'"
];

use constant {
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
};



sub BUILD {
    my ($self, $arg_ref) = @_;

}

sub get_token_names {
    return $token_names;
}

sub get_grammar_file_name {
    return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g";
}



# $ANTLR start program
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:13:1: program : ( method )+ ;
sub program() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:14:5: ( ( method )+ )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:14:9: ( method )+
        {




        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end program


{
    package 
method_return
;
    use ANTLR::Runtime::Class;

    extends 'ANTLR::Runtime::ParserRuleReturnScope';

}


# $ANTLR start method
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:22:1: method : m= 'method' ID '(' ')' body ;
sub method() {
    my ($self, ) = @_;
    my $retval = 
    method_return
    ->new();
    $retval->set_start($self->input->LT(1));


    my $ = undef;

    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:23:5: (m= 'method' ID '(' ')' body )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:23:9: m= 'method' ID '(' ')' body
        {












        }

        $retval->set_stop($self->input->LT(-1));


    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
$retval
;
}
# $ANTLR end method


protected static class body_scope {
    ;
}
protected Stack body_stack = new Stack();



# $ANTLR start body
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:27:1: body : lcurly= '{' ( stat )* '}' ;
sub body() {
    my ($self, ) = @_;
    _stack.push(new _scope());
    my $ = undef;


        ((body_scope)body_stack.peek()).decls = [];


    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:38:5: (lcurly= '{' ( stat )* '}' )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:38:9: lcurly= '{' ( stat )* '}'
        {








        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    _stack.pop();
    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end body



# $ANTLR start stat
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:47:1: stat : ID '=' expr ';' ;
sub stat() {
    my ($self, ) = @_;
    my $ = undef;

    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:47:5: ( ID '=' expr ';' )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:47:9: ID '=' expr ';'
        {










        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end stat



# $ANTLR start expr
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:50:1: expr : mul ( '+' mul )* ;
sub expr() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:50:5: ( mul ( '+' mul )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:50:9: mul ( '+' mul )*
        {




        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end expr



# $ANTLR start mul
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:53:1: mul : atom ( '*' atom )* ;
sub mul() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:53:5: ( atom ( '*' atom )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:53:9: atom ( '*' atom )*
        {




        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end mul



# $ANTLR start atom
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:56:1: atom : ( ID | INT );
sub atom() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:56:5: ( ID | INT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/tweak/T.g:
        {


        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end atom


 

no Moose;
__PACKAGE__->meta->make_immutable();
1;
__END__