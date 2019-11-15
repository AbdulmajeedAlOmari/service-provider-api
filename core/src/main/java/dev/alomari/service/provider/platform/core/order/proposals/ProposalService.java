package dev.alomari.service.provider.platform.core.order.proposals;

import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProposalService {
    Page<Proposal> listAllProposals(Pageable pageable);

    Proposal viewProposal(Long proposalId);

    Proposal addProposal(Proposal proposal);

    Proposal acceptProposal(Long id);

    Proposal rejectProposal(Long id);
}
