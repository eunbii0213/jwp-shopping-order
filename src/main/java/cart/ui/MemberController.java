package cart.ui;

import cart.dto.MemberResponse;
import cart.application.MemberService;
import cart.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberResponse> getGrade(Member member){
        return ResponseEntity.ok(memberService.getGradeById(member.getId()));
    }
}
