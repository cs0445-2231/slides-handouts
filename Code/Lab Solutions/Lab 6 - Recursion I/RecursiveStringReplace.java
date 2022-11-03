
/**
 * A class that has a methond to recursively replaces characters in a String.
 * 
 * @author Charles Hoot
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
 * @version 4.1 (Modified for the Solution)
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 */
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     * 
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to)
    {
        String result = null;

        // IMPLEMENT THIS RECURSIVE METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
        if(s.length()== 0)
        {
            result = new String();
        }
        else
        {
            // get the first character
            char last = s.charAt(0);
            // strip off the first character and do the replace
            result = replace(s.substring(1), from, to);
            if(last == from)
                result = to + result;
            else
                result = last + result;
        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        

        return result;
    }


}
