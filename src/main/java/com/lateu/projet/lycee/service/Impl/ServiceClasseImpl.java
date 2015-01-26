/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceClasseImpl implements ServiceClasse{
private Classedao classedao;
/**
 * cette methode enregistre une nouvelle classe
 * @param classe
 * @throws ServiceException 
 */
    public void create(Classe classe) throws ServiceException {
    try {
        classedao.create(classe);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

   /**
    * 
    * @param libele
    * @return
    * @throws ServiceException 
    * cette methode determine le coef total pour une classe donnee
    */
    public Long TotalCoeficient(String nomClasse) throws ServiceException {
         Classe cl=new Classe();
    try {
        cl=classedao.findClassebylibele(nomClasse);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    String lib= cl.getLibele();
     
    Long s=0L;
         List<MaClaCoef> tmp=new ArrayList<MaClaCoef>();
    try {
        tmp = classedao.SommeCoef(lib);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        for (Iterator<MaClaCoef> it = tmp.iterator(); it.hasNext();) {
           MaClaCoef b = it.next();
           s+=b.getCoeficient();
           
        }
    
        return s;
    }
    //**************************/
    
    public Classedao getClassedao() {
        return classedao;
    }

    public void setClassedao(Classedao classedao) {
        this.classedao = classedao;
    }

    @Override
    public List<Classe> findAll() throws ServiceException {
    try {
        return classedao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public Classe findBylibele(String s) throws ServiceException {
    try {
        return classedao.findClassebylibele(s);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public List<Eleve> FindByClasse(String codeClasse, String codeAnnee) {
    try {
        return classedao.findElevebyClasse(codeClasse, codeAnnee);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public Classe findById(Long id) throws ServiceException {
    try {
        return classedao.findById(id);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
}