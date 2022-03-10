//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2022.03.09 à 09:37:24 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour typeratioType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="typeratioType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="vitesse"/&gt;
 *     &lt;enumeration value="gain"/&gt;
 *     &lt;enumeration value="ange"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "typeratioType")
@XmlEnum
public enum TyperatioType {

    @XmlEnumValue("vitesse")
    VITESSE("vitesse"),
    @XmlEnumValue("gain")
    GAIN("gain"),
    @XmlEnumValue("ange")
    ANGE("ange");
    private final String value;

    TyperatioType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TyperatioType fromValue(String v) {
        for (TyperatioType c: TyperatioType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
