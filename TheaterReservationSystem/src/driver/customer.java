package driver;

import java.util.ArrayList;
import java.util.List;

public class customer {


    String userId;
    String password;

    //reservations


    public customer(String id, String password) {

        this.userId = id;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
