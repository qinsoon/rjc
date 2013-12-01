package testbed.mmtkext;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Word;
import org.vmutil.options.AddressOption;
import org.vmutil.options.BooleanOption;
import org.vmutil.options.EnumOption;
import org.vmutil.options.FloatOption;
import org.vmutil.options.IntOption;
import org.vmutil.options.MicrosecondsOption;
import org.vmutil.options.Option;
import org.vmutil.options.OptionSet;
import org.vmutil.options.PagesOption;
import org.vmutil.options.StringOption;

import testbed.Constants;
import testbed.Main;
@RJavaCore
public class GCOptionSet extends OptionSet {
    private String prefix;
    
    public GCOptionSet(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Take a string (most likely a command-line argument) and try to proccess it
     * as an option command.  Return true if the string was understood, false
     * otherwise.
     *
     * @param arg a String to try to process as an option command
     * @return {@code true} if successful, {@code false} otherwise
     */
    public boolean process(String arg) {

      // First handle the "option commands"
      if (arg.equals("help")) {
         printHelp();
         return true;
      }
      if (arg.equals("printOptions")) {
         printOptions();
         return true;
      }
      if (arg.length() == 0) {
        printHelp();
        return true;
      }

      // Required format of arg is 'name=value'
      // Split into 'name' and 'value' strings
      int split = arg.indexOf('=');
      if (split == -1) {
        Main.println("  Illegal option specification!\n  \""+arg+
                    "\" must be specified as a name-value pair in the form of option=value");
        return false;
      }

      String name = arg.substring(0,split);
      String value = arg.substring(split+1);

      Option o = getOption(name);

      if (o == null) return false;

      switch (o.getType()) {
        case Option.BOOLEAN_OPTION:
          if (value.equals("true")) {
            ((BooleanOption)o).setValue(true);
            return true;
          } else if (value.equals("false")) {
            ((BooleanOption)o).setValue(false);
            return true;
          }
          return false;
        case Option.INT_OPTION:
          int ival = Integer.parseInt(value);
          ((IntOption)o).setValue(ival);
          return true;
        case Option.ADDRESS_OPTION:
          ival = Integer.parseInt(value);
          ((AddressOption)o).setValue(ival);
          return true;
        case Option.FLOAT_OPTION:
          float fval = Float.parseFloat(value);
          ((FloatOption)o).setValue(fval);
          return true;
        case Option.STRING_OPTION:
          ((StringOption)o).setValue(value);
          return true;
        case Option.ENUM_OPTION:
          ((EnumOption)o).setValue(value);
          return true;
        case Option.PAGES_OPTION:
          /*long pval = CommandLineArgs.parseMemorySize(o.getName(), name, "b", 1, arg, value);
          if (pval < 0) return false;
          ((PagesOption)o).setBytes(Extent.fromIntSignExtend((int)pval));*/
          return true;
        case Option.MICROSECONDS_OPTION:
          int mval = Integer.parseInt(value);
          ((MicrosecondsOption)o).setMicroseconds(mval);
          return true;
      }

      // None of the above tests matched, so this wasn't an option
      return false;
    }

    /**
     * Print a short description of every option
     */
    public void printHelp() {

      Main.println("Commands");
      Main.print(prefix);Main.println("[:help]\t\t\tPrint brief description of arguments");
      Main.print(prefix);Main.println(":printOptions\t\tPrint the current values of options");
      Main.println();

      //Begin generated help messages
      Main.print("Boolean Options (");
      Main.print(prefix);Main.print(":<option>=true or ");
      Main.print(prefix);Main.println(":<option>=false)");
      Main.println("Option                                 Description");

      Option o = getFirst();
      while (o != null) {
        if (o.getType() == Option.BOOLEAN_OPTION) {
          String key = o.getKey();
          Main.print(key);
          for (int c = key.length(); c<39;c++) {
            Main.print(" ");
          }
          Main.println(o.getDescription());
        }
        o = o.getNext();
      }

      Main.print("\nValue Options (");Main.print(prefix);Main.println(":<option>=<value>)");
      Main.println("Option                         Type    Description");

      o = getFirst();
      while (o != null) {
        if (o.getType() != Option.BOOLEAN_OPTION &&
            o.getType() != Option.ENUM_OPTION) {
          String key = o.getKey();
          Main.print(key);
          for (int c = key.length(); c<31;c++) {
            Main.print(" ");
          }
          switch (o.getType()) {
            case Option.INT_OPTION:          Main.print("int     "); break;
            case Option.ADDRESS_OPTION:      Main.print("address "); break;
            case Option.FLOAT_OPTION:        Main.print("float   "); break;
            case Option.MICROSECONDS_OPTION: Main.print("usec    "); break;
            case Option.PAGES_OPTION:        Main.print("bytes   "); break;
            case Option.STRING_OPTION:       Main.print("string  "); break;
          }
          Main.println(o.getDescription());
        }
        o = o.getNext();
      }

      Main.println("\nSelection Options (set option to one of an enumeration of possible values)");

      o = getFirst();
      while (o != null) {
        if (o.getType() == Option.ENUM_OPTION) {
          String key = o.getKey();
          Main.print(key);
          for (int c = key.length(); c<31;c++) {
            Main.print(" ");
          }
          Main.println(o.getDescription());
          Main.print("    { ");
          boolean first = true;
          for (String val : ((EnumOption)o).getValues()) {
            Main.print(first ? "" : ", ");
            Main.print(val);
            first = false;
          }
          Main.println(" }");
        }
        o = o.getNext();
      }

      Main.sysExit(10);
    }

    /**
     * Print out the option values
     */
    public void printOptions() {
      Main.println("Current value of GC options");

      Option o = getFirst();
      while (o != null) {
        if (o.getType() == Option.BOOLEAN_OPTION) {
          String key = o.getKey();
          Main.print("\t");
          Main.print(key);
          for (int c = key.length(); c<31;c++) {
            Main.print(" ");
          }
          Main.print(" = ");
          logValue(o, false);
          Main.println();
        }
        o = o.getNext();
      }

      o = getFirst();
      while (o != null) {
        if (o.getType() != Option.BOOLEAN_OPTION &&
            o.getType() != Option.ENUM_OPTION) {
          String key = o.getKey();
          Main.print("\t");
          Main.print(key);
          for (int c = key.length(); c<31;c++) {
            Main.print(" ");
          }
          Main.print(" = ");
          logValue(o, false);
          Main.println();
        }
        o = o.getNext();
      }

      o = getFirst();
      while (o != null) {
        if (o.getType() == Option.ENUM_OPTION) {
          String key = o.getKey();
          Main.print("\t");
          Main.print(key);
          for (int c = key.length(); c<31;c++) {
            Main.print(" ");
          }
          Main.print(" = ");
          logValue(o, false);
          Main.println();
        }
        o = o.getNext();
      }
    }

    @Override
    protected void logValue(Option o, boolean forXml) {
      switch (o.getType()) {
      case Option.BOOLEAN_OPTION:
        Main.print(((BooleanOption) o).getValue() ? "true" : "false");
        break;
      case Option.INT_OPTION:
        Main.print(((IntOption) o).getValue());
        break;
      case Option.ADDRESS_OPTION:
        Main.print(((AddressOption) o).getValue());
        break;
      case Option.FLOAT_OPTION:
        Main.print(((FloatOption) o).getValue());
        break;
      case Option.MICROSECONDS_OPTION:
        Main.print(((MicrosecondsOption) o).getMicroseconds());
        Main.print(" usec");
        break;
      case Option.PAGES_OPTION:
        Main.print(((PagesOption) o).getBytes());
        Main.print(" bytes");
        break;
      case Option.STRING_OPTION:
        Main.print(((StringOption) o).getValue());
        break;
      case Option.ENUM_OPTION:
        Main.print(((EnumOption) o).getValueString());
        break;
      }
    }

    @Override
    protected void logString(String s) {
      Main.print(s);
    }

    @Override
    protected void logNewLine() {
      Main.println();
    }

    @Override
    protected String computeKey(String name) {
      int space = name.indexOf(' ');
      if (space < 0) return name.toLowerCase();

      String word = name.substring(0, space);
      String key = word.toLowerCase();

      do {
        int old = space+1;
        space = name.indexOf(' ', old);
        if (space < 0) {
          key += name.substring(old);
          return key;
        }
        key += name.substring(old, space);
      } while (true);
    }

    @Override
    protected void warn(Option o, String message) {
      Main.println("WARNING: Option '" + o.getKey() + "' : " + message);
    }

    @Override
    protected void fail(Option o, String message) {
      Main.sysFail("ERROR: Option '" + o.getKey() + "' : " + message);
    }

    @Override
    @Uninterruptible
    protected int bytesToPages(Extent bytes) {
      return bytes.plus(Constants.BYTES_IN_PAGE-1).toWord().rshl(Constants.LOG_BYTES_IN_PAGE).toInt();
    }

    @Override
    @Uninterruptible
    protected Extent pagesToBytes(int pages) {
      return Word.fromIntZeroExtend(pages).lsh(Constants.LOG_BYTES_IN_PAGE).toExtent();
    }

}
