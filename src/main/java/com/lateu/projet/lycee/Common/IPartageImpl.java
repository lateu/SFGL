/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.Common;

/**
 *
 * @author ing-lateu
 */
public class IPartageImpl implements IPartage{

    @Override
    public String secureChaine(String s) {
      s = s.toLowerCase().trim().replace(" ", "_");
        return s;
    }
    
}
