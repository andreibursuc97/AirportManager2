package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "timezone")
public class TimeZoneDTO {

    @XmlElement(name = "localtime")
    private String localtime;

    @XmlElement(name = "isotime")
    private String isotime;

    @XmlElement(name = "isotime")
    private String utctime;

    @XmlElement(name = "localtime")
    public String getLocalTime() {
        return localtime;
    }

    @XmlElement(name = "isotime")
    public String getIsoTime() {
        return isotime;
    }

    @XmlElement(name = "utctime")
    public String getUtcTime() {
        return utctime;
    }
}
