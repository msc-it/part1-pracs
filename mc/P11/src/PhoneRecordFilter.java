import javax.microedition.rms.*;
import java.io.*;

public class PhoneRecordFilter implements RecordFilter {

    /**
    The string to search for
     */
    private String searchStr;
    // Constructor
    public PhoneRecordFilter(String str) {
        searchStr = str;
    }

    public boolean matches(byte[] suspect) {
        boolean matched = false;
        try {
            // Since we're reading from the bytes we create input streams
            // Create byte stream using input bytes
            ByteArrayInputStream bInput = new ByteArrayInputStream(suspect);
            // Create a higher level Data input stream
            DataInputStream iInput = new DataInputStream(bInput);

            // Read from the input stream and generate a PhoneRecord out of it
            PhoneRecord record = new PhoneRecord(iInput.readUTF(), iInput.readUTF());

            // The search logic
            // I've only used the name field to keep it simple
            // You can make it more sophisticated by allowing to search by numbers,
            // making text case-insensitive, ignoring spaces, etc.

            if(record.name.indexOf(searchStr) != -1) {
                matched = true;
            }

            // Close the streams
            iInput.close();
            bInput.close();

        } catch(Exception e) {
            e.printStackTrace();
            return matched;
        }
        return matched;
    }
}