package Util;

import Application.Apl_Default;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luiz Venturote
 */
public class FormBuild {
    
    private String formPrefix = "<div class='form-group'>";
    private String formSufix = "</div>";
    private String form;
    
    /**
    * Get input text
    */
    public String getInputText(String labelName, String inputName) {
        
        this.form = "<label for='exampleInput'>"+labelName+"</label>\n" +
                    "<input type='text' class='form-control' name='"+inputName+"'>\n";
        
        return this.formPrefix +this.form+this.formSufix;
        
    }
    
    /**
    * Get input text
    */
    public String getSelect(HashMap hash, String labelName, String selectName) {
                
             
        
        return this.formPrefix +this.form+this.formSufix;
        
    }
    
    
        
    
}
