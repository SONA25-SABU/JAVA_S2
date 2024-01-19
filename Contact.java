import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Contact extends JFrame {

    private JTextField idField, nameField, emailField, phoneField;
    private JButton addButton, displayButton, updateButton, deleteButton,searchButton;

    private Connection connection;
    private Statement statement;

    public Contact() {
        initializeUI();
        initializeDatabase();
    }

    private void initializeUI() {

        idField = new JTextField(5);
        nameField = new JTextField(20);
        emailField = new JTextField(3);
        phoneField = new JTextField(3);

        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        searchButton=new JButton("Search");

        setLayout(new FlowLayout());

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Phone:"));
        add(phoneField);

        add(addButton);
        add(displayButton);
        add(updateButton);
        add(deleteButton);
        add(searchButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayContact();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

       
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });







        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    private void initializeDatabase() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/exam";
            String user = "root";
            String password = "MySQL@sona1";
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS contacts (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "email VARCHAR(50)," +
                    "phone INT)");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addContact() {
        try {
            String name = nameField.getText();
            String email = emailField.getText();
            int phone = Integer.parseInt(phoneField.getText());

            String query = "INSERT INTO contacts (name, email, phone) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, phone);

                preparedStatement.executeUpdate();
            }

            clearFields();
            JOptionPane.showMessageDialog(this, "Contact added successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding contact.");
        }
    }

    private void displayContact() {
        try {
            String query = "SELECT * FROM contacts";
            ResultSet resultSet = statement.executeQuery(query);

            JTable table = new JTable(buildTableModel(resultSet));

            JScrollPane scrollPane = new JScrollPane(table);

            JFrame displayFrame = new JFrame("Contacts Database");
            displayFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            displayFrame.setSize(600, 400);
            displayFrame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying contacts.");
        }
    }

    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(resultSet.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    private void updateContact() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            int phone = Integer.parseInt(phoneField.getText());

            String query = "UPDATE contacts SET name=?, email=?, phone=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, phone);
                preparedStatement.setInt(4, id);

                preparedStatement.executeUpdate();
            }

            clearFields();
            JOptionPane.showMessageDialog(this, "contact updated successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating contact.");
        }
    }

    private void deleteContact() {
        try {
            int id = Integer.parseInt(idField.getText());

            String query = "DELETE FROM contacts WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }

            clearFields();
            JOptionPane.showMessageDialog(this, "contact deleted successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting contact.");
        }
    }

    private void searchContact() {
        try {
            int id = Integer.parseInt(idField.getText());
    
            String query = "SELECT * FROM contacts WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
    
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    int phone = resultSet.getInt("phone");
    
                    JOptionPane.showMessageDialog(this,
                            "Contact found:\n" +
                            "ID: " + id + "\n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phone,
                            "Contact Details",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No contact found with ID: " + id, "Search Result", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching contact.");
        }
    }


    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Contact());
    }
}
