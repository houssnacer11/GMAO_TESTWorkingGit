package xtensus.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import xtensus.entity.Entite;
import xtensus.qualifiers.Dao;

@Dao(type = Entite.class)
public class AbstractGenericDao implements IGenericDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessiionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessiionFactory
	 *            the sessiionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Entite entity) throws HibernateException {

		getSession().persist(entity);
	}

	@Override
	public void update(Entite entity) throws HibernateException {
		getSession().merge(entity);

	}

	@Override
	public void delete(Entite entity) throws HibernateException {
		getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entite> List<T> getList(Class<T> clazz)
			throws HibernateException {
		Criteria criteria = getSession().createCriteria(clazz);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entite> List<T> getListUnique(Class<T> clazz)
			throws HibernateException {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	/*
	 * @Override public Utilisateurs findById(int id) throws HibernateException
	 * { return (Utilisateurs) (getSession().load(Utilisateurs.class, id)); }
	 */

	/********************** Requettes *************************/
	
	
	/************ propre khaled saoudi ****************/
	@Override
	public List<? extends Entite> FindByCriteria(Class classe, Criterion critere) {
		
		Session session = getSessionFactory().openSession();
		List<? extends Entite> lst = session.createCriteria(classe).add(critere).list();
		session.close();
		return lst;
	}
	/************ propre khaled saoudi ****************/
	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entite> getListWithNamedQuery(String namedQueryName)
			throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		return query.list();
	}

	//
	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entite> getListWithNamedQuery(String namedQueryName,
			Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		return query.list();
	}

	@Override
	public void deleteWithNamedQuery(final String namedQueryName,
			Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		query.executeUpdate();
	}

	@Override
	public void deleteWithNamedQuery(final String namedQueryName)
			throws HibernateException {
		Query query = getSession().createQuery(namedQueryName);
		query.executeUpdate();
	}

	@Override
	public void updateWithNamedQuery(final String namedQueryName,
			Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		query.executeUpdate();
	}

	@Override
	public void updateWithNamedQuery(final String namedQueryName)
			throws HibernateException {
		Query query = getSession().createQuery(namedQueryName);
		query.executeUpdate();
	}

	@Override
	public long countListEtat() {
		long res = 0;
		String hql = "SELECT count(vt) FROM Visitetechnique vt";
		Query query = getSession().createQuery(hql);
		List results = query.list();
		res = (Long) results.get(0);
		return res;
	}

	@Override
	public long countList(String namedQueryName,
			Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		return (Long) query.list().get(0);

	}
	
	
}
