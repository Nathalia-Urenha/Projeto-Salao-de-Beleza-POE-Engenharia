package com.salaodebeleza.model.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public abstract class GenericDao<T, ID extends Serializable> {
	
private EntityManager entityManager;
	
	private final Class<T> classePersistencia;
	    
	@SuppressWarnings("unchecked")
	public GenericDao(EntityManager entityManager) {
    	this.entityManager = entityManager;
        this.classePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public void save(T entity) {
    	this.getEntityManager().persist(entity);
    }
    
    
    public void update(T entity) {
    	this.getEntityManager().merge(entity);
    }
    
    
    public void remove(T entity) {
    	this.getEntityManager().remove(entity);
    }
    
    
    public T findById(ID id) {
    	return this.getEntityManager().find(getClassePersistencia(), id);
    }
   
    
    @SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> classe){
    
    	List<T> lista = new ArrayList<T>();
    	
    	Query query = this.getEntityManager()            
    					  .createQuery("SELECT o FROM "+classe.getSimpleName()+" o");
    	
    	lista = query.getResultList();
    	return lista;
     	
    }
    
    
    public Integer countTotalRegister(Class<T> classe) {
		Query query = this.getEntityManager().createQuery("SELECT count(o) FROM "+classe.getSimpleName()+" o");
		Long total = (Long) query.getSingleResult();
		return total.intValue();
	}
    
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getClassePersistencia() {
		return classePersistencia;
	}
	
}
