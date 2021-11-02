/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstcalculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


/**
 *
 * @author 1
 */
public class MyFirstCalculator {
        
    public static double calc(String input) throws ScriptException{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    return (Double)engine.eval(input);
}


    public static void main(String[] args) throws ScriptException {
        
    JFrameToCalc jTC = new JFrameToCalc();
        //System.out.println("a");      
//String s = "((1+38)*4.5-1/2)";
//String v = "(3.5 + 3)";
//Double a = calc(s);
//Double b = calc(v);
//System.out.println(a); 
    
}    


}

