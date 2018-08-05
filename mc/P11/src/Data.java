import java.io.*;
import javax.microedition.rms.*;

public class Data {

    /**
        The name of our record store
     */
    private static final String STORE_NAME = "phonerecords";
    
    /**
    This method initializes the datastore by adding
    seed data into it. This can be used to test the RMS.
    In a real application, you'll want to create a form
    to add data individually.

    Returns true if success, else returns false
     */
    public static boolean initialize() {

        // Check if record store already exists
        if(recordStoreExists()) { // Scroll down to see what it does
            // It already exists, no need to do anything else
            return true;
        }

        // But if it doesn't exist, let's create one
        // and add some mock data into it

        // Create some mock data
        PhoneRecord[] data = getMockData(); // scroll down to see what it does ;)

        // Step 1: Open the store
        // The record store that stores the data
        RecordStore store;
        try { // Open the store
            store = RecordStore.openRecordStore(STORE_NAME, true);
        }
        catch(Exception e) {
            return false; // Opening failed
        }

        // Step 2: Write to the store
        try {
            // Since we need to write the data we create OutputStreams
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            DataOutputStream dStream = new DataOutputStream(bStream);

            // Loop through the data array
            for(int i = 0; i < data.length; i++) {
                // Write the name and number to the datastream as UTF Strings
                dStream.writeUTF(data[i].name);
                dStream.writeUTF(data[i].number);
                // Flush to make sure all the data gets written to the underlying output stream
                dStream.flush();
                // Get the data as bytes from the output stream
                byte[] record = bStream.toByteArray();
                // Add the record to the record store
                store.addRecord(record, 0, record.length);
                // Clear the underlying output stream
                bStream.reset();
            }

            // Close the streams
            // TODO: move these to the finally clause, else streams 
            //       won't be closed when an exception is thrown
            dStream.close();
            bStream.close();

        } catch (Exception e) {
            return false; // Something's gone wrong while writing to the store
        }

        // Step 3: Close the store
        try {
            store.closeRecordStore();
        } catch (Exception e) {
            return false; // Error while closing the store
        }

        return true; // All good, yay!
    }

    /**
        Performs a search and generates an output string
        Returns null if no matches found
     */
    public static String search(String input) {
        // Step 1: Open the record store
        String output = null;
        RecordStore store;
        try {
            store = RecordStore.openRecordStore(STORE_NAME, false);
        }
        catch (Exception e) {
            return null; // Error opening the store
        }

        try {
            if(store.getNumRecords() > 0) {
                // Step 2: Perform the search
                // A) Create filter
                PhoneRecordFilter filter = new PhoneRecordFilter(input);
                // B) Apply the filter on the store
                RecordEnumeration matches = store.enumerateRecords(filter, null, false);
                // C) If no matches exist, return null
                if(matches.numRecords() == 0) {
                    return null;
                }
                // ... else read the matches and generate output string
                output = "";
                while(matches.hasNextElement()) {
                    // Get the data from the record
                    byte[] data = store.getRecord(matches.nextRecordId());
                    // Read the bytes as a Stream
                    ByteArrayInputStream bInput = new ByteArrayInputStream(data);
                    // Create a higher level Data input stream
                    DataInputStream dInput = new DataInputStream(bInput);
                    // Read from the input stream and generate a PhoneRecord out of it
                    PhoneRecord record = new PhoneRecord(dInput.readUTF(), dInput.readUTF());
                    output += "Name:  " + record.name + "\n";
                    output += "Phone: " + record.number + "\n\n";
                }
            }
        }
        catch(Exception e) {
            return null;
        }

        // Close the store
        try {
            store.closeRecordStore();
        }
        catch (Exception e) {
            return null; // Error closing the store
        }

        // Return the output
        return output;
    }

    /**
    Returns true if the record store already exists
     */
    private static boolean recordStoreExists() {
        // Get list of record stores
        String[] list = RecordStore.listRecordStores();
        if(list == null) {
            // There's nothing in there
            return false; // Does not exist
        }

        // Records exist, we need to check if the record
        // we're interested in exists
        for(int i = 0; i < list.length; i++) {
            if(list[i].equals(STORE_NAME)) {
                return true; // We found a match!
            }
        }

        return false; // Does not exist
    }

    /**
    Deletes the data store
    Returns true if success, else false

    ONLY USED FOR TESTING, IN THE PROGRAM
    */
    public static boolean deleteStore() {
        try {
            RecordStore.deleteRecordStore(STORE_NAME);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false; // Error while deleting the store
        }
        return true; // All good :D
    }

    private static PhoneRecord[] getMockData() {
        // Create an array of PhoneRecords and return it
        // I've added 100 just to make sure we have enough ¯\_(ツ)_/¯
        // Datasource: http://www.generatedata.com/
        PhoneRecord[] mockData = {
            new PhoneRecord("Megan Stone", "256 516 0170"),
            new PhoneRecord("Autumn Lindsay", "756 638 4978"),
            new PhoneRecord("Yvette Boyd", "526 436 9018"),
            new PhoneRecord("Xerxes Rich", "880 894 7664"),
            new PhoneRecord("Wang Kerr", "634 254 6310"),
            new PhoneRecord("Maya Dodson", "875 528 2002"),
            new PhoneRecord("Harding Stein", "846 429 4753"),
            new PhoneRecord("Ariel Lewis", "987 991 9546"),
            new PhoneRecord("Gretchen Bond", "792 426 3558"),
            new PhoneRecord("Preston Bentley", "984 602 2867"),
            new PhoneRecord("Quentin Weeks", "758 367 7622"),
            new PhoneRecord("Nelle Blackburn", "325 950 9883"),
            new PhoneRecord("Ayanna Dennis", "338 250 9021"),
            new PhoneRecord("Destiny Strickland", "679 191 9260"),
            new PhoneRecord("Colt Howard", "764 783 2137"),
            new PhoneRecord("Hedley Whitley", "574 984 7317"),
            new PhoneRecord("Shafira Mcclure", "786 229 0334"),
            new PhoneRecord("Blossom Schwartz", "968 269 7721"),
            new PhoneRecord("Akeem Caldwell", "557 699 0513"),
            new PhoneRecord("Derek Armstrong", "401 611 7201"),
            new PhoneRecord("Philip Lloyd", "348 543 6133"),
            new PhoneRecord("Linda Blanchard", "562 691 8729"),
            new PhoneRecord("Zelda Weiss", "951 855 6247"),
            new PhoneRecord("Colette Rivas", "297 584 7218"),
            new PhoneRecord("Lillian Mckenzie", "444 953 2085"),
            new PhoneRecord("Rooney Gill", "911 583 8804"),
            new PhoneRecord("Berk Flowers", "945 453 4317"),
            new PhoneRecord("Jermaine Zamora", "586 507 9492"),
            new PhoneRecord("Eric Levy", "336 848 8289"),
            new PhoneRecord("Jameson Terrell", "573 449 8452"),
            new PhoneRecord("MacKensie Schwartz", "595 487 5872"),
            new PhoneRecord("Nadine Stark", "102 257 8614"),
            new PhoneRecord("Laurel Alston", "492 178 1987"),
            new PhoneRecord("Constance Perez", "448 992 9945"),
            new PhoneRecord("Dieter Turner", "174 664 3087"),
            new PhoneRecord("Helen Rowe", "295 696 7747"),
            new PhoneRecord("Joelle Garza", "338 982 6345"),
            new PhoneRecord("Mary Clark", "801 635 9426"),
            new PhoneRecord("Janna Mcintosh", "992 546 0589"),
            new PhoneRecord("Odette Castillo", "414 926 2086"),
            new PhoneRecord("Cassady Pugh", "115 385 3828"),
            new PhoneRecord("Scarlet Cline", "320 436 6916"),
            new PhoneRecord("Rhonda Lancaster", "705 731 1622"),
            new PhoneRecord("Francesca Mcgee", "783 868 8957"),
            new PhoneRecord("Samantha Little", "625 818 0866"),
            new PhoneRecord("Phoebe Sellers", "370 296 1017"),
            new PhoneRecord("Denise Norman", "510 289 8995"),
            new PhoneRecord("Hayfa Franklin", "984 804 0111"),
            new PhoneRecord("Kaden Schwartz", "790 628 1765"),
            new PhoneRecord("Nelle Hodges", "202 953 9348"),
            new PhoneRecord("Sonia Hendrix", "320 819 6851"),
            new PhoneRecord("Belle Morgan", "671 528 3746"),
            new PhoneRecord("Camilla Brock", "364 472 3156"),
            new PhoneRecord("Aaron Humphrey", "582 405 1310"),
            new PhoneRecord("Wyatt Brooks", "308 177 1700"),
            new PhoneRecord("Rooney Harrison", "696 351 5289"),
            new PhoneRecord("Ifeoma Head", "156 353 3717"),
            new PhoneRecord("Raymond Fitzpatrick", "151 995 5373"),
            new PhoneRecord("Jakeem Bauer", "713 670 1861"),
            new PhoneRecord("Martena Morse", "693 894 4933"),
            new PhoneRecord("Sloane Patel", "398 294 8480"),
            new PhoneRecord("Brenden Maldonado", "799 878 5094"),
            new PhoneRecord("Jordan Donovan", "724 310 4418"),
            new PhoneRecord("Asher Shepard", "152 130 2293"),
            new PhoneRecord("Lysandra Irwin", "261 873 6950"),
            new PhoneRecord("Blake Aguilar", "948 105 3614"),
            new PhoneRecord("Kristen Dawson", "814 582 7421"),
            new PhoneRecord("Vanna Hawkins", "538 478 7868"),
            new PhoneRecord("Wallace Downs", "810 154 6536"),
            new PhoneRecord("Aubrey Harmon", "182 324 7616"),
            new PhoneRecord("Melanie Franks", "360 384 9223"),
            new PhoneRecord("Latifah Stafford", "880 338 0713"),
            new PhoneRecord("Isaac Barron", "373 824 3867"),
            new PhoneRecord("Hayden Mccarty", "969 975 1473"),
            new PhoneRecord("Rae Head", "542 303 9315"),
            new PhoneRecord("Cleo Holloway", "144 290 0787"),
            new PhoneRecord("Shafira Hart", "956 942 1818"),
            new PhoneRecord("Lane Hendricks", "992 305 4938"),
            new PhoneRecord("Miranda Hogan", "245 675 8871"),
            new PhoneRecord("Nita Good", "741 327 5173"),
            new PhoneRecord("Jordan Montoya", "407 577 0687"),
            new PhoneRecord("Jael Barton", "562 792 6562"),
            new PhoneRecord("Kathleen Guzman", "566 846 8112"),
            new PhoneRecord("Brock Bush", "900 200 4214"),
            new PhoneRecord("Rhiannon Massey", "362 753 7143"),
            new PhoneRecord("Paul Short", "743 825 5660"),
            new PhoneRecord("Steel Carlson", "912 712 6292"),
            new PhoneRecord("Zeus Davenport", "247 352 9679"),
            new PhoneRecord("Tana Vincent", "918 224 1134"),
            new PhoneRecord("Brianna Gardner", "730 939 2759"),
            new PhoneRecord("Ria Nieves", "450 155 4446"),
            new PhoneRecord("Mechelle Hinton", "104 475 4920"),
            new PhoneRecord("Naomi Farrell", "281 888 8650"),
            new PhoneRecord("Illana Patterson", "708 594 4621"),
            new PhoneRecord("Halla Leach", "553 272 7581"),
            new PhoneRecord("Serena Maldonado", "888 228 3009"),
            new PhoneRecord("Catherine Le", "758 350 4263"),
            new PhoneRecord("Hollee Dean", "937 220 9801"),
            new PhoneRecord("Shay Weiss", "248 575 4595"),
            new PhoneRecord("Leandra Wilder", "236 629 3607")
        };
        return mockData;
    }
}