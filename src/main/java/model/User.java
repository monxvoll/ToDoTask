package model;

import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private List<Task> taskList;

    public User(String userName, String password, List<Task> taskList) {
        this.userName = userName;
        this.password = hashPassword(password);
        this.taskList = taskList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }


    public boolean validatePassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt()); //retorna la contraseña hasheada como string
    }
}
