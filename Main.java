package com.company;

import java.util.Scanner;

class Library {
    Library() {
        bookStore[0] = "Harry potter";
        bookStore[1] = "Batman";
        bookStore[2] = "java Advanced";
        bookStore[3] = "C++ Guide";
        bookStore[4] = "Android Development";
    }

    Scanner sc = new Scanner(System.in);
    String[] bookStore = new String[20]; // TO store books
    String[] issuedBooks = new String[20]; // To store books that have been issued

    public void addBook() {
        int c = 0;
        String x; // to take book name as input from user
        System.out.print("Enter Book Name: ");
        x = sc.nextLine();
        for (String i : bookStore) {
            if (i == null) { // if 'i' is null we go in, null means that block is empty
                bookStore[c] = x; // we assign that block as x, but we dont havev access to 'i' in enhanced loop,
                // so
                // we have created a variable c, which will move with same as i
                break; // after adding we will terminate it
            }
            c++; // to maintain c with i
        }
        System.out.println("Successfully added");
    }

    public void showAvailableBooks() {
        int c = 0;
        System.out.println("Books to choose from: ");
        for (String i : bookStore) {
            if (i != null) { // if i is not null means there is, some string so we go in
                c++; // c is working here as a counter
                System.out.println(". " + i); // we will print i as we go on
            }
        }
        if (c == 0) { // now if the counter c is zero, that means there were all the spaces null so we
            // never made
            // in, then we will print no books available as all values null
            System.out.println("No available books!!");
        }
    }

    public void issueBook() {
        int c = 0;
        int c2 = -1;
        String x; // user input
        System.out.print("Which book you want Name: ");
        x = sc.nextLine();
        for (String i : bookStore) { // first we enter bookstore array to look for that book
            if (i != null) { // if spaces not null we go in
                if (i.compareToIgnoreCase(x) == 0) { // we compare every space string with user input, if matches
                    // we go in
                    for (String j : issuedBooks) { // entering issued books array
                        c2++; // c2 will be working parallel with j, because j cannot be accessed
                        if (j == null) { // if j null, that means there is space for insertion
                            issuedBooks[c2] = bookStore[c]; // we will copy value from bookstore into this, if the
                            // first block was empty then c2 was pointing at 0 and c also 0
                            break;
                        }
                    }
                    bookStore[c] = null; // now once we have copied that value we have delete it from the main store
                    System.out.println("The book " + x + " is now issued to you");
                    break;
                }
            }
            c++; // ready to point to next block
        }
        if (c2 == -1) { // if c2 was never incremented, then value user entered was incorrect
            System.out.println("Book not found");
        }
    }

    public void returnBook() { // reverse engineering of issueBook() method
        int c = 0;
        int d = -1;
        int k = 0; // to print issued books // not special use
        String x;
        for (String i : issuedBooks) {
            if (i != null) { // we gon in if value is there
                System.out.println("Books to be returned: " + issuedBooks[k]);
            }
            k++; // k variable work is done
            if (i != null) {
                System.out.print("Which book you want to return: ");
                x = sc.nextLine();
                for (String j : bookStore) {
                    d++;
                    if (j == null) { // if value empty to insert back, then we go in
                        if (i.compareToIgnoreCase(x) == 0) {
                            bookStore[d] = issuedBooks[c];
                            break;
                        }
                    }

                }

                issuedBooks[c] = null;
                System.out.println("book " + x + " added in bookstore");
                break; // we breeak and do c++
            }
            c++;
        }
        if (d == -1) {
            System.out.println("No books issued yet");
        }
    }

    public void booksGiven() {
        for (String i : issuedBooks) {
            if (i != null) {
                System.out.println("Books to be returned: " + i);
            }
        }
    }
}

public class _51_CreatingLibrary {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        // You have to implement a library using Java Class "Library"
        // Methods: addBook, issueBook, returnBook, showAvailableBooks
        // Properties: Array to store the available books,
        // Array to store the issued books
        Library Guest1 = new Library();
        System.out.println("""
            Enter the number of your choice:
            0-To exit.
            1-To display available books.
            2-To Issue a book.
            3-To return back an issued book.
            4-To add a book.
            5-To display issued books.
            """);
        int x = -1; // if we dont initialize by defautlt the loop wont work
        while (x != 0) {
            x = sc1.nextInt();
            System.out.println();

            switch (x) {
                case 0 -> System.out.println("Exiting Finish");
                case 1 -> Guest1.showAvailableBooks();
                case 2 -> Guest1.issueBook();
                case 3 -> Guest1.returnBook();
                case 4 -> Guest1.addBook();
                case 5 -> Guest1.booksGiven();
                default -> System.out.println("Invalid choice");
            }
            if (x != 0) {
                System.out.print("Enter you choice again: ");
            }

        }

    }
}
