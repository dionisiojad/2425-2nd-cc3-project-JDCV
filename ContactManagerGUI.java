package contactmanager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



    class Contacts {
        protected int contactID;
        protected String name;
        protected String phoneNumber;
        protected String email;
        protected String address;
        protected String notes;

        public Contacts(int contactID, String name, String phoneNumber, String email, String address, String notes) {
            this.contactID = contactID;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
            this.notes = notes;
        }

        public String toString() {
            return name + " - " + phoneNumber;
        }
    }

    class ContactManagerGUI extends JFrame {
        private List<Contacts> contactsList = new ArrayList<>();
        private DefaultListModel<String> listModel = new DefaultListModel<>();
        private JList<String> contactJList;

        public ContactManagerGUI() {
            setTitle("Contact Manager");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            contactJList = new JList<>(listModel);
            add(new JScrollPane(contactJList), BorderLayout.CENTER);

            JPanel panel = new JPanel();
            JButton addButton = new JButton("Add Contact");
            JButton removeButton = new JButton("Remove Contact");

            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addContact();
                }
            });

            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    removeContact();
                }
            });

            panel.add(addButton);
            panel.add(removeButton);
            add(panel, BorderLayout.SOUTH);
        }

        private void addContact() {
            String name = JOptionPane.showInputDialog("Enter Name:");
            String phone = JOptionPane.showInputDialog("Enter Phone Number:");
            if (name != null && phone != null && !name.isEmpty() && !phone.isEmpty()) {
                Contacts newContact = new Contacts(contactsList.size() + 1, name, phone, "", "", "");
                contactsList.add(newContact);
                listModel.addElement(newContact.toString());
            }
        }

        private void removeContact() {
            int selectedIndex = contactJList.getSelectedIndex();
            if (selectedIndex != -1) {
                contactsList.remove(selectedIndex);
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contact to remove.");
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new ContactManagerGUI().setVisible(true);
            });
        }
    }


