package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Category;

public interface CategoryJpaRepository extends JpaRepository<Category,Integer>{
	public Category findByCategoryName(String name);
}
