package za.ac.nwu.as.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateMemberFlow;
import za.ac.nwu.as.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("member")
@ComponentScan(value = "za.ac.nwu.as.logic.flow")
public class MemberController {

    private FetchMemberFlow fetchMemberFlow;
    private CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow, CreateMemberFlow createMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the saved members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<MemberDTO>>> getAll(){
        List<MemberDTO> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDTO>> response = new GeneralResponse<>(true, members);
        return new ResponseEntity<GeneralResponse<List<MemberDTO>>>(response, HttpStatus.OK);
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
}
