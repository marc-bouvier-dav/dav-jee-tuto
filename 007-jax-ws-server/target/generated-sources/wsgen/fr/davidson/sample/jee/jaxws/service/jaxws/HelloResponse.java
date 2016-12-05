
package fr.davidson.sample.jee.jaxws.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "helloResponse", namespace = "http://service.jaxws.jee.sample.davidson.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "helloResponse", namespace = "http://service.jaxws.jee.sample.davidson.fr/")
public class HelloResponse {

    @XmlElement(name = "helloResult", namespace = "")
    private String helloResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getHelloResult() {
        return this.helloResult;
    }

    /**
     * 
     * @param helloResult
     *     the value for the helloResult property
     */
    public void setHelloResult(String helloResult) {
        this.helloResult = helloResult;
    }

}
