/**
This class represents the data to be stored
for a user

For, eg. to represent the following data:
  Name: Justin Bieber
  Number: 231 377 1113
you'd create an object as follows:
  PhoneRecord pr = new PhoneRecord("Justin Bieber", "231 377 1113");

PS: Check this out: https://twitter.com/justinbieber/status/660185702651461632?lang=en

 */
public class PhoneRecord {
    public String name;
    public String number;

    public PhoneRecord(String name, String number) {
        this.name = name;
        this.number = number;
    }

}