package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
}
