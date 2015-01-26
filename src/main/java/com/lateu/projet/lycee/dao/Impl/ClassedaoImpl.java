/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public class ClassedaoImpl extends GenericDao<Classe, Long> implements Classedao {

    @Override
    public Classe findClassebylibele(String libele) throws DataAccessException {
        return (Classe) getManager().createNamedQuery("findClasebylibele")
                .setParameter("libele", libele)
                .getSingleResult();
    }

    @Override
    public Classe MatiereValide(String matiere, String classe) throws DataAccessException {
        return (Classe) getManager().createNamedQuery("MatiereValide")
                .setParameter("matiere", matiere)
                .setParameter("classe", classe)
                .getSingleResult();

    }

    @Override
    public List<MaClaCoef> SommeCoef(String classe) throws DataAccessException {
        return getManager().createNamedQuery("SommeCoef")
                .setParameter("libele", classe)
                .getResultList();
    }

    @Override
    public Classe findClassebycode(String code) throws DataAccessException {
        return (Classe) getManager().createNamedQuery("findClasebycode")
                .setParameter("code", code)
                .getSingleResult();
    }

    @Override
    public List<Eleve> findElevebyClasse(String codeClasse, String codeAnnee) throws DataAccessException {
        return getManager().createNamedQuery("findByClasseAY")
                .setParameter("codeClasse", codeClasse)
                .setParameter("codeAnnee", codeAnnee)
                .getResultList();

    }
}