package me.iolsh.membersapp.rest


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
@RequestMapping('/api')
class ResolutionsController extends ControllerBase {

    private final me.iolsh.membersapp.repository.ResolutionRepository resolutionRepository;

    @Autowired
    ResolutionsController(me.iolsh.membersapp.repository.ResolutionRepository repository) {
        this.resolutionRepository = repository;
    }

    @RequestMapping("/r/a")
    @ResponseBody ResponseEntity<List<me.iolsh.membersapp.domain.membership.Resolution>> getAllPayments() {
        List<me.iolsh.membersapp.domain.membership.Resolution> resolutions = resolutionRepository.findAll();
        return ResponseEntity.ok(resolutions);
    }

}
