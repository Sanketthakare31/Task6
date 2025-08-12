# Task6
**To-Do list Using java Swing.**
Class Setup

TodoListApp extends JFrame, making it the main window of the app.

It declares:

A DefaultListModel<String> (taskListModel) to manage the list of tasks.

A JList<String> (taskList) to display these tasks.

A JTextField (taskInputField) for user input.

Constructor: GUI Initialization

Sets up basic window properties: title, size, close behavior, and centralizes the window on screen.

Instantiates the DefaultListModel and associates it with the JList. The JList is then wrapped in a JScrollPane for scrollability.
Oracle Documentation
CodeJava

Configures the input field, styling it with a specific font.

Creates “Add Task” and “Delete Task” buttons.

Organizes components using BorderLayout:

Input field and Add button at the top (NORTH).

Task list in the center (CENTER).

Delete button at the bottom (SOUTH).

Adds action listeners to the buttons, linking them to the addTask() and deleteTask() methods.

Adding Tasks (addTask() method)

Reads trimmed text from the input field.

If non-empty → adds it to the task list model (taskListModel.addElement(task)) and clears the field.

If empty → shows an alert dialog prompting the user to enter something.

DefaultListModel supports adding elements dynamically and handles change notifications internally.
Oracle Documentation
Stack Overflow

Deleting Tasks (deleteTask() method)

Obtains the selected index from the JList.

If a selection exists → removes that item from the model.

Otherwise → shows a dialog prompting the user to select a task.

Launching the App (main() method)

Uses SwingUtilities.invokeLater(...) to safely start the UI on the Event Dispatch Thread (EDT), which is best practice in Swing.

