package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Suzuki", 45678)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 68478)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("volgaBUS", 25467)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("KIA", 78943)));

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//        userService.add(new Car("Suzuki", 45678).setUser("ehdjf", ));
//        userService.add(new Car("BMW", 68478).getUser());
//        userService.add(new Car("volgaBUS", 25467).getUser());
//        userService.add(new Car("KIA", 78943).getUser());


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
            System.out.println();

        }

        int CarId = 68478;
        String model = "BMW";
        System.out.println("User = " + userService.CarInfo(CarId, model).getFirstName());


        context.close();
    }
}
// https://www.youtube.com/watch?v=IJMgD1MNdNM
//http://hibernate-refdoc.3141.ru/ch16.HQL
//   https://java-online.ru/hibernate-hql.xhtml
//https://www.baeldung.com/jpa-queries
//        http://java-online.ru/hibernate-hql.xhtml