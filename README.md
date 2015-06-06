Dynamic Enum Proof-of-Concept
=============================

This project demonstrates how to dynamically configure the values of an enum
at run-time.  Unfortunately JAXB's @XmlEnum annotation can only decorate Java
enum types, but those who want to be able to control their XML enumerations
from a database can't use the @XmlEnum annotation.

This project attempts to load an empty enum's values using Java reflection.
While you can't create an enum programmatically, it appears you can alter the
list of Objects that make up the enum's constants.