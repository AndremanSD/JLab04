import org.dstu.dao.HDDDao;
import org.dstu.dao.SSDDao;
import org.dstu.dao.ServerDao;
import org.dstu.domain.HDD;
import org.dstu.domain.SSD;
import org.dstu.domain.Server;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        HDDDao hddDao = new HDDDao();

        HDD hdd = new HDD();
        hdd.setName("Western Digital");
        hdd.setCapacity(500);
        hdd.setSize("2.5''");
        hdd.setRpm(5400);
        hdd.setInterface("SATA");
        hddDao.save(hdd);

        ServerDao serverDao = new ServerDao();

        Server ist = new Server();
        ist.setName("HP Proliant");
        ist.setRunning(true);
        int savedId = serverDao.save(ist);
        System.out.println(savedId);

        SSDDao ssdDao = new SSDDao();
        SSD ssd1 = new SSD();
        ssd1.setName("AMD");
        ssd1.setCapacity(240);
        ssd1.setSize("2.5''");
        ssd1.setReadSpeed(32768);
        ssd1.setWriteSpeed(32768);
        ssd1.setServer(ist);

        ssdDao.save(ssd1);

        SSD ssd2 = new SSD();
        ssd2.setName("Samsung");
        ssd2.setCapacity(512);
        ssd2.setSize("M2");
        ssd2.setReadSpeed(32768);
        ssd2.setWriteSpeed(32768);
        ssd2.setServer(ist);
        ssdDao.save(ssd2);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}