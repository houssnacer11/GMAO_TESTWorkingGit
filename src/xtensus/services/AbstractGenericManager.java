package xtensus.services;

import xtensus.dao.IGenericDao;
import xtensus.entity.Entite;



public abstract class AbstractGenericManager implements IGenericManager {

    protected IGenericDao dao;

    /**
     * @return the dao
     */
    public IGenericDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(IGenericDao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Entite entity) throws Exception {
        dao.insert(entity);
    }

    @Override
    public void update(Entite entity) throws Exception {
        dao.update(entity);
    }
    
    @Override
    public void delete(Entite entity) throws Exception {
        dao.delete(entity);
    }

}
