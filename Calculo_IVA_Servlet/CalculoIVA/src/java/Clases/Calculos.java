/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author 17259444-1
 */
public class Calculos {
    
    public float calculo_IVA(int neto)
    {
        return (float) (neto*0.19);
    }
    
    public float calculoTotal(int neto, float iva)
    {
        return  (neto+iva);
    }
    
}
