package mybatis;

/**
 * @author wangpp
 */
public interface UserMapper {
    void insertUser(User user);

    User getUser(Integer id);
}
