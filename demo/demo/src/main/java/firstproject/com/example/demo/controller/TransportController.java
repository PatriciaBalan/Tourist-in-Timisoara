package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.component.TransportMapper;
import firstproject.com.example.demo.dto.TransportCreateDto;
import firstproject.com.example.demo.dto.TransportInfoDto;
import firstproject.com.example.demo.model.Tourist_spot;
import firstproject.com.example.demo.model.Transport;
import firstproject.com.example.demo.repository.TransportRepository;
import firstproject.com.example.demo.service.implementation.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tourist_in_timisoara/transport")
@ControllerAdvice
public class TransportController {

    private final Logger logger = LoggerFactory.getLogger(TransportService.class);
    private TransportService transportService;
    private TransportRepository transportRepository;

    public TransportController(TransportService transportService, TransportRepository transportRepository){
        this.transportService = transportService;
        this.transportRepository = transportRepository;
    }

    @GetMapping
    List<TransportInfoDto> getAllTransports() {
        return transportService.getAllTransports();
    }

//    @GetMapping("/{id}")
//    ResponseEntity<?> getTransportById(@PathVariable Integer id) {
//        Optional<Transport> transport = transportRepository.findById(id);
//        return transport.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping("/createTransport")
    ResponseEntity<TransportInfoDto> createTransport(@RequestBody TransportCreateDto transportCreateDto) throws URISyntaxException {
//        logger.info("Request to create Transport: {}", transport);
//        Transport result = transportRepository.save(transport);
//        return ResponseEntity.created(new URI("/api/transport/newTransport" + result.getTransportId()))
//                .body(result);
        return ResponseEntity.ok(transportService.createTransport(transportCreateDto));
    }

    @PutMapping("/transportId")
    ResponseEntity<TransportInfoDto> updateTransport(@PathVariable("transportId") int transportId,
                                                     @RequestBody Transport transport) {
//        logger.info("Request to update transport: {}", transport);
//        Transport result = transportRepository.save(transport);
//        return ResponseEntity.ok().body(result);

        transportRepository.findById(transportId).get();
        transport.setTransportType(transport.getTransportType());
        transport.setTransportDetail(transport.getTransportDetail());
        transportRepository.save(transport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/transportId")
    public ResponseEntity<TransportInfoDto> deleteTransport(@PathVariable("transportId") int transportId) {
        logger.info("Request to delete transport: {}", transportId);
        transportRepository.deleteById(transportId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllTransports")
    public void deleteAllTransports() {
        transportRepository.deleteAll();
    }
}

