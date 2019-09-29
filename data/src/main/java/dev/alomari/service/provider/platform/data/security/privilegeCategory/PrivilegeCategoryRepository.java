package dev.alomari.service.provider.platform.data.security.privilegeCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeCategoryRepository extends JpaRepository<PrivilegeCategory, Short> {
}
