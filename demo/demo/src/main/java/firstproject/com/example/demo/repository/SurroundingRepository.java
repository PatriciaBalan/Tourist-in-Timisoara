package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Surrounding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurroundingRepository extends PagingAndSortingRepository<Surrounding, Integer> {
}
