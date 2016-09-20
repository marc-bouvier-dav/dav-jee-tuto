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
package fr.davidson.sample.jee.web.converter;

import fr.davidson.sample.jee.domain.model.formation.Formateur;
import fr.davidson.sample.jee.domain.model.formation.Formation;
import fr.davidson.sample.jee.domain.service.FormateurService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author osboxes
 */
@Named
public class FormateurConverter implements Converter{

    @Inject private FormateurService formateurService;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Formateur formateur=null;
        if(value!=null&& Long.valueOf(value)!=null){
            Long id = Long.valueOf(value);
            formateur = formateurService.find(id);
        }
        return formateur;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String resultat = null;
        if(value instanceof Formateur){
            resultat = String.valueOf(((Formateur)value).getId());
        }
        return resultat;
    }
    
}
