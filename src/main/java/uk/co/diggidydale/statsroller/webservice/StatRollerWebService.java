package uk.co.diggidydale.statsroller.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.diggidydale.statsroller.model.Result;
import uk.co.diggidydale.statsroller.service.RollerService;

/**
 * @author DaleH
 */
@Component
@RestController
@RequestMapping("/statroller")
public class StatRollerWebService {

    private RollerService rollerService;

    @Autowired
    public StatRollerWebService(RollerService rollerService) {
        this.rollerService = rollerService;
    }

    @GetMapping(path = "/stats", produces = "application/json")
    public ResponseEntity<Result> rollStats(){
        return ResponseEntity.ok(new Result(rollerService.rollForStats()));
    }

    @GetMapping(path = "/statsOver18", produces = "application/json")
    public ResponseEntity<Result> rollStatsOneOver18(){
        return ResponseEntity.ok(new Result(rollerService.rollForStatsOver(18)));
    }
}
