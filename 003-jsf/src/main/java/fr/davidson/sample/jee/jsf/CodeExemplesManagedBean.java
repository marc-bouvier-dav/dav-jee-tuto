/*
 * This is free and unencumbered software released into the public domain.
 * 
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <http://unlicense.org>
 */
package fr.davidson.sample.jee.jsf;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * Exemples de code.
 *
 * @author marc.bouvier@davidson.fr 
 */
@ManagedBean(name = "codeExemples")
@RequestScoped
public class CodeExemplesManagedBean {

   
  String uiRepeatJsfc="<table style=\"border: solid 1px\">\n" +
"    <tr jsfc=\"ui:repeat\" value=\"#{iterationManagedBean.liste}\" var=\"item\" varStatus=\"status\">\n" +
"        <td>#{item.cle}</td><td>#{item.valeur}</td>\n" +
"    </tr>\n" +
"</table>";
  
  String uiRepeatStatus="<ui:repeat value=\"#{iterationManagedBean.liste}\" var=\"item\" varStatus=\"status\">\n" +
"    <p style=\"#{status.odd?'color:red':'color:aqua'}\">#{item.cle} - #{item.valeur} \n" +
"        (status.odd : #{status.odd}, status.even : #{status.even}, status.index : #{status.index})</p>\n" +
"</ui:repeat>";

    public String getUiRepeatJsfc() {
        return uiRepeatJsfc;
    }

    public String getUiRepeatStatus() {
        return uiRepeatStatus;
    }
    
    
  
  
    
    
    
}
