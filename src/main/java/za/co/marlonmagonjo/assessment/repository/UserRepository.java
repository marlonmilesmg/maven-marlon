package za.co.marlonmagonjo.assessment.repository;

import org.springframework.stereotype.Repository;
import za.co.marlonmagonjo.assessment.model.User;

import java.io.*;

@Repository
public class UserRepository {
    private static final String FILE_PATH = "user.txt";

    public void saveUser(User user) {
        if (user != null) {
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(user.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateUser(String userId, User user) {
        if (user != null) {
            if (user.getUserId().equals(userId)) {
                user.setFirstName(user.getFirstName());
                user.setLastName(user.getLastName());
                user.setContactNumber(user.getContactNumber());
            }
        }
        saveUser(user);
    }

    public User getUser(String userId) throws FileNotFoundException {
        User user = readUserFromFile();
        if (user.getUserId().equals(userId)){
            return user;
        }
        return user;
    }

    public void deleteUser(String userId) throws FileNotFoundException {
        User user = readUserFromFile();
        if (user.getUserId().equals(userId)) {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public User readUserFromFile() throws FileNotFoundException {
        User user = new User();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line = reader.readLine()) != null){
                String[] userData = line.split(",");
                String userId = userData[0];
                String firstName = userData[1];
                String lastName = userData[2];
                String contactNumber = userData[3];
                User userContent = new User(userId, firstName, lastName, contactNumber);
                user = userContent;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
