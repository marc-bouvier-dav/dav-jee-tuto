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
import javax.inject.Named;





/**
 * Cette classe est accessible à JSF car elle possède une annotation @Named.
 * Elle aurait pu être rendue acessible si elle avait eu toute autre annotation 
 * "qualifier" par exemple 
 * <ul>
 * <li>javax.enterprise.inject.Model</li>
 * <li>javax.annotation.ManagedBean</li>
 * <li>javax.faces.bean.ManagedBean</li>
 * <li>javax.enterprise.inject.Default</li>
 * </ul>
 * <p></p>
 * @author marc.bouvier@davidson.fr
 */
@Named
public class Exemples {
  private String methodeAnnoteeInterceptor="@Audited\n" +
"public void helloWorld(String text,String text2){\n" +
"    System.out.println(\"Hello world! \"+text+\" \"+text2);\n" +
"}" ; 
  
  private String interceptorBinder="@Inherited\n" +
"@InterceptorBinding\n" +
"@Retention(RUNTIME)\n" +
"@Target({METHOD, TYPE})\n" +
"public @interface Audited {\n" +
"}";
  
  private String interceptorImplementation="@Interceptor\n" +
"@Audited\n" +
"public class Auditor {\n" +
"    private static Logger LOGGER = Logger.getLogger(Auditor.class.getName());\n" +
"  \n" +
" @AroundInvoke\n" +
" public Object audit(InvocationContext context) throws Exception {\n" +
"     \n" +
"    LOGGER.log(Level.INFO, \"Debut d execution de la methode {0}({1})\", new String[]{context.getMethod().getName(),parametersAsString(context.getParameters())});\n" +
"    Object result = context.proceed();\n" +
"    LOGGER.log(Level.INFO, \"Fin d execution de la methode {0}({1})\", new String[]{context.getMethod().getName(),parametersAsString(context.getParameters())});       \n" +
"    return result;\n" +
" }\n" +
"\n" +
" private String parametersAsString(Object[] parameters){\n" +
"        return Arrays.stream(parameters)\n" +
"                .map(o -> \"[\"+o.getClass().getName() + \":\\\"\"+String.valueOf(o)+\"\\\"]\")\n" +
"                .collect(Collectors.joining(\", \"));\n" +
" }\n" +
"}";

    public String getMethodeAnnoteeInterceptor() {
        return methodeAnnoteeInterceptor;
    }

    public String getInterceptorBinder() {
        return interceptorBinder;
    }

    public String getInterceptorImplementation() {
        return interceptorImplementation;
    }
    
    

}
