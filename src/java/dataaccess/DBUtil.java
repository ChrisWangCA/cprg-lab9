package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

/**
 * @author Chris Wang
 * @version 1.0
 * @date 2022-10-23
 */
public class DBUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");

    public static EntityManagerFactory getEmFactory(){
        return emf;
    }

}
