package com.maverick;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    public MainFrame() {

        JLabel urlLabel = new JLabel("URL:");
        JTextField urlTextField = new JTextField();

        JPanel panel = new JPanel(new GridBagLayout());
        JButton downloadButton = new JButton("Download");
        urlTextField.setPreferredSize(new Dimension(200, 25));

        setTitle("Cover Downloader");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(false);

        panel.add(urlLabel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));

        panel.add(urlTextField, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));

        add(panel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));

        add(downloadButton, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        downloadButton.addActionListener(e -> {
            try {
                Downloader.saveImage(urlTextField.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getClass() + System.lineSeparator() + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Downloading Successful", "Done)", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}