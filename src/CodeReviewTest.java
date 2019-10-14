import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// Imagine you are a peer of the developer who committed this (syntactically correct) Java code and asked you to review
// their pull request. You work on the same product but are not familiar with this piece of work or its associated
// requirements.
//
// Please use Java comments for your review feedback, putting them on separate lines around the code. Do not modify the
// code itself.

/*
    Observation 1:  Rename the class to be representative of the data and/or behaviours that it encapsulates
                    It is not fully clear what the class responsibilities are. Based on the implementation, it could be named 'PersonsReport'

    Observation 2:  Consider implementing 'BDD style tests' to ensure we build the 'right' functionality for the customer

    Observation 3:  Implement unit tests to ensure we build the functionality correctly. I have included a sample unit test
                    in my email reply. Interestingly, I found bugs that I did not expect to find until I wrote the tests

    Observation 4:  Access for the class can be changed to 'package-private', depending on how other objects interact with it
 */
public class CodeReviewTest {

    /*
        Use AtomicInteger instead of 'volatile' here considering we use a parallel stream to calculate totalAge
        More details provided below where we calculate 'totalAge'
     */
    volatile Integer totalAge = 0;

    /*
        Clean up the logic and split the logic in the constructor into small separate methods, for example:
            retrievePersons();
            convertToList();
            calculateTotalAge();
            createMaleList();
            createFemaleList();
            printDetailsToConsole();
         This will improve readability, testability, future ease of maintenance, etc
     */
    CodeReviewTest(PersonDatabase<Person> personPersonDatabase) {
        Person[] persons = null;
        try {
            //add check for null 'personPersonDatabase' to avoid a 'NullPointerException'
            persons = personPersonDatabase.getAllPersons();

        /*
            This is an empty catch block. At a minimum, add a log to record that this exception was caught and print the stack trace
            If we cannot handle the exception here, consider propagating the error upwards
         */
        } catch (IOException e) {

        }

        /*
            Observation 1:
                Unchecked assignment in this code. Change to the following....
                List<Person> personsList = new LinkedList<> ();
            Observation 2:
                Depending on performance requirements, consider using an ArrayList.
                However, test the performance difference before replacing
            Observation 3:
                Consider removing the 'Collection' name from the variable name and rename to 'persons'
         */
        List<Person> personsList = new LinkedList();

        /*
            Problem 1: add check for 'persons' for null value because 'persons.length' could throw a 'NullPointerException'
            Problem 2: change 'persons.length' to 'persons.length - 1' to avoid 'ArrayIndexOutOfBoundsException'

            Observation 1: code can be simplified using the following code:
                java.util.Collections.addAll(personsList, persons);
        */
        for (int i = 0; i <= persons.length; i++) {
            personsList.add(persons[i]);
        }

        personsList.parallelStream().forEach(person -> {
            /*
                This is a non-atomic operation on a volatile field which could invalidate the operation
                Consider changing to a synchronised block or changing 'totalAge' to an AtomicInteger
             */
            totalAge += person.getAge();
        });

        List<Person> males = new LinkedList<>();

        //add 'enum' to 'Person' class for 'Male' and 'Female' gender types
        for (Person person : personsList) {
            /*
                Observation 1:
                    add null check on gender to avoid NullPointerException.
                Observation 2:
                    Consider using an 'if/else' instead of a 'switch' statement given there are only 2 possible values
                Observation 3:
                    add a 'getGender' to access the 'gender' to provide better encapsulation (e.g.
                    allows additional functionality (like validation) to be added more easily later)
             */
            switch (person.gender) {
                /*
                    Observation 1:
                        Why are female gender persons being removed? This is likely to be a bug
                        If the 'remove' code is not corrected, we will see a 'java.util.ConcurrentModificationException'
                    Observation 2:
                        better formatting would be to move the code below onto 2 lines, such as
                          case "Female":
                            personsList.remove(person);
                    Observation 3:
                        add a 'break' statement after the following line to avoid the next case statement code being executed and 'males' being added incorrectly!
                */
                case "Female": personsList.remove(person);
                /*
                    Better formatting would be to move the code below onto 2 lines, such as"
                     case "Male":
                        males.add(person);
                 */
                case "Male"  : males.add(person);
                    //consider adding a 'default' statement to handle unknown genders
            }
        }

        /*
            add a 'getTotalAge' to access the 'totalAge' to provide better encapsulation
         */
        System.out.println("Total age =" + totalAge);

        /*
            This print out will be incorrect due to females being removed in the code above.
            To count the number of females, create a 'females' List similar to 'males'
         */
        System.out.println("Total number of females =" + personsList.size());
        System.out.println("Total number of males =" + males.size());
    }

}

//Consider creating this as a public class separate from this class
class Person {

    private int age;
    //Note: this field is effectively redundant as per its current usage. It is assigned a value in the constructor, and inaccessible thereafter
    private String firstName;
    private String lastName;
    //make 'gender' private scope and add an accessor (getGender())
    String gender;

    /*
        Comment 1: Extend the constructor signature to include 'gender'
        Comment 2: Access can be changed to 'package-private' if public scope is not required for this use case
     */
    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Access can be changed to 'package-private' if public scope is not required for this use case
    public int getAge() {
        return age;
    }

    @Override
    /*
        There are multiple problems with this equals implementation. I have written a better version immediately below (commented out)
        Problem 1: If 'Person' represents a human, the 'equals' should be extended to include 'age', 'lastName' & 'gender'
        Problem 2: change '==' to use 'equals' to compare the String values correctly
        Problem 3: add null check for the 'obj' argument to avoidf NullPointerException
        Problem 4: add check for the class of the object parameter
     */
    public boolean equals(Object obj) {
        return this.lastName == ((Person)obj).lastName;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(gender, person.gender);
    }
     */

    /*
        You must override hashCode() in every class that overrides equals(). Failure to do so will result in a violation of the general contract for Object.hashCode(),
        which will prevent your class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable.
     */
    /*
        @Override
        public int hashCode() {
            return Objects.hash(age, firstName, lastName, gender);
        }
    */

    /*
        Observation 1:  Consider creating this as a public interface separate from this class
        Observation 2:  Type parameter <E> is never used. Change 'E' to Person. Or change 'Person' in interface to 'E' depending on expected  use case
     */
}
interface PersonDatabase<E> {

    Person[] getAllPersons() throws IOException;

}
