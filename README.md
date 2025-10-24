Create New Notes
Prompts the user to enter a title.
Checks if the title is non-empty and not already used.
Accepts note content and stores it in a Notes_Management object.
Adds the object to an ArrayList<Object> called notes.

2️ Add to Existing Notes
Asks for a title.
Searches for a matching note.
If found, appends new content to the existing note using:
java
existing.setContent(existing.getContent() + " " + content);

3️ Delete Notes
Prompts for a title.
Searches and removes the matching note from the list.

4️  Display Notes
Offers two options:
Display a specific note by title.
Display all notes with titles and formatted content.
Splits content into words and prints 20 words per line for readability.

 Loop Control
After each operation, asks:
Code
If you want to continue Press "YES" Otherwise Press "NO"
Ends the program if the user enters anything other than "YES".

 Classes Used
Notes_Management
Fields: title, content
Methods: getTitle(), setTitle(), getContent(), setContent()
 Learning Outcomes
Object-oriented design with custom classes
ArrayList usage for dynamic storage
Input validation and string handling

Exception-free control flow

Console-based user interaction
