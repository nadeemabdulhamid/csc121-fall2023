# Homework 10 - Mutation

Create an Eclipse project named `hw10-mutation`.

## Contacts List


Start with this class definition:

```
/** represents an entry in a phone contacts list */
class Person {
    String name;
    int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /** produces a person with updated number */
    public Person updateNumber(int newNumber) {
        return new Person(this.name, newNumber);
    }
}
```

- Use Eclipse to generate an `equals()` method so that this test passes:

    ```
    Person brook = new Person("Brook", 1234);
    Person sarah = new Person("Sarah", 5678);

    @Test
    public void testUpdatePerson() {
        assertEquals(new Person("Brook", 3333),   // updated "Brook" object
                     this.brook.updateNumber(3333));

        // note that the updateNumber method did NOT affect the original "Brook".
        assertEquals(false,     // original `brook` still has number 1234
                    this.brook.equals(new Person("Brook", 3333)));
    }
    ```


- Now, add a method to the class with this signature: `void changeNumber(int newNumber)` that *changes* the phone number for the person. Note it should `return;` nothing. Make sure this test passes.

    ```
    @Test
    public void testChangePerson() {
      assertEquals(brook, new Person("Brook", 1234));
      brook.changeNumber(3333);
      assertEquals(brook, new Person("Brook", 3333));
    }
    ```


- Add this file to your Eclipse project: [ILoP.java](./ILoP.java).
- Design these methods for the ILoP union of classes:
    ```
    /** determines if given person is in this list */
    public boolean contains(Person p);

    /** produces a list with the phone number of the given
        person in this list *changed* to the given number */
    public void changeNumber(String name, int newNumber);
    ```

- Make sure you develop good test cases.





---


## Creative Project - Milestone 2

(Due Tuesday, Oct 3)

Develop a basic running version of your game/application. You should now be able to support multiple objects in your game as appropriate (list-of-things). Address any issues I highlighted in review of your first milestone, and work on any suggested features that I listed/talked about.

After you have worked on this a bit, I highly recommend you stop by my office hours sometime this week to go over your work and get some tips. I am very open to helping you figure out how to implement your ideas. My Wednesday office hours are best, as I am available pretty much anytime from after class till 5pm - just let me know when you want to stop by.

Your updated code should be pushed to the Github repository by the due date.
