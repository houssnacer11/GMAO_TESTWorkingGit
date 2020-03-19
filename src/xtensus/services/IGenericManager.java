package xtensus.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import xtensus.entity.Entite;



public interface IGenericManager {

    public void insert(Entite entity) throws Exception;
    public void update(Entite entity) throws Exception;
    public void delete(Entite entity) throws Exception;
    public <T extends Entite> List<T> getList(Class<T> t) throws Exception;
    /************ propre khaled saoudi ****************/
	public List<? extends Entite> FindByCriteria(Class classe, Criterion critere) throws Exception;
	/************ propre khaled saoudi ****************/
    public <T extends Entite> List<T> getListUnique(Class<T> t) throws Exception;
   
   
   
    
}
