package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {
}
