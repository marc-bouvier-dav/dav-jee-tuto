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
package fr.davidson.sample.jee.cdi.interceptor;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Implémentation de l'intercepteur permettant de logger l'exécution d'une 
 * méthode au début de celle-ci.
 * <p>Cette classe nécessite d'avoir écrit un interceptor binding 
 * (ici {@link Audited}) et de l'annoter avec.
 * </p>
 * <p>
 * Pour activer l'intercepteur, il faut le renseigner dans le fichier beans.xml
 * de la façon suivante : 
 * </p>
 * <pre>
 * <code>
 * &lt;interceptors&gt;
 *    &lt;class&gt;fr.davidson.sample.jee.cdi.interceptor.Auditor&lt;/class&gt;
 * &lt;/interceptors&gt;
 * </code>
 * </pre>
 * @author marc.bouvier@davidson.fr
 */
@Interceptor
@Audited
public class Auditor {
    private static Logger LOGGER = Logger.getLogger(Auditor.class.getName());
  
 @AroundInvoke
 public Object audit(InvocationContext context) throws Exception {
     
    LOGGER.log(Level.INFO, "Debut d execution de la methode {0}({1})", new String[]{context.getMethod().getName(),parametersAsString(context.getParameters())});
    Object result = context.proceed();
    LOGGER.log(Level.INFO, "Fin d execution de la methode {0}({1})", new String[]{context.getMethod().getName(),parametersAsString(context.getParameters())});       
    return result;
 }

 private String parametersAsString(Object[] parameters){
        return Arrays.stream(parameters)
                .map(o -> "["+o.getClass().getName() + ":\""+String.valueOf(o)+"\"]")
                .collect(Collectors.joining(", "));
 }
}
