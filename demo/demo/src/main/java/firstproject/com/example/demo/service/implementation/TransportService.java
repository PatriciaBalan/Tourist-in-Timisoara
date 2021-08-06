package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.dto.TransportCreateDto;
import firstproject.com.example.demo.dto.TransportInfoDto;

import java.util.List;

public class TransportService implements firstproject.com.example.demo.service.TransportService {
    @Override
    public List<TransportInfoDto> getAllTransports() {
        return null;
    }

    @Override
    public TransportInfoDto createTransport(TransportCreateDto transportCreateDto) {
        return null;
    }

    @Override
    public void updateTransport(int transportId, String transportName, String transportDetail) {

    }

    @Override
    public void deleteTransport(int transportId) {

    }
}
