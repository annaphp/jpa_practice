package repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import anna.model.Meat;
import anna.model.Sandwich;
import anna.repo.SandwichRepository;

public class SandwichRepositoryTest {
	
	long id;
	Sandwich sandwich;
	SandwichRepository repo;
	
	@Before
	public void setup ()throws Exception{
		Meat meat = new Meat ("Salami", 2);
	    sandwich = new Sandwich("White", meat);
	    repo = new SandwichRepository();
		id = repo.save(sandwich);
	}
	
	@Test
	public void shouldSave() throws InterruptedException{
		assertNotNull(repo.findSandwichById(id));
	}
	
	@Test
	public void shouldFindById(){
		assertEquals(repo.findSandwichById(id), sandwich);
	}
	
	@Test
	public void shouldUpdate(){
		sandwich.setBread("Multigrain");
		repo.update(sandwich);
		assertTrue(repo.findSandwichById(id).getBread().equals("Multigrain"));
	}
	
	@Test
	public void shouldDelete(){
		repo.delete(sandwich);
		assertNull(repo.findSandwichById(id));
	}
	
}
