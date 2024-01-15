import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobPortalApp9 extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JButton applyButton;

    public JobPortalApp9() {
        // Set JFrame properties
        setTitle("Job Portal Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);

        applyButton = new JButton("Apply Now");

        // Add action listener to the "Apply Now" button
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the button is clicked
                String name = nameField.getText();
                String email = emailField.getText();

                // In a real application, you might perform actions like storing the application details in a database.
                // For simplicity, we'll just display a message here.
                JOptionPane.showMessageDialog(JobPortalApp9.this,
                        "Application submitted!\nName: " + name + "\nEmail: " + email,
                        "Application Status", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Create layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(emailLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameField)
                        .addComponent(emailField)
                        .addComponent(applyButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(emailField))
                .addComponent(applyButton)
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JobPortalApp9().setVisible(true);
            }
        });
    }
}
