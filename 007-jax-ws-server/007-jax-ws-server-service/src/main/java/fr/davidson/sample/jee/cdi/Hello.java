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
package fr.davidson.sample.jee.cdi;

import fr.davidson.sample.jee.cdi.interceptor.Audited;
import javax.annotation.ManagedBean;
import javax.inject.Named;

/**
 * Cette classe est accessible à JSF car elle possède une annotation @ManagedBean.
 * Elle aurait pu être rendue acessible si elle avait eu toute autre annotation 
 * "qualifier" par exemple 
 * <ul>
 * <li>javax.enterprise.inject.Model</li>
 * <li>javax.annotation.ManagedBean</li>
 * <li>javax.faces.bean.ManagedBean</li>
 * </ul>
 * <p></p>
 * @author marc.bouvier@davidson.fr
 */
@Named
public class Hello {
    
    /**
     * Cette méthode est annotée avec l'intercepteur @Audited (voir ici : {@link Audited})
     * Cela signifie qu'une méthode est exécutée avant que le contenu de celle-ci le soit.
     * @param text text
     * @param text2 text
     */
    @Audited
    public void helloWorld(String text,String text2){
        System.out.println("Hello world! "+text+" "+text2);
    }
    
    
}
