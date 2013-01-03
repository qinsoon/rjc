# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g 2013-01-03 10:54:05

package MExprParser;

use English qw( -no_match_vars ) ;
use Readonly;
use Switch;
use Carp;
use ANTLR::Runtime::BitSet;

use Moose;

extends 'ANTLR::Runtime::Parser';

Readonly my $token_names => [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", "'('", "')'", "'+'", "'-'"
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
};



sub BUILD {
    my ($self, $arg_ref) = @_;

}

sub get_token_names {
    return $token_names;
}

sub get_grammar_file_name {
    return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g";
}



# $ANTLR start prog
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:7:1: prog : ( stat )+ ;
sub prog() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:7:5: ( ( stat )+ )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:7:9: ( stat )+
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
# $ANTLR end prog



# $ANTLR start stat
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:9:1: stat : ( expr NEWLINE | NEWLINE );
sub stat() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:9:5: ( expr NEWLINE | NEWLINE )
        my $alt2 = 2;
        my $LA2_0 = $self->input->LA(1);

        if ( ($LA2_0 eq INT || $LA2_0 eq 8) ) {
            $alt2 = 1;
        }
        elsif ( ($LA2_0 eq NEWLINE) ) {
            $alt2 = 2;
        }
        else {
            my $nvae =
                ANTLR::Runtime::NoViableAltException->new({
                    grammar_decision_description => "",
                    decision_number => 2,
                    state_number => 0,
                    input => $self->input,
                });

            croak $nvae;

        }
        switch ($alt2) {
            case  {
            }
            case  {
            }

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
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:13:1: expr returns [value] : e= atom ( '+' e= atom | '-' e= atom )* ;
sub expr() {
    my ($self, ) = @_;
    my $value = 
    undef
    ;


    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:14:5: (e= atom ( '+' e= atom | '-' e= atom )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:14:9: e= atom ( '+' e= atom | '-' e= atom )*
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
$value
;
}
# $ANTLR end expr



# $ANTLR start atom
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:20:1: atom returns [value] : ( INT | '(' expr ')' );
sub atom() {
    my ($self, ) = @_;
    my $value = 
    undef
    ;


    my $ = undef;

    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/mexpr/MExpr.g:21:5: ( INT | '(' expr ')' )
        my $alt4 = 2;
        my $LA4_0 = $self->input->LA(1);

        if ( ($LA4_0 eq INT) ) {
            $alt4 = 1;
        }
        elsif ( ($LA4_0 eq 8) ) {
            $alt4 = 2;
        }
        else {
            my $nvae =
                ANTLR::Runtime::NoViableAltException->new({
                    grammar_decision_description => "",
                    decision_number => 4,
                    state_number => 0,
                    input => $self->input,
                });

            croak $nvae;

        }
        switch ($alt4) {
            case  {
            }
            case  {
            }

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
$value
;
}
# $ANTLR end atom


 

no Moose;
__PACKAGE__->meta->make_immutable();
1;
__END__