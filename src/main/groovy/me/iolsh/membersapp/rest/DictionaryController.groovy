package me.iolsh.membersapp.rest


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
@RequestMapping(method=RequestMethod.GET, value = "/api/dict")
class DictionaryController extends ControllerBase {


    private final me.iolsh.membersapp.repository.PaymentTypeRepository paymentTypeRepository
    private final me.iolsh.membersapp.repository.CurrencyRepository currencyRepository
    private final me.iolsh.membersapp.repository.RoleRepository roleRepository
    private final me.iolsh.membersapp.repository.MemberStatusRepository memberStatusRepository
    private final me.iolsh.membersapp.repository.RegionRepository regionRepository
    private final me.iolsh.membersapp.repository.VoivodeshipRepository voivodeshipRepository

    @Autowired
    DictionaryController(
            me.iolsh.membersapp.repository.PaymentTypeRepository paymentTypeRepository,
            me.iolsh.membersapp.repository.CurrencyRepository currencyRepository,
            me.iolsh.membersapp.repository.RoleRepository roleRepository,
            me.iolsh.membersapp.repository.MemberStatusRepository memberStatusRepository,
            me.iolsh.membersapp.repository.RegionRepository regionRepository,
            me.iolsh.membersapp.repository.VoivodeshipRepository voivodeshipRepository


    )
    {
        this.paymentTypeRepository = paymentTypeRepository
        this.currencyRepository = currencyRepository
        this.memberStatusRepository = memberStatusRepository
        this.roleRepository = roleRepository
        this.regionRepository = regionRepository
        this.voivodeshipRepository = voivodeshipRepository
    }
    @RequestMapping("/role")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Role>> roles() {
        List<me.iolsh.membersapp.domain.membership.Role> roles = roleRepository.findAll()
        return ResponseEntity.ok(roles)
    }

    @RequestMapping("/memberStatus")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.MemberStatus>> membersStatuses() {
        List<me.iolsh.membersapp.domain.membership.MemberStatus> states = memberStatusRepository.findAll()
        return ResponseEntity.ok(states)
    }

    @RequestMapping("/paymentType")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.PaymentType>> paymentType() {
        List<me.iolsh.membersapp.domain.membership.PaymentType> types = paymentTypeRepository.findAll()
        return ResponseEntity.ok(types)
    }

    @RequestMapping("/currency")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Currency>> currencies() {
        List<me.iolsh.membersapp.domain.membership.Currency> currencies = currencyRepository.findAll()
        return ResponseEntity.ok(currencies)
    }

    @RequestMapping("/voivodeship")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Voivodeship>> voivodeships() {
        List<me.iolsh.membersapp.domain.membership.Voivodeship> voivodeships = voivodeshipRepository.findAll()
        return ResponseEntity.ok(voivodeships)
    }

    @RequestMapping("/region")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Region>> regions() {
        List<me.iolsh.membersapp.domain.membership.Region> regions = regionRepository.findAll()
        return ResponseEntity.ok(regions)
    }
}
