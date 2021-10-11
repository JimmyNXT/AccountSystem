package za.ac.nwu.as.web.springboot.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.ResponseObjects.ErrorMessage;
import za.ac.nwu.as.domain.dto.AccountBalanceDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.exception.DatabaseReadException;
import za.ac.nwu.as.domain.service.ErrorResponse;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.domain.service.MemberResponse;
import za.ac.nwu.as.logic.flow.CreateMemberFlow;
import za.ac.nwu.as.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("member")
@ComponentScan(value = "za.ac.nwu.as.logic.flow")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow, CreateMemberFlow createMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the saved members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = MemberResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class)
    })
    public ResponseEntity getAll(){
        try {
            List<MemberDTO> members = fetchMemberFlow.getAllMembers();
            MemberResponse response = new MemberResponse(members);
            return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
        }catch (DatabaseReadException e)
        {
            ErrorResponse response = new ErrorResponse(new ErrorMessage(e.getMessage()));
            return  new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new member", notes = "Creates a new member in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDTO>> create(
            @ApiParam(
                    value = "Request body to create new member.",
                    required = true)
            @RequestBody MemberDTO member){
        MemberDTO memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDTO> response = new GeneralResponse<MemberDTO>(true, memberResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/balances")
    @ApiOperation(value = "Gets all the saved members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class)
    })
    public ResponseEntity getMemberBalance(
            @ApiParam(
            value = "Request body for userAccount.",
            required = true)
            @RequestParam Integer memberID){
        try {
            List<AccountBalanceDTO> accountBalance = fetchMemberFlow.getMemberBalances(memberID);
            return new ResponseEntity<List<AccountBalanceDTO>>(accountBalance, HttpStatus.OK);
        }catch (DatabaseReadException e)
        {
            ErrorResponse response = new ErrorResponse(new ErrorMessage(e.getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
