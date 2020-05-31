package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.models.User;
import pl.edu.agh.soa.jpa.UserEntity;

public class UserMapper {
    public static UserEntity mapUserToEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }

    public static User mapEntityToUser(UserEntity userEntity){
        User user = new User();
        user.setLogin(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
