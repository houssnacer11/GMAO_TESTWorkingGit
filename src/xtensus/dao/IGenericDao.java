package xtensus.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xtensus.entity.Entite;


@Transactional(propagation = Propagation.REQUIRED)
public interface IGenericDao {

	public void insert(Entite entity) throws HibernateException;

	public void update(Entite entity) throws HibernateException;

	public void delete(Entite entity) throws HibernateException;

	public <T extends Entite> List<T> getList(final Class<T> t)
			throws HibernateException;

	public <T extends Entite> List<T> getListUnique(final Class<T> t)
			throws HibernateException;

	/************ propre khaled saoudi ****************/
	public List<? extends Entite> FindByCriteria(Class classe, Criterion critere)
			throws HibernateException;

	/************ propre khaled saoudi ****************/

	public List<? extends Entite> getListWithNamedQuery(
			final String namedQueryName) throws HibernateException;

	public List<? extends Entite> getListWithNamedQuery(
			final String namedQueryName, final Map<String, Object> parameters)
			throws HibernateException;

	public void deleteWithNamedQuery(final String namedQueryName,
			final Map<String, Object> parameters) throws HibernateException;

	public void deleteWithNamedQuery(final String namedQueryName)
			throws HibernateException;

	public void updateWithNamedQuery(final String namedQueryName,
			final Map<String, Object> parameters) throws HibernateException;

	public void updateWithNamedQuery(final String namedQueryName)
			throws HibernateException;

	public long countListEtat();

	public long countList(final String namedQueryName,
			final Map<String, Object> parameters) throws HibernateException;




}
