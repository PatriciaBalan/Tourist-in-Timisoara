package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.TransportCreateDto;
import firstproject.com.example.demo.dto.TransportInfoDto;

import java.util.List;

public interface TransportService {

    List<TransportInfoDto> getAllTransports();

    TransportInfoDto createTransport(TransportCreateDto transportCreateDto);

    void updateTransport(int transportId, String transportName, String transportDetail);

    void deleteTransport(int transportId);
}
