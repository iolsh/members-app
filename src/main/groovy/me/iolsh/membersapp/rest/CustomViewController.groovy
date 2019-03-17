package me.iolsh.membersapp.rest


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.web.bind.annotation.RequestMapping

@RepositoryRestController
@RequestMapping('/api/v')
class CustomViewController extends ControllerBase {

    private final me.iolsh.membersapp.repository.MemberRepository memberRepository;
    private final me.iolsh.membersapp.repository.PaymentRepository paymentRepository;
    private final me.iolsh.membersapp.repository.ResolutionRepository resolutionRepository;

    @Autowired
    CustomViewController(me.iolsh.membersapp.repository.MemberRepository mRepository, me.iolsh.membersapp.repository.PaymentRepository pRepository, me.iolsh.membersapp.repository.ResolutionRepository rRepository) {
        this.memberRepository = mRepository;
        this.paymentRepository = pRepository;
        this.resolutionRepository = rRepository;
    }

    //TODO add custom views

}
