— — —— ZADANIE —— — — —

Vasou ulohou bude vytvorit klasicku poznamkovaciu aplikaciu pomocou J2EE frameworku, ktora poskytne HTTP REST API na vytvorenie, editaciu, mazanie, ziskanie jednej a ziskanie kolekcie poznamok. Rovnako bude mozne zadat jednoduchy fulltext filter pre filtrovanie vyslednej kolekcie.

Aplikacia musi mat kod rozdeleny do troch "vrstiev" (tried):

DAO:

trieda v ktorej sa bude realizovat praca s databazou
musi mat rozhranie definujuce jej metody
musi byt injektovatelna v ramci CDI a EJB
implementovana bude pomocou JPA
Nazov rozhranie: TaskDao.java
Nazov implementacie: TaskDaoJpa.java
SERVICE:

trieda obsahujuca biznis logiku (v prvom kroku bude skoro prazdna. bude mat v sebe len volanie dao vrstvy)
musi mat rozhranie definujuce jej metody
musi byt injektovatelna v ramci CDI a EJB
implementovana bude pomocou EJB
Nazov rozhranie: TaskService.java
Nazov implementacie: TaskServiceEjb.java
API: trieda vystavujuca REST API:

trieda obsahujuca definiciu api
po prijati http requestu dedikuje pracu na konkretnu metodu v servisnej vrstve
implementovana bude pomocou JAX-RS
VERZIE HLAVNYCH PRVKOV: Jazyk: Java 12 alebo vyssie Framework: J2EE8 alebo vyssie Server: Wildfly 16 alebo vyssie

HLAVNE TECHNOLOGIE: Dao: JPA+JTA Service: CDI+EJB Api: JAX-RS

ULOHY:

Nastudovat si tieto jednotlive specifikacie J2EE: Servlet API, CDI, EJB, JPA, JTA, JAX-RS
Vytvorit si domenovy objekt (triedu) Task reprezentujucu tabulku v DB
Tuto treba oanotovat aby ju JPA rozoznalo a zaregistrovat do persistence.xml
Vytvorit Dao, Service a Api triedy
Oanotovat potrebnymi CDI, EJB a JAX-RS anotaciami
Api zaregistrovat v triede ApplicationConfig.java
Overit funkcnost pomocou curl alebo ineho toolu pre skladanie http poziadaviek
DOKUMENTACIA (len priklady co sa da pouzit): https://docs.oracle.com/javaee/7/tutorial/index.html http://www.thejavageek.com/2015/12/16/jax-rs-hello-world-example-with-wildfly/ http://www.mastertheboss.com/jboss-frameworks/cdi/cdi-and-jpa-tutorial
