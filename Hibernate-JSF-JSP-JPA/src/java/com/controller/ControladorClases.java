/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.Dao.UsuarioDao;
import com.test.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jriverac
 */
@ManagedBean
public class ControladorClases {
    
    private int codigo;
    private Usuario us;
    private String nombre;
    public static UsuarioDao usDao= new UsuarioDao();
    
    @PostConstruct
    public void init() {
        us=new Usuario();
        us.setIdusuario(8);
        us.setNombre("MARIO");
        us.setTelefono("43534545");
        us.setDireccion("N/A");
        usDao.guardarUser(us);
    }
    
    public void guardarUsuario(){
        us=new Usuario();
        us.setIdusuario(codigo);
        us.setNombre("CARLOS");
        us.setTelefono("2432343");
        us.setDireccion(nombre);
        usDao.guardarUser(us);
    }
    
    public void mostrarNomUser(){
        System.out.println("codigo:"+codigo);
        if(usDao.mostrarUser(codigo)!=null){
        setNombre(usDao.mostrarUser(codigo).getNombre());
        }else{
        setNombre("no existe usuario");    
        }
      }
      
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static UsuarioDao getUsDao() {
        return usDao;
    }

    public static void setUsDao(UsuarioDao usDao) {
        ControladorClases.usDao = usDao;
    }
    
    
    
}
