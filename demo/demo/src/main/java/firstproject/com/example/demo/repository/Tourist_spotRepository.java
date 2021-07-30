package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Tourist_spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tourist_spotRepository extends JpaRepository<Tourist_spot, Integer> {
}
