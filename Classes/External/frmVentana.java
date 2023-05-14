package Classes.External;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmVentana {
    private JFrame frame;
    private JTextField inputField;
    private JButton submitButton;
    private JTextArea outputArea;

    public frmVentana() {
        // Create the main frame
        frame = new JFrame("Neural Network Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create the input field
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(300, 100));

        // Create the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                processInput(input);
            }
        });

        // Create the output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setPreferredSize(new Dimension(300, 100));

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a sub-panel for input and submit button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(outputArea, BorderLayout.CENTER);

        // Create a scroll pane for the output area
        JScrollPane scrollPane = new JScrollPane(panel);

        // Add the scroll pane to the frame
        frame.getContentPane().add(scrollPane);

        // Display the frame
        frame.setVisible(true);
    }

    private void processInput(String input) {
        // Perform any processing or interaction with the neural network here
        // You can update the outputArea with the results
        outputArea.setText("Input: " + input);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frmVentana();
            }
        });
    }
}