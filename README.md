# Phonebook

A web application consisting of a web interface (html + javascript) and a back end (java).

The application provides the following functionality: 
creating, editing, deleting and viewing entries in the phone book. 
The user interface is a table with phone book entries, 1 entry is displayed in each row of the table.
The entry consists of the subscriber's name, telephone number and the date of making (changing) the entry in the phone book.

When you click on a record, a form for editing the record opens with the ability to save / cancel changes. 
The phone book entry is stored in a relational database (MySQL). 
Information between the client and server parts of the application is transmitted through ajax requests. 
Updating information in the table is implemented without refreshing the page. 
The entire client interface is implemented on the principle of "single-page application".
