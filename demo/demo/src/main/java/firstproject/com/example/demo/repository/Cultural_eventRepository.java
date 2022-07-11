package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Cultural_event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cultural_eventRepository extends PagingAndSortingRepository<Cultural_event, Integer> {
}
