package database;

import java.io.Serializable;

public class DBClass implements Serializable {

    public static void main(String args[]) {


        /*
        //Добавление юзера по transient объекту
        User user = new User();
        user.setDateCreate(System.currentTimeMillis());
        user.setEmail("redishko@gmail.com");
        user.setIsAdmin(true);
        user.setIsVerified(true);
        user.setUsername("redishko");
        user.setPassword("nikitahui");
        userDao.save(user);


        //Удаление юзеров по transient объекту
        User user1 = new User();
        user1.setUserId((long) 2);
        user1.setIsAdmin(true);
        userDao.delete(user1);

        //Выбор по ID
        User user2 = (User) userDao.select(User.class, (long) 3);
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());

        //Достаем пароль пользователя через имя
        User user3 = ObjectsDAO.getUserByName("redishko");
        System.out.println(user3.getPassword());
        */
        
        //ObjectsDAO.setUserVer();
    }
}