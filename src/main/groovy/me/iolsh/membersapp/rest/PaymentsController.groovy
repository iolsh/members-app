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
@RequestMapping('/api')
class PaymentsController extends ControllerBase {

    private final me.iolsh.membersapp.repository.PaymentRepository paymentRepository;

    @Autowired
    PaymentsController(me.iolsh.membersapp.repository.PaymentRepository repository) {
        this.paymentRepository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/p/a")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Payment>> getAllPayments() {
        List<me.iolsh.membersapp.domain.membership.Payment> payments = paymentRepository.findAll();
        return ResponseEntity.ok(payments);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/p/bc")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.dto.AmountPerCurrency>> getPaymentsByCurrency() {
        List<me.iolsh.membersapp.domain.dto.AmountPerCurrency> apcs = new ArrayList<>();
        Map<me.iolsh.membersapp.domain.membership.Currency, BigDecimal> paymentsByCurrency = new HashMap<>();
        List<me.iolsh.membersapp.domain.membership.Payment> payments = paymentRepository.findAll();

        for (me.iolsh.membersapp.domain.membership.Payment payment : payments) {
            BigDecimal newAmount = (paymentsByCurrency.get(payment.currency) == null) ? payment.amount
                : paymentsByCurrency.get(payment.currency).add(payment.amount)
            paymentsByCurrency.put(payment.currency, newAmount)
        }
        for (me.iolsh.membersapp.domain.membership.Currency currency : paymentsByCurrency.keySet()) {
            apcs.add(new me.iolsh.membersapp.domain.dto.AmountPerCurrency(currency, paymentsByCurrency.get(currency)))
        }
        return ResponseEntity.ok(apcs);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/p/m/{memberId}")
    @ResponseBody ResponseEntity<me.iolsh.membersapp.domain.membership.Payment> getByMemberId(@PathVariable Long memberId) {
        me.iolsh.membersapp.domain.membership.Payment payment = paymentRepository.findByMemberId(memberId)
        return ResponseEntity.ok(payment)
    }

    @RequestMapping(method=RequestMethod.POST, value = "/p/add")
    @ResponseBody ResponseEntity<me.iolsh.membersapp.domain.membership.Payment> addPayment(@RequestBody me.iolsh.membersapp.domain.membership.Payment payment) {
        try {
            System.out.println('Payment: ' + payment.toString());
            paymentRepository.save(payment)
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
