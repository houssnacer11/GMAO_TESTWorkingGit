/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtensus.services;

import static xtensus.dao.utils.QueryParameterBuilder.with;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtensus.dao.IGenericDao;
import xtensus.entity.Entite;
import xtensus.qualifiers.Dao;

/**
 *
 * 
 */
@Service
public class ApplicationManager extends AbstractGenericManager {
	/**
	 * @param daoe
	 *            the dao to set
	 */
	
	@Override
	public List<? extends Entite> FindByCriteria(Class classe, Criterion critere)throws Exception {
			
		return dao.FindByCriteria(classe, critere);
		
	}
	
	
	@Override
	@Autowired
	public void setDao(@Dao(type = Entite.class) IGenericDao dao) {
		this.dao = dao;
		System.out
				.println("****************Chargement Service*******************");
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

	@Override
	public <T extends Entite> List<T> getList(Class<T> t) throws Exception {
		return dao.getList(t);
	}

	@Override
	public <T extends Entite> List<T> getListUnique(Class<T> t)
			throws Exception {
		return dao.getListUnique(t);
	}

	
	public long nb() {
		return dao.countListEtat();
	}

	
	
}
