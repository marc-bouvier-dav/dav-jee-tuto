
package fr.davidson.sample.jee.jaxws.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hello", namespace = "http://service.jaxws.jee.sample.davidson.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hello", namespace = "http://service.jaxws.jee.sample.davidson.fr/")
public class Hello {

    @XmlElement(name = "who", namespace = "")
    private String who;

    /**
     * 
     * @return
     *     returns String
     */
    public String getWho() {
        return this.who;
    }

    /**
     * 
     * @param who
     *     the value for the who property
     */
    public void setWho(String who) {
        this.who = who;
    }

}
