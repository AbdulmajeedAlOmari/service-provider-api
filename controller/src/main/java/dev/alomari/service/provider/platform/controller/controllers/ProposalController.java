package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.order.proposals.ProposalService;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Routes.PROPOSAL_ROUTE_V1)
public class ProposalController {

    private final ProposalService proposalService;

    @Autowired
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PreAuthorize("hasAuthority('PROPOSALS:LIST')")
    @GetMapping
    @JsonView({ List.SimpleList.class })
    public ResponseEntity<Page<Proposal>> listAllProposals(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(proposalService.listAllProposals(pageable));
    }

    @PreAuthorize("hasAuthority('PROPOSALS:VIEW')")
    @GetMapping("/{id}")
    @JsonView({ View.DetailedView.class })
    public ResponseEntity<Proposal> viewProposal(@PathVariable Long id) {
        return ResponseEntity.ok(proposalService.viewProposal(id));
    }

    @PreAuthorize("hasAuthority('PROPOSALS:ADD_ALL')")
    @PostMapping
    public ResponseEntity<Proposal> addProposal(@Valid @RequestBody Proposal proposal) {
        return ResponseEntity.ok(proposalService.addProposal(proposal));
    }

    @PreAuthorize("hasAuthority('PROPOSALS:REPLY')")
    @PutMapping("/{id}/approve")
    public ResponseEntity<Proposal> approveProposal(@PathVariable Long id) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasAuthority('PROPOSALS:REPLY')")
    @PutMapping("/{id}/reject")
    public ResponseEntity<Proposal> rejectProposal(@PathVariable Long id) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasAuthority('PROPOSALS:REPLY')")
    @DeleteMapping("/{id}/cancel")
    public ResponseEntity<Proposal> cancelProposal(@PathVariable Long id) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }
}