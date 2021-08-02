package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
