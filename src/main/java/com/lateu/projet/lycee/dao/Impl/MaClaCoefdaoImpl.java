/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.MaClaCoefdao;
import com.lateu.projet.lycee.entities.MaClaCoef;

/**
 *
 * @author richardlateu
 */
public class MaClaCoefdaoImpl extends GenericDao<MaClaCoef, Long> implements MaClaCoefdao{
       @Override
    public MaClaCoef getLevelMatiere(Long idmat,Long idClasse) throws DataAccessException {
         return (MaClaCoef)getManager().createNamedQuery("getLevelMatiere")
                .setParameter("idmat",idmat)
                 .setParameter("idClasse", idClasse)
                .getSingleResult();
    }
}
