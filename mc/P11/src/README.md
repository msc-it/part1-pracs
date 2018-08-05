# Practical 11

## Problem statement

#### Aim
Create an application to generate a persistent record storage with the help of `javax.microedition.rms` package.

#### Program descriptoin

We create an application that accepts a input and following two commands:

1. Search
1. Exit

Search command must perform a search from a persisted phonebook, and retrieve the results from it. Exit command must exit the application, duh.

## Code Explanation

The code is long and could get quite confusing had I written them in one class. So I've split them into several files. But I've written very basic code with lots of comments so you should be able to understand it by yourself if you go through it in the correct order.

#### Reading the code

Follow the following order while reading the code

1. `MyApp.java`
1. `PhoneRecord.java`
1. `Data.java`
1. `PhoneRecordFilter.java`
1. `Data.java` (yes, do this again)
1. `MyApp.java` (do this again as well)

Now you should have a fair idea of the code. I'd suggest you try and write this without seeing. If you get stuck, refer to the documentation since that's all you'll have access to during the examination. Refer to this only as a last resort.

### Writing the code

Always draw a basic UI sketch and then write the UI code first, followed by the implementation logic. UI **always** comes first.

In our case the UI code resides in `MyApp.java`. All the code in it except lines `37-43`, `51 - 53` and `72-75` perform UI code. So while writing the code, you'd ignore these and try to write as much of UI code as you can. Certain conditions might depend on the output of logic that you might not have written, you can get back to those later.

> It's also a good idea to build your code often to make sure there are no errors. Fix compile-time errors as and when you write the code. And run the code often to find and get rid of run-time errors as well.

Next you need to model the data. In our case the data is a phone record &mdash; each record containing a name and a phone number. I've made a data model in `PhoneRecord.java`. It's a very simple class with public fields for the data, and a public constructor.

Next, we need to deal storing/retrieving the actual data. I've created a `Data` class in `Data.java` with `static` methods for the same. The `public` methods will be used from the `MIDlet` class (`MyApp` in our case) and the `private` methods are helper methods, that exist to make the code more readable and modularized.

The `Data` class contains 3 public methods:

1. `initialize()`
1. `search()`
1. `deleteStore()`

`initialize()` is used to initialize the datastore with mock data for us to be able to test the search functionality.

`search()` contains the actual search logic.

`deleteStore()` is not used in the MIDlet, but can be used to delete the data if required while testing.

The `PhoneRecordFilter` class in `PhoneRecordFilter.java` is an implementation of the `Filter` interface from the `javax.microedition.rms` package. Refer to the documentation of the same to understand its working.

The code is only long, it's not difficult. If you're having a tough time understanding it, maybe you're not comfortable working with IO streams. So try figuring that out first, since IO streams are used extensively in the `Data` and `PhoneRecordFilter` classes. [This is a good starting point](https://www.javatpoint.com/java-io).
