package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.Tourist_spotMapper;
import firstproject.com.example.demo.component.TransportMapper;
import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;
import firstproject.com.example.demo.dto.TransportCreateDto;
import firstproject.com.example.demo.dto.TransportInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Tourist_spot;
import firstproject.com.example.demo.model.Transport;
import firstproject.com.example.demo.repository.Tourist_spotRepository;
import firstproject.com.example.demo.repository.TransportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@Service
public class TransportService implements firstproject.com.example.demo.service.TransportService {
    private final Logger logger = LoggerFactory.getLogger(SurroundingService.class);
    private TransportRepository transportRepository;
    private TransportMapper transportMapper;

    public TransportService(TransportMapper transportMapper, TransportRepository transportRepository){
        this.transportMapper=transportMapper;
        this.transportRepository=transportRepository;
    }

    @Override
    public List<TransportInfoDto> getAllTransports() {
        return transportMapper.toDtoList(transportRepository.findAll());
    }

    @Override
    public TransportInfoDto createTransport(TransportCreateDto transportCreateDto) {
        return transportMapper.toDto(transportRepository.save(transportMapper.toBase(transportCreateDto)));
    }

    @Override
    public void updateTransport(int transportId, String transportType, String transportDetail) {

        Optional<Transport> transport = transportRepository.findById(transportId);

        if(!transport.isPresent()) throw  new EntityDoesNotExistsException("Transport id " + transportId);

        Transport transport1 = transport.get();
        transport1.setTransportType(transportType);
        transport1.setTransportDetail(transport1.getTransportDetail());
        transportRepository.save(transport1);
    }

    @Override
    public void deleteTransport(int transportId) {
        transportRepository.findById(transportId);
        transportRepository.deleteById(transportId);

    }
}


