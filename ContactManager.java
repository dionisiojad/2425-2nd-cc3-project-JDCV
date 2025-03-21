import java.util.*;
public class ContactManager {
    //Contact Manager
    private List<Contacts> contacts;

    public void addContact() {}
    public void deleteContact() {}
    public void updateContact() {}
    public void searchContact() {}
    public void listAllContacts() {}
    public void logActivity() {}

    // Base Contact class
    class Contacts {
        protected int contactID;
        protected String name;
        protected String phoneNumber;
        protected String email;
        protected String address;
        protected String notes;

        public void editContact() {}
        public void deleteContact() {}
        public void getDetails() {}
        public void isBlocked() {}
        public void addAdmin() {}
        public void removeAdmin() {}
    }

    // Specialized Contacts
    class PersonalContact extends Contacts {
        private String birthday;
        private String relationship;

        public void getBirthdayReminder() {}
    }

    class BusinessContact extends Contacts {
        private String companyName;
        private String jobTitle;

        public void scheduleMeeting() {}
    }

    class EmergencyContact extends Contacts {
        private int priorityLevel;
        private String relationToUser;

        public void getPriority() {}
    }
    
    // Group Class
    class Group {
        private int groupID;
        private String groupName;

        public void addContact() {}
        public void removeContact() {}
        public void listContacts() {}
    }

    // User Class
    class User {
        private int userID;
        private String username;
        private String email;
        private String password;

        public void login() {}
        public void register() {}
        public void managePassword() {}
        public void resetPassword() {}
        public void hashPassword() {}
    }

    // Database Class
    class Database {
        public void saveContact() {}
        public void getContact() {}
        public void deleteContact() {}
        public void updateContact() {}
        public void connectToDB() {}
    }

    // Authentication Class
    class Authentication {
        public void encryptPassword() {}
        public void verifyUser() {}
        public void generateOTP() {}
        public void validateToken() {}
    }

    // Notification Class
    class Notification {
        private String message;
        private Date timestamp;

        public void sendEmail() {}
        public void sendSMS() {}
        public void formatMessage() {}
    }

    // Login Class
    class LogIn {
        private String IDName;
        private String password;
        private String canNotLogin;

        public void getLogIn() {}
    }

}
