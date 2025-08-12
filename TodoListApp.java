package com.Task5;
import javax.swing.*;
import java.awt.*;

public class TodoListApp extends JFrame {
	
    private static final long serialVersionUID = 1L;
    
	private DefaultListModel<String> taskListModel;
	
    private JList<String> taskList;
    
    private JTextField taskInputField;

    public TodoListApp() {
    	
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // List model & JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input field
        taskInputField = new JTextField();
        taskInputField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Buttons
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        // Panel for input & add
        JPanel inputPanel = new JPanel(new BorderLayout());
        
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Add action listeners
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        // Layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);
    }

    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task!");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TodoListApp().setVisible(true);
        });
    }
}
