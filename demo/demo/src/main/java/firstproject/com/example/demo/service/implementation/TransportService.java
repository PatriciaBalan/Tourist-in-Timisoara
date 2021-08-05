package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.model.Transport;
import firstproject.com.example.demo.repository.TransportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transport")
@ControllerAdvice
public class TransportService {

    private final Logger logger = LoggerFactory.getLogger(TransportService.class);
    private TransportService transportService;
    private TransportRepository transportRepository;

    public TransportService(TransportService transportService, TransportRepository transportRepository){
        this.transportService = transportService;
        this.transportRepository = transportRepository;
    }

    @GetMapping
    List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTransportById(@PathVariable Integer id) {
        Optional<Transport> transport = transportRepository.findById(id);
        return transport.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/newTransport")
    ResponseEntity<Transport> createTransport(@RequestBody Transport transport) throws URISyntaxException{
        logger.info("Request to create Transport: {}", transport);
        Transport result = transportRepository.save(transport);
        return ResponseEntity.created(new URI("/api/transport/newTransport" + result.getTransportId()))
                .body(result);
    }

    @PutMapping("/updateTransport/{id}")
    ResponseEntity<Transport> updateTransport(@RequestBody Transport transport) {
        logger.info("Request to update transport: {}", transport);
        Transport result = transportRepository.save(transport);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deleteTransportById/{id}")
    public ResponseEntity<?> deleteTransport(@PathVariable Integer id) {
        logger.info("Request to delete transport: {}", id);
        transportRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllTransports")
    public void deleteAllTransports() {
        transportRepository.deleteAll();
    }
}
