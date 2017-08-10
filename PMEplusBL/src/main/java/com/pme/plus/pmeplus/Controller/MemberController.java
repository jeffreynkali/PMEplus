package com.pme.plus.pmeplus.Controller;

import com.pme.plus.pmeplus.Entity.Member;
import com.pme.plus.pmeplus.api.Service.MemberServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gnkali on 7/29/17.
 */
@Controller("memberController")
public class MemberController {

    private MemberServiceAPI memberService;

    @Autowired
    public void setMemberService(MemberServiceAPI memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("member/new")
    public String newMember(Model model){
        model.addAttribute("member", new Member());
        return "memberform";
    }

    @RequestMapping(value = "member", method = RequestMethod.POST)
    public String saveMember(Member member){
        memberService.saveMember(member);
        return "redirect:/member/" + member.getIdMember();
    }

    @RequestMapping("member/{id}")
    public String showMember(@PathVariable Integer id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "membershow";
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("members", memberService.listAllMembers());
        return "members";
    }

    @RequestMapping("member/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "memberform";
    }

    @RequestMapping("member/delete/{id}")
    public String delete(@PathVariable Integer id){
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}

