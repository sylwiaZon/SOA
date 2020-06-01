package pl.edu.agh.soa.dao;
import pl.edu.agh.soa.jpa.UserEntity;
import pl.edu.agh.soa.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addUser(User user){
        entityManager.persist(UserMapper.mapUserToEntity(user));
    }
    public User getUser(User user){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = criteriaQuery.from(UserEntity.class);
        criteriaQuery.select(userEntityRoot).where(criteriaBuilder.and(criteriaBuilder.equal(userEntityRoot.get("login"), user.getLogin()), criteriaBuilder.equal(userEntityRoot.get("password"), user.getPassword())));
        return UserMapper.mapEntityToUser(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
}
