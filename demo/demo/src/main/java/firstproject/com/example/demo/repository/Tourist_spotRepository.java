package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Tourist_spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tourist_spotRepository extends PagingAndSortingRepository<Tourist_spot, Integer> {
}
