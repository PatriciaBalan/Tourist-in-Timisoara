package firstproject.com.example.demo.repository;

import firstproject.com.example.demo.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
