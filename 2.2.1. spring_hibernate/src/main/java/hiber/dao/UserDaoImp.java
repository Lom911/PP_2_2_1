package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

//   @Override
//   public void add(Car car) {
//      sessionFactory.getCurrentSession().save(car);
//   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
@Override
   public User CarInfo(int series, String model){
      TypedQuery <User> typedQuery = sessionFactory.getCurrentSession()
              .createQuery("FROM User users WHERE users.car.series =: series and users.car.model =: model");
              typedQuery.setParameter("series", series);
              typedQuery.setParameter("model", model);
            return typedQuery.getSingleResult();
   }


}
