package me.iolsh.membersapp.rest


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
@RequestMapping('/api/')
class MembersController extends ControllerBase {

    private final me.iolsh.membersapp.repository.MemberRepository memberRepository;

    @Autowired
    MembersController(me.iolsh.membersapp.repository.MemberRepository repository) {
        this.memberRepository = repository
    }

    @RequestMapping(method = RequestMethod.GET, value = "/m/a")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Member>> getAllMembers() {
        List<me.iolsh.membersapp.domain.membership.Member> members = memberRepository.findAll()
        return ResponseEntity.ok(members)
    }

    @RequestMapping(method = RequestMethod.GET, value = "/m/nc")
    @ResponseBody ResponseEntity<Integer> getNewMembersCount() {
        return ResponseEntity.ok(memberRepository.findAll().size())
    }

    @RequestMapping(method = RequestMethod.GET, value = "/m/i/{id}")
    @ResponseBody ResponseEntity<me.iolsh.membersapp.domain.membership.Member> getMemberById(@PathVariable Long id) {
        me.iolsh.membersapp.domain.membership.Member member = memberRepository.findOne(id)
        return ResponseEntity.ok(member)
    }

    @RequestMapping(method = RequestMethod.GET, value = "/m/p/{pesel}")
    @ResponseBody ResponseEntity<me.iolsh.membersapp.domain.membership.Member> getMemberByPesel(@PathVariable String pesel) {
        me.iolsh.membersapp.domain.membership.Member member = memberRepository.findByPesel(pesel)
        return ResponseEntity.ok(member)
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/m/i/{id}")
    @ResponseBody ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            memberRepository.delete(id)
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/m/save")
    @ResponseBody ResponseEntity<Void> update(@RequestBody me.iolsh.membersapp.domain.membership.Member member) {
        try {
            member.updated = new Date()
            memberRepository.save(member)
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/m/add")
    @ResponseBody ResponseEntity<Void> add(@RequestBody me.iolsh.membersapp.domain.membership.Member member) {
        try {
            if (member.submission == null) {
                member.submission = new Date()
            }
            memberRepository.save(member)
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
