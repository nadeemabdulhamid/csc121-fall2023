---
marp: true
theme: gaia
class: invert
paginate: false


---
# Lecture 0 - Welcome (back)!
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2023

<!-- paginate: skip -->
<!-- _class: lead -->


---
## Today
- Course syllabus
- Review
    - Designing programs, data definitions
- Tools
    - Download and install Eclipse IDE and Java JDK
    - Create and run an Eclipse project


<!-- paginate: true -->
<!-- footer: Lecture 0 - Welcome -->


---
## Course Overview

- Canvas site: http://cs.berry.edu/csc121
- Syllabus

- Contents
    - Introduction to object-oriented programming ...
    - ... with a strong software engineering foundation ...
    - ... aimed at producing and maintaining large, high-quality software systems.


---
## Goals

- Understand how to design programs using the object-oriented paradigm
- Demonstrate the ability to implement these designs
- Produce well-documented implementations
- Gain exposure to state-of-the-art development tools
- Use critical thinking skills and creativity to solve problems


--- 
## Components

- 10% Class attendance/participation
- 40% Programming assignments (daily)
- 10% Semester project (group)
- 10% Quizzes (~ bi-weekly)
- 10% Exams (midterm + final)


---
## Course Policies

- Pair Programming 
    - allowed for programming assignments; must work together, at the same time & place
- Computers
- Academic Integrity
- Late Work
    - ***Don’t Leave Work To The Last Minute***
- Accommodations


---
## Course Project

- Work in groups of 2 or 3
- Program a graphical simulation or computer game of your choice and design
- More details later ...


---
## Course Software

### Eclipse IDE
[Download](http://eclipse.org/downloads/) and install Eclipse IDE *and* OpenJDK

Videos
- [Installing Eclipse IDE](https://youtu.be/A3wRGdhu55Y) (4:18)
- [Eclipse - first steps](https://youtu.be/nlxNO7Ntj_w) (5:37)


---
## Reminder
- This class is not (just) about Java. It’s about how to design programs.
    -- Java is our tool as we study the principles of computation from an object-oriented perspective
    -- We will cover a subset of features of Java
    -- The concepts we do cover are applicable to many object-oriented languages
    -- The curriculum and topics in this course follow the state of the art in the real world, w.r.t. software design and development


---
## The Design Recipe

- Problem Analysis & Data Definition (& Examples)
- Signature, Purpose/Effect Statements, Function Header
- Function Examples
- Function Template
- Function Definition (Body)
- Test!


---
## The Design Recipe
<style scoped>li li  { font-size: 80%; }</style>

1. Problem Analysis & Data Definition/Examples
    - What kinds of data are involved? Create data definitions. Construct examples according to the data definitions, just to make sure they work.

2. Signature, Purpose/Effect Statements, Function Header
    - What kinds of data does the function consume? Which kind does it produce? And what is its purpose? (in one line)

3. Function Examples
    - Can you make up examples of inputs? What should the function produce for these inputs?

---
## The Design Recipe
<style scoped>li li  { font-size: 80%; }</style>

4. Function Template
    - Does the data definition (of the main argument) mention clauses? If so, use a *cond* with as many cases as there are clauses in the data definition.
    - How can you distinguish these kinds of data with conditions involving the main parameter?
    - Are structs involved? If so, write down all the selector expressions. (Do so on a per-clause basis.)
    - Does the data definition involve any self-references (or cross-references)? If so, use recursion in the template to express these "arrows”.

---
## The Design Recipe
<style scoped>li li  { font-size: 70%; }</style>

5. Function Definition (Let’s code!)
    - Can you deal with the simple *cond* cases? Your examples should cover those cases directly.
    - What do the expressions in the recursive cases compute? Use the purpose statement of the function to figure out what the recursive function application computes.
    - How can you combine the results of these expressions so that the function returns the desired value? Use the examples to tabulate the values of the intermediate expressions and the desired output for the given input. This will usually suggest an expression for combining the intermediate results, though admittedly this is the one and only "deep" step of design and you won't get away without some real thinking here.

6. Tests 
    - Turn the examples into tests.


---
## Data Definitions
<style scoped>li { font-size: 80%; }</style>

> Computers do not work with information: they work with data, which is a representation of the information relevant for the computation.

- With any computation/process, you must first understand the information that is provided, and then how it is represented as data that a program manipulates
- We’ll review what we already know about data definitions in Racket and then look at how we represent the same information as data in a different language (Java)
    - However the data is represented, it is important to understand that the information is the same
    - The structure of the data representation is essentially identical in two different programming languages


---
## For later reference

- Defining compound data; functions on compound data: [bookstore1.rkt](code/bookstore1.rkt)
- Defining compound data that contains compound data; wish lists: [bookstore2.rkt](code/bookstore2.rkt)
- Defining lists of data; functions on lists of data: [bookstore3.rkt](code/bookstore3.rkt)
- Racket loops: [bookstore4.rkt](code/bookstore4.rkt)
