models:
1-Patron:
long id
String name
String address
String contacts
borrowings Borrowing[]

2-Book
long id
String title
String auther
int pubYear
String isbn
boolean available   to tell if the book is available "not bowrrowed" or not
borrowings Borrowing[]

3-Borrowing
long id
String returnDate
String borroDate
Patron patron
Book book


this api contain the following end points:
1-BookController:
GET /api/books  retrive all books
GET api/books/{id} retrive a book by id   get method
POST api/books                    to post a new book
PUT api/books/{id}               put to edit a book 
DELETE api/books/{id}               delete a book with id
2-PatronController
GET /api/patrons  retrive all patrons
GET /api/patrons/{id} retrive a patron by id   get method
POST /api/patrons                      to post a new patron
PUT /api/patrons/{id}               put to edit a patron
DELETE api/books/{id}               delete a patron with id

3-BorrowingController
1-POST /api/borrow/{bookId}/patron/{patronId}:   record a borrow with borrowingDate of now and no return date ,so the user cannot borrow the same book again before return it
2-PUT /api/return/{bookId}/patron/{patronId}  enter the returnDate of the book by the user and update the book availabe to be true again so the user can borrow the book again
