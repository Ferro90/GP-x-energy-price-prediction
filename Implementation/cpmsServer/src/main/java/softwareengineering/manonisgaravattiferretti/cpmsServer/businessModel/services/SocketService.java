package softwareengineering.manonisgaravattiferretti.cpmsServer.businessModel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softwareengineering.manonisgaravattiferretti.cpmsServer.businessModel.dtos.ChangeSocketAvailabilityDTO;
import softwareengineering.manonisgaravattiferretti.cpmsServer.businessModel.entities.Socket;
import softwareengineering.manonisgaravattiferretti.cpmsServer.businessModel.repositories.SocketRepository;

import java.util.Optional;

@Service
public class SocketService {
    private final SocketRepository socketRepository;

    @Autowired
    public SocketService(SocketRepository socketRepository) {
        this.socketRepository = socketRepository;
    }

    public Optional<Socket> findSocketByCpIdAndSocketId(String cpId, Integer socketId) {
        return socketRepository.findSocketByCpIdAndSocketId(cpId, socketId);
    }

    public void updateSocketAvailability(ChangeSocketAvailabilityDTO changeSocketAvailabilityDTO) {
        socketRepository.updateSocketAvailability(changeSocketAvailabilityDTO);
    }

    public void updateSocketStatus(String cpInternalId, Integer socketId, String status) {
        socketRepository.updateSocketStatus(cpInternalId, socketId, status);
    }
}
