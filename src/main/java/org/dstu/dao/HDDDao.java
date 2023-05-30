package org.dstu.dao;

import org.dstu.domain.HDD;
import org.hibernate.query.Query;

import java.util.List;

public class HDDDao extends BaseDaoImpl<HDD, Integer> {
    public HDDDao() {
        super(HDD.class);
    }

    public List<HDD> getAllByInterface(String interf) {
        Query q = getSession().createQuery("FROM HDD WHERE HDD.interf = \"" + interf + "\"");
        return q.list();
    }
}
