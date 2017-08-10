package com.pme.plus.pmeplus.Rest.V1;

import com.pme.plus.pmeplus.api.Controller.MemberControllerAPI;
import com.pme.plus.pmeplus.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by gnkali on 6/27/17.
 */

@RequestMapping("/member")
@RestController
public class MemberRESTController {

    @Autowired
    private MemberControllerAPI memberControllerAPI; //service in charge of all data related operations

    public void setMemberControllerAPI(MemberControllerAPI memberControllerAPI) {
        this.memberControllerAPI = memberControllerAPI;
    }

    /******************************************
     * REST ENDPOINTS for future micro-service
     * architecture implementation
     ******************************************/


    @RequestMapping(method = RequestMethod.GET, value= "/")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members =  memberControllerAPI.getAllMembers();
        if( members.isEmpty()) {
            return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT); //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value= "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> getMemberByID(@PathVariable("id") int idMember) {

        System.out.println("Fetching Member with id " + idMember);
        Member member = memberControllerAPI.getMemberByID(idMember);
        if (member == null) {
            System.out.println("User with id " + idMember + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createMember(@RequestBody Member member,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Member " + member.getFirstname() + " " + member.getLastname());

        if (memberControllerAPI.isMemberExist(member)) {
            System.out.println("A Member with fullname " + member.getFirstname() + " " + member.getLastname() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        memberControllerAPI.createMember(member);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(member.getIdMember()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> updateMember(@PathVariable("id") int idMember, @RequestBody Member member) {
        System.out.println("Updating Member " + idMember);

        Member currentMember = memberControllerAPI.getMemberByID(idMember);

        if (currentMember == null) {
            System.out.println("Member with idMember " + idMember + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }

        currentMember.setFirstname(member.getFirstname());
        currentMember.setLastname(member.getLastname());
        currentMember.setEmail(member.getEmail());

        memberControllerAPI.updateMember(currentMember);
        return new ResponseEntity<Member>(currentMember, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}/")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Member with idMember " + id);

        Member member = memberControllerAPI.getMemberByID(id);
        if (member == null) {
            System.out.println("Unable to delete. Member with idMember " + id + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }

        memberControllerAPI.deleteMemberById(id);
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }
}
