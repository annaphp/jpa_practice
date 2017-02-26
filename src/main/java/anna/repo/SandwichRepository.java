package anna.repo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import anna.model.Sandwich;

public class SandwichRepository {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	
	public  long save(Sandwich sandwich){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		long id = (Long)session.save(sandwich);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public  void update(Sandwich sandwich){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(sandwich);
		session.getTransaction().commit();
		session.close();
	}
	
	public Sandwich findSandwichById(long id){
		Session session = sessionFactory.openSession();
		Sandwich sandwich = session.get(Sandwich.class, id);
		session.close();
		return sandwich;
	}
	
	public  void delete(Sandwich sandwich){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(sandwich);
		session.getTransaction().commit();
		session.close();
	}
}
