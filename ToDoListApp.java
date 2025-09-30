package toDoListApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {
	private static final long serialVersionUID = 1L;

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton, deleteButton;

    public ToDoListApp() {
        // Frame setup
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center screen

        // Panel for input
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskInputField = new JTextField();
        addButton = new JButton("Add Task");
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Delete button
        deleteButton = new JButton("Delete Task");

        // Layout setup
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInputField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskInputField.setText("");
                } else {
                    JOptionPane.showMessageDialog(ToDoListApp.this,
                            "Please enter a task!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(ToDoListApp.this,
                            "Please select a task to delete!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoListApp().setVisible(true);
        });
    }
}
