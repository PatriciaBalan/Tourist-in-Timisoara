package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends PagingAndSortingRepository<Transport, Integer> {
}
