/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.examenfinal;

/**
 *
 * @author T-10A
 */
public class formita {
    
    Ext.define('producto',{
    extend:'Ext.data.Model',
    config:{
        fields:[
            {name:'id', type:'int'},
            {name:'unidades', type:'int'},
            {name:'nombre',type:'string'},
            {name:'precio',type:'float'}
        ]
    ,
    proxy:{
        type:'rest',
        url:'http://localhost:8084/maven-spring-hibernate/servicios/usuario',
        reader:{
            type:'json',
            rootProperty:'producto'
        }
    }
  }
});
Ext.application({
    name:'formita2',
    launch:function(){
Ext.create('Ext.form.Panel',{
    fullscreen:true,
  items:[
      {
      xtype:'fieldset',
      
        items:[
            {
                xtype:'textfield',
                id:'nombre',
                label:'Nombre'
            },
            {
                xtype:'textfield',
                id:'sueldo',
                label:'Sueldo'
            },
            {
                xtype:'button',
                text:'guardar producto',
                ui:'success',
                handler:function(){
                  
                    /*
                     * A guardar culebras de rio
                     * 
                     */
                    var usuariopost = Ext.create('producto', {nombre: Ext.getCmp('producto').getValue(), sueldo:Ext.getCmp('sueldo').getValue()});

        usuariopost.save({
    success: function(ed) {
          Ext.Msg.alert("guardado");
        console.log("El producto que se ha guardado es este:"+ ed.get("nombre"));
     
    },
    failure:function(ed){
        console.log('nada'+ed.nombre);
    }
}); 
                }
            }
        ]
    } 
  ]
    
});
    }
});
}
