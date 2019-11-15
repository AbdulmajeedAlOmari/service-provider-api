package dev.alomari.service.provider.platform.core.order.proposals;

import dev.alomari.service.provider.platform.core.common.config.properties.ProposalProperties;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.OrderRepository;
import dev.alomari.service.provider.platform.data.order.proposal.Proposal;
import dev.alomari.service.provider.platform.data.order.proposal.ProposalRepository;
import dev.alomari.service.provider.platform.data.order.proposal.ProposalStatus;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    private final OrderRepository orderRepository;
    private final ProposalProperties proposalProperties;

    @Autowired
    public ProposalServiceImpl(ProposalRepository proposalRepository, OrderRepository orderRepository, ProposalProperties proposalProperties) {
        this.proposalRepository = proposalRepository;
        this.orderRepository = orderRepository;
        this.proposalProperties = proposalProperties;
    }

    @Override
    public Page<Proposal> listAllProposals(Pageable pageable) {
        return proposalRepository.findAll(pageable);
    }

    @Override
    public Proposal viewProposal(Long proposalId) {
        return proposalRepository.findById(proposalId).orElseThrow(() -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND));
    }

    @Override
    @Transactional
    public Proposal addProposal(Proposal proposal) {
        User currentUser = SecurityUtil.getCurrentUser();

        // TODO: Activate checking from configurations
//        if(proposal.getPrice().compareTo(proposalProperties.getMaxPrice()) > 0) {
//            log.error(
//                    "Proposal from user id [ {} ] have exceeded maximum price allowed in config [ {} ]",
//                    currentUser.getId(),
//                    proposalProperties.getMaxPrice()
//            );
//
//            throw new ServiceProviderException(ServiceProviderError.INVALID_DATA_INPUT);
//        }

        if(proposal.getOrder() == null || proposal.getOrder().getId() == null) {
            log.error("Proposal from user id [ {} ] have not provided an order to map to it", currentUser.getId());
            throw new ServiceProviderException(ServiceProviderError.INVALID_DATA_INPUT);
        }

        Order order = orderRepository.findById(proposal.getOrder().getId()).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND)
        );

        proposal.setStatus(ProposalStatus.PENDING);
        proposal.setOrder(order);

        proposalRepository.save(proposal);

        return proposal;
    }

    @Transactional
    @Override
    public Proposal acceptProposal(Long id) {
        return updateProposalStatus(id, ProposalStatus.ACCEPTED);
    }

    @Transactional
    @Override
    public Proposal rejectProposal(Long id) {
        return updateProposalStatus(id, ProposalStatus.REJECTED);
    }


    /* ----[ Helper Methods ]---- */
    /*                            */
    private Proposal updateProposalStatus(Long id, ProposalStatus newStatus) {
        Proposal proposal = proposalRepository.findById(id).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND)
        );

        if(!proposal.getStatus().equals(ProposalStatus.PENDING)) {
            throw new ServiceProviderException(ServiceProviderError.PROPOSAL_IS_ALREADY_UPDATED);
        }

        proposal.setStatus(newStatus);

        proposalRepository.save(proposal);

        return proposal;
    }
}
