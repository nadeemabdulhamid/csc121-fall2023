# Homework 8 - Methods for Self-referential Data

Create an Eclipse project named `hw08-self-ref-methods`.

## Project Milestone

Complete Part 2 of [Creative Project - Milestone 1](https://berry.instructure.com/courses/10589/assignments/169154) for Monday.


## Part 1: Methods for Books - due Monday

Start with the code files here representing a list of books in a bookstore:

- [Book, BookTest, and ILoB](./code/)

Add equals/hashCode methods to the `ILoB` hierarchy of classes. Make sure you add them to the `Book` and `Author` classes as well. 

Add the following methods to the `ILoB` hierarchy of classes. There are some test cases already in the BookTest class -- uncomment them as you go.

```
  // computes the total sale price of all books in *this* list
  public int totalPrice();
  
  // sort *this* list of books by sale price
  public ILoB sortByPrice();
  
  // insert a book into this list, sorted by sale price
  public ILoB insertByPrice(Book b);
  
  // select from this list those books written by the given author
  public ILoB selectByAuthor(Author a);
  
  // produce the book with cheapest sale price in this list
  public Book cheapestBook();
  /* in the MTLoB case, raise an error using this statement 
     instead of a return:
         throw new RuntimeException("The list is empty!");
  */
  
  // produce the book with cheapest sale price in this list; given the
  // cheapest book seen so far in the list (accumulator-style method)
  public Book cheapestBookAcc(Book cheapest);
```



## Part 2: Methods for Mobiles - due Wednesday

Download the files for mobiles and add them to your project.



