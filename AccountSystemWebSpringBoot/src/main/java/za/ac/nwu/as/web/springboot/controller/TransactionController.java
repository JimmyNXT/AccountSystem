package za.ac.nwu.as.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.dto.AccountTransactionDTO;
import za.ac.nwu.as.domain.dto.AccountTypeDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateTransactionFlow;

@RestController
@RequestMapping("transaction")
@ComponentScan(value = "za.ac.nwu.as.logic.flow")
public class TransactionController {

    private CreateTransactionFlow createTransactionFlow;

    @Autowired
    public TransactionController(CreateTransactionFlow createTransactionFlow) {
        this.createTransactionFlow = createTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a transaction", notes = "Creates a new transaction in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The transaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDTO>> create(
            @ApiParam(
                    value = "Request body to create new transaction.",
                    required = true)
            @RequestBody Integer memberID,
            @ApiParam(
                    value = "Request body to create new transaction.",
                    required = true)
            @RequestBody String AccountTypeMnemonic,
            @ApiParam(
                    value = "Request body to create new transaction.",
                    required = true)
            @RequestBody Long amount){
        AccountTransactionDTO accountTransactionDTOResponse = createTransactionFlow.create(memberID, AccountTypeMnemonic, amount);
        GeneralResponse<AccountTransactionDTO> response = new GeneralResponse<AccountTransactionDTO>(true, accountTransactionDTOResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
