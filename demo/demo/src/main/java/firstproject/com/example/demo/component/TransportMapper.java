package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.TransportCreateDto;
import firstproject.com.example.demo.dto.TransportInfoDto;
import firstproject.com.example.demo.model.Transport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransportMapper {

    public static Transport toBase(TransportCreateDto transportCreateDto) {
        Transport transport = new Transport();
        transport.setTransportType(transportCreateDto.getTransportType());
        transport.setTransportDetail(transportCreateDto.getTransportDetail());
        return transport;
    }

    public static TransportInfoDto toDto(Transport transport) {
        TransportInfoDto transportInfoDto = new TransportInfoDto();
        transportInfoDto.setTransportId(transport.getTransportId());
        transportInfoDto.setTransportType(transport.getTransportType());
        transportInfoDto.setTransportDetail(transport.getTransportDetail());
        return transportInfoDto;
    }

    public static List<TransportInfoDto> toDtoList(Iterable<Transport> transports) {
        List<TransportInfoDto> results = new ArrayList<>();
        transports.forEach(transport -> results.add(toDto(transport)));
        return results;
    }
}
