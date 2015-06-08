//package val.examples.hibernate;

package hibernate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainIber
{
	
	/*******************************************************
	 * 
	 * EJEMPLO B�sico del Uso de HIBERNATE
	 * 
	 * Todo lo que hasta hora est�bamos metiendo en el paquete "DAO", es lo que va a englobar y encargarse de ello
	 * el conjunto de bibliotecas que representa Hibernate
	 * 
	 * 		- Las conexiones ( y la concurrencia entra ellas )
	 * 		- La comunicaci�n con la base de datos (ejecuci�n de consultas SQL)
	 * 		- La escritura de POJOS o DTO's (para persistir clases en la base de datos)
	 * 		- La recuperaci�n de registros en DTO's (para recuperar filas y pasarlas a clases Java)
	 * 		- El manejo de las transacciones (Para gestionar adecuadamente la interacci�n con la BD, salvaguardadno la integridad)
	 * 
	 * 
	 * */
	
	
	
	
	
    public static void main(String args[]){
    	
    	//Cargo la configuraci�n: MAPPING entre Tablas y Objetos as� como La descripci�n de la base de de datos
    	//Dicho de otra forma: cargamos en memoria en la clase Configuration el hibernate.cfg.xml
    	Configuration configuration = new Configuration().configure();
    	//Preparo a un objeto, que ser� el encargado de generarme el estado de comunicaci�n con la base de datos
    	//StandardServiceRegistryBuilder se preconfigura el entorno a emplear
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	
    	//Ahora s�, obtengo el objeto SessionFactory, a partir de la anterior clase /servicio
    	//que ya es la clase que encapsula al Pool y dem�s recursos f�sicos
    	SessionFactory factory = configuration.buildSessionFactory(builder.build());//Solo se hace una vez en cada programa
    	
    	//Ahora ya con sesion, obtengo y manejo conexiones que me va dando SessionFactory
    	Session session = factory.openSession(); //Se hace al menos una vez
    	//Session session = factory.getCurrentSession(); // para obtener la session actual y se hace cada vez que quiera operar sobre la BBDD
    	
    	//Me creo el POJO
    	Region region = new Region();
    	region.setRegion_id(850);;
    	region.setRegion_name("Antartida");
    	
    	Transaction transaction = null;
    	//Y procedo a guardarlo --> INICIO DE LA TRANSACCION
    	try 
    	{
    		transaction = session.beginTransaction();//pone un punto de guarda
    		session.save(region); //hace un INSERT
    		transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
    	}
    	catch (Exception e)
    	{
    		transaction.rollback();//si algo ha ido mal, deshago la transacci�n
    	}
    	
    	try 
    	{
    		transaction = session.beginTransaction();
    		@SuppressWarnings("unchecked")										//la entidad es el objeto java
			List<Region> list = session.createSQLQuery("SELECT * FROM REGIONS").addEntity(Region.class).list();
    		Iterator<Region> it = list.iterator();
    		Region rg;
    		while (it.hasNext())
    		{
    			rg = it.next();
    			System.out.println(rg.toString());
    		}
    		transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		transaction.rollback();//si algo ha ido mal, deshago la transacci�n
    	}
    	finally 
    	{
    		session.disconnect();// Cada vez que termine de operar sobre la BBDD
    		//session.close();//haya ido bien o mal, libero recursos! Solo cerrarla si se quiere eliminar la session. Al terminar todas las operaciones 
    		//factory.close(); //solo cerrarla ya no se va a volver a usar
    	}
    	
    }
}