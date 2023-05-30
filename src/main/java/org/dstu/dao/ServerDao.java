package org.dstu.dao;

import org.dstu.domain.Server;

public class ServerDao extends BaseDaoImpl<Server, Integer> {
    public ServerDao() {
        super(Server.class);
    }
}
