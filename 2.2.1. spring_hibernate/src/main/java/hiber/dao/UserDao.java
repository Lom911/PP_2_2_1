package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();


//    User CarInfo(int series);

    User CarInfo(int series, String model);
}

