package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.order.proposals.ProposalService;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
import dev.alomari.service.provider.platform.utility.constants.Routes;
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

    @PreAuthorize("hasAuthority('ORDERS:VIEW')")
    @GetMapping
    @JsonView({ List.SimpleList.class })
    public ResponseEntity<Page<Proposal>> listAllProposals(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(proposalService.listAllProposals(pageable));
    }

    @PreAuthorize("hasAuthority('ORDERS:VIEW')")
    @GetMapping("/{proposalId}")
    @JsonView({ View.DetailedView.class })
    public ResponseEntity<Proposal> viewProposal(@PathVariable Long proposalId) {
        return ResponseEntity.ok(proposalService.viewProposal(proposalId));
    }

    @PreAuthorize("hasAuthority('ORDERS:VIEW')")
    @PostMapping
    public ResponseEntity<Proposal> addProposal(@Valid @RequestBody Proposal proposal) {
        return ResponseEntity.ok(proposalService.addProposal(proposal));
    }
}