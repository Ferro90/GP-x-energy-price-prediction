package softwareengineering.manonisgaravattiferretti.cpmsServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import softwareengineering.manonisgaravattiferretti.cpmsServer.authManager.CPODetailsService;
import softwareengineering.manonisgaravattiferretti.cpmsServer.model.dtos.CPORegistrationDTO;
import softwareengineering.manonisgaravattiferretti.cpmsServer.model.entities.CPO;
import softwareengineering.manonisgaravattiferretti.cpmsServer.model.services.CPOService;
import softwareengineering.manonisgaravattiferretti.cpmsServer.model.utils.EntityFromDTOConverter;

@RestController
public class RegistrationManager {
    private final CPOService cpoService;
    private final CPODetailsService cpoDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(RegistrationManager.class);

    @Autowired
    public RegistrationManager(CPOService cpoService, CPODetailsService cpoDetailsService,
                               PasswordEncoder passwordEncoder) {
        this.cpoService = cpoService;
        this.cpoDetailsService = cpoDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/api/CPO/register")
    public void registerCPO(@RequestBody CPORegistrationDTO cpoRegistrationDTO) {
        logger.info("Received registration cpo: " + cpoRegistrationDTO);
        CPO cpo = EntityFromDTOConverter.cpoFromRegistrationDTO(cpoRegistrationDTO);
        cpo.encodePassword(passwordEncoder);
        cpoService.insertCPO(cpo);
        /*try {
            CPO existingCPO = cpoDetailsService.loadUserByUsername(cpoRegistrationDTO.getCpoCode());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPO already present");
        } catch (UsernameNotFoundException e) {
            logger.info("Registered cpo: " + cpoRegistrationDTO);

        }*/
    }
}
