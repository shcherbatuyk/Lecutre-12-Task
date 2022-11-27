import java.util.ArrayList;

public class UsersList {
    ArrayList<User> users = new ArrayList<>();

    public String register(User newUser) throws UsernameIsNotFreeException {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(newUser.getUsername())) {
                throw new UsernameIsNotFreeException("There already is a user with this username");
            }
        }
        newUser.setId(users.size());
        users.add(newUser);
        return ("User registered successfully! Id: " + newUser.getId());
    }

    public String getById(int id) throws NoSuchIdException {
        if (id > users.size() - 1) {
            throw new NoSuchIdException("There's no user with id:" + id);
        }
        return users.get(id).toString();
    }

    public String authorisation(String username, String password) throws IncorrectPassOrUsernameException {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) && password.hashCode() == (users.get(i).getPassword())) {
                return "Auth succeed";
            }
        }
        throw new IncorrectPassOrUsernameException("Incorrect password or username");
    }

    public String getUsers() {
        if (users.size() == 0) {
            return "There are no registered users";
        }
        String result = "";
        for (int i = 0; i < users.size(); i++) {
            result += users.get(i).toString() + "\n";
        }
        return result;

    }
}
