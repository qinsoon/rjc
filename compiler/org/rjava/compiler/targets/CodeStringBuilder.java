package org.rjava.compiler.targets;

public class CodeStringBuilder {
    public static final String INDENT = "  ";
    public static final String INDENT_2 = INDENT + INDENT;
    public static final String INDENT_3 = INDENT_2 + INDENT;
    
    StringBuilder builder = new StringBuilder();
    int indentLevel = 0;
    
    public void increaseIndent() {
        indentLevel ++;
    }
    
    public void decreaseIndent() {
        if (indentLevel > 0)
            indentLevel --;
        else throw new RuntimeException("Trying to decrease indent level when indent level is already 0");
    }
    
    public void append(Object o) {
        builder.append(getIndent());
        builder.append(o);
    }
    
    public void appendNoIndent(Object o) {
        builder.append(o);
    }
    
    private String getIndent() {
        switch(indentLevel) {
        case 0: return "";
        case 1: return INDENT;
        case 2: return INDENT_2;
        case 3: return INDENT_3;
        default:
            String ret = "";
            for (int i = 0; i < indentLevel; i++)
                ret += INDENT;
            return ret;                  
        }
    }
    
    public String toString() {
        return builder.toString();
    }
}
