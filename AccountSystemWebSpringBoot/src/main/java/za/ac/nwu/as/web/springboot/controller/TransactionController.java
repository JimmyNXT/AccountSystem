package za.ac.nwu.as.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.ResponseObjects.ErrorMessage;
import za.ac.nwu.as.domain.dto.AccountTypeDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.exception.DatabaseReadException;
import za.ac.nwu.as.domain.service.ErrorResponse;
import za.ac.nwu.as.domain.service.GoalResponse;
import za.ac.nwu.as.logic.flow.CreateTransactionFlow;

@RestController
@RequestMapping("transaction")
@ComponentScan(value = "za.ac.nwu.as.logic.flow")
public class TransactionController {

    private CreateTransactionFlow createTransactionFlow;

}
