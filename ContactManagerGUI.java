package contactmanager;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class Contacts {
    protected int contactID;
    protected String name;
    protected String phoneNumber;
    protected String type; // Personal, Business, Emergency

    public Contacts(int contactID, String name, String phoneNumber, String type) {
        this.contactID = contactID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return name + " (" + type + ") - " + phoneNumber;
    }
}

public class ContactManagerGUI extends JFrame {
    private java.util.List<Contacts> contactsList = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> contactJList;

    public ContactManagerGUI() {
        setTitle("Contact Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set a modern background color
        getContentPane().setBackground(new Color(245, 245, 245));

        add(createContactsPanel());
    }

    private JPanel createContactsPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(245, 245, 245));

        JLabel header = new JLabel("📇 My Contacts");
        header.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.setForeground(new Color(33, 33, 33));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(header, BorderLayout.NORTH);

        contactJList = new JList<>(listModel);
        contactJList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        contactJList.setSelectionBackground(new Color(173, 216, 230));
        contactJList.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(contactJList);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        final JPanel buttons = getjPanel();
        mainPanel.add(buttons, BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel getjPanel() {
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(245, 245, 245));
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton addBtn = new JButton("➕ Add Contact");
        JButton removeBtn = new JButton("❌ Remove Contact");

        addBtn.setBackground(new Color(76, 175, 80));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);

        removeBtn.setBackground(new Color(244, 67, 54));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);

        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        removeBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));

        addBtn.addActionListener(e -> addContact());
        removeBtn.addActionListener(e -> removeContact());

        buttons.add(addBtn);
        buttons.add(removeBtn);
        return buttons;
    }

    private void addContact() {
        String name = JOptionPane.showInputDialog("Enter Name:");
        String phone = JOptionPane.showInputDialog("Enter Phone Number:");
        String[] types = {"Personal", "Business", "Emergency"};
        String type = (String) JOptionPane.showInputDialog(null, "Select Type:", "Contact Type",
                JOptionPane.QUESTION_MESSAGE, null, types, types[0]);

        if (name != null && phone != null && type != null && !name.isEmpty() && !phone.isEmpty()) {
            Contacts newContact = new Contacts(contactsList.size() + 1, name, phone, type);
            contactsList.add(newContact);
            listModel.addElement(newContact.toString());
        }
    }

    private void removeContact() {
        int index = contactJList.getSelectedIndex();
        if (index != -1) {
            contactsList.remove(index);
            listModel.remove(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContactManagerGUI().setVisible(true));
    }
}

