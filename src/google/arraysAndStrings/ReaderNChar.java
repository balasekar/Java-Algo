package google.arraysAndStrings;

import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

public class ReaderNChar {

    char[] readBuffer = new char[4];
    int bufferPointer = 0;
    int bufferCounter = 0;
    boolean eof = false;
    public int read(char[] buf, int n) {
        if(eof) return 0;

        int pointer = 0;
        while(pointer < n) {
            if(bufferPointer<bufferCounter) {
                buf[pointer++] = readBuffer[bufferPointer++];
            } else {
                bufferCounter = read4(readBuffer);
                bufferPointer = 0;
                if(bufferCounter == 0) {
                    eof = true;
                    break;
                }
            }
        }
        return pointer;
    }

    private int read4(char[] charArray) {
        try {
            String str = "GeeksForGeeks";
            Reader reader = new StringReader(str);
            reader.read(charArray);
            System.out.println(Arrays.toString(charArray));
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return charArray.length;
    }
}
